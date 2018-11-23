/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

/**
 *
 * @author HUBERT Gilles, TASSART Jean-Florian
 */
public final class Jeu
{
    private final Score<Points> score = new Score<>(new Points(), new Points());
    private final Joueur serveur;
    private final Joueur receveur;
    private final Arbitre arbitre;
    
    public Jeu(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        serveur = joueur1;
        receveur = joueur2;
        this.arbitre = arbitre;
    }
    
    public final void jouer()
    {
        arbitre.ennoncerServeur(serveur);
        while(!score.get(1).get().equals(PointsEnum.GAGNE) && !score.get(2).get().equals(PointsEnum.GAGNE))
        {
            echange();
        }
        arbitre.ennoncerScore(score);
    }
    
    public final void echange()
    {
        arbitre.ennoncerScore(score);
        final Float alea = (float) Math.random();
        if (alea < 0.5)
        {
            arbitre.parler("Point : " + serveur.getNom());
            Score.incremente(score, 1);
        }
        else
        {
            arbitre.parler("Point : " + receveur.getNom());
            Score.incremente(score, 2);
        }
    }
}

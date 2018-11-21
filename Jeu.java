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
    Score score = new Score<>(new Points(), new Points());
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
        echange();
    }
    
    public final void echange()
    {
        arbitre.ennoncerScore(score);
    }
}

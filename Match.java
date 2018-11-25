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
public class Match
{
    private final Score<Integer>[] scoresSet = new Score[5];
    private final Score<Integer> score = new Score<>(0, 0);
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    private Boolean nbJeuPair;
    
    public Match(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
        setNbJeuPeir(true);
    }
    
    public final void setNbJeuPeir(Boolean bool)
    {
        nbJeuPair = bool;
    }
    
    public final Boolean getNbJeuPair()
    {
        return nbJeuPair;
    }
    
    public final void jouer()
    {
        Integer nbSet = 0;
        while(score.get(1).compareTo(3) < 0 && score.get(2).compareTo(3) < 0)
        {
            Set set = new Set(joueur1, joueur2, arbitre, nbJeuPair);
            scoresSet[nbSet] = set.jouer();
            nbSet++;
            setNbJeuPeir((scoresSet[nbSet].get(1) + scoresSet[nbSet].get(2))%2 == 0);
            Score.incremente(score, scoresSet[nbSet].get(1)>scoresSet[nbSet].get(2) ? 1 : 2);
        }
        arbitre.parler("Jeu " + (score.get(1) > score.get(2) ? joueur1.getNom() : joueur2.getNom()));
    }
}
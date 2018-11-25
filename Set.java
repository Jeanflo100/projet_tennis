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
public class Set
{
    private final Score<Integer> score = new Score<>(0, 0);
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    private Boolean serviceJ1;
    
    public Set(Joueur joueur1, Joueur joueur2, Arbitre arbitre, Boolean serviceJ1)
    {
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
        setNbJeuPeir(serviceJ1);
    }
    
    public final void setNbJeuPeir(Boolean bool)
    {
        serviceJ1 = bool;
    }
    
    public final Boolean getServiceJ1()
    {
        return serviceJ1;
    }
    
    public final Score<Integer> jouer()
    {
        while(((score.get(1).compareTo(6) < 0 && score.get(2).compareTo(6) < 0) || (Math.abs(score.get(1)-score.get(2)) < 2)) && !(score.get(1).equals(6) && score.get(2).equals(6)))
        {
            Jeu jeu = serviceJ1 ? new Jeu(joueur1, joueur2, arbitre) : new Jeu(joueur2, joueur1, arbitre);
            Score.incremente(score, jeu.jouer() == serviceJ1 ? 1 : 2);
            setNbJeuPeir(!getServiceJ1());
        }
        if(score.get(1).equals(score.get(2)))
        {
            Tie_Break jeu = new Tie_Break(joueur1, joueur2, arbitre);
            Score.incremente(score, jeu.jouer() ? 1 : 2);
        }
        arbitre.parler("Set " + (score.get(1) > score.get(2) ? joueur1.getNom() : joueur2.getNom()));
        return score;
    }
}
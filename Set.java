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
    private Boolean nbJeuPair = true;
    
    public Set(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.arbitre = arbitre;
    }
    
    public final void setNbJeuPeir(Boolean bool)
    {
        nbJeuPair = bool;
    }
    
    public final Boolean getNbJeuPair()
    {
        return nbJeuPair;
    }
    
    /*public final void jouer()
    {
        while(score.get(1).compareTo(6) < 0 && score.get(2).compareTo(6) < 0)
        {
            Boolean test = new Jeu
        }
    }*/
}
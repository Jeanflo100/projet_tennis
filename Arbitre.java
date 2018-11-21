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
public final class Arbitre extends Personne
{
    public Arbitre()
    {
        super();
    }
    
    public final void ennoncerServeur(Joueur joueur)
    {
        parler("Service : " + joueur.getNom());
    }
    public final void ennoncerScore(Score score)
    {
        parler(score);
    }
    public final void signalerFaute()
    {
        
    }
    public final void repondAuJoueur()
    {
        
    }
    
    @Override
    public final void parler(Object texte)
    {
        parler("Arbitre " + getNom().toUpperCase(), texte);
    }
}

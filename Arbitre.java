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
    
    public Arbitre(Genre genre, String prenom, String nomCourant, String nomNaissance, Date dateNaissance, String lieuNaissance, String nationalite, Float taille, Float poids){
        super(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, null);
    }
    
    public Arbitre(Arbitre arbitre)
    {
        super(arbitre);
    }
    
    public final void ennoncerServeur(Joueur joueur)
    {
        parler("Service : " + joueur.getNom());
    }
    public final void signalerFaute()
    {
        
    }
    public final void repondAuJoueur()
    {
        
    }
    
    @Override
    public String toString()
    {
        return "Arbitre " + getNom();
    }
}

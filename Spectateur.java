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
public final class Spectateur extends Personne
{    
    public Spectateur()
    {
        super();
    }
    
    public Spectateur(Genre genre, String prenom, String nomCourant, String nomNaissance, Date dateNaissance, String lieuNaissance, String nationalite, Float taille, Float poids, Couleur couleur){
        super(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, couleur);
    }
    
    public void applaudir(){
        System.out.println("CLAP ! CLAP ! CLAP !");
    }
    
    public void crier(){
        System.out.println("Hourra !");
    }
    
    public void huer(){
        System.out.println("HOUUUU !");
    }
    
    public void dormir(){
        
    }
}

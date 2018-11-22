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
public class Projet_Tennis
{  
    public static void main(String[] args)
    {
        /*Sponsor test[] = new Sponsor[5];
        for (Sponsor sponsor : test) {
            System.out.println(sponsor);
        }*/
        for (int i = 0; i<10; i++){
            Personne test = new Personne();
            Joueur test2 = new Joueur();
            System.out.println(test.getGenre() + " : " + test.getNomNaissance() + " --> " + test.getNomCourant());
            System.out.println(test2.getMain());
        }
    }
}
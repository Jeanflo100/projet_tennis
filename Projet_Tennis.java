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
        /*
            Je te propose qu'on ait chacun son main dans un bloc commentaire que l'on décommente quand on en a besoin, comme ça, on gère chacun le sien ;) Efface ce commentaire, il ne sert plus à rien maintenant :p
        */
        
        // Jeanflo
        /*
        Sponsor test[] = new Sponsor[5];
        for (Sponsor sponsor : test) {
            System.out.println(sponsor);
        }
        
        for (int i = 0; i<10; i++){
            Personne test = new Personne();
            Joueur test2 = new Joueur();
            System.out.println(test.getGenre() + " : " + test.getNomNaissance() + " --> " + test.getNomCourant());
            System.out.println(test2.getMain());
        }
        */
        
        // Gillou
        
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        Joueur joueur3 = new Joueur();
        
        System.out.println(joueur1 + " " + joueur1.getID());
        System.out.println(joueur2 + " " + joueur2.getID());
        System.out.println(joueur3 + " " + joueur3.getID());
        
        joueur2.setPoints(10);
        joueur1.setPoints(20);
        
        Joueur[] classement = Joueur.getClassement();
        for(Integer i = 0; i < classement.length; i++)
        {
            System.out.println(classement[i].getRang() + "\t" + classement[i].getPoints() + "\t" + classement[i].getID() + "\t" + classement[i] + "\t");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

import java.util.Scanner;

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
        
        creationJoueurs();
        
        // Gillou
        
        /*Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        Arbitre arbitre = new Arbitre();
        
        System.out.println(joueur1 + " " + joueur1.getID());
        System.out.println(joueur2 + " " + joueur2.getID());
        System.out.println(arbitre + " " + arbitre.getID());
        System.out.println();
        
        Jeu test = new Jeu(joueur1, joueur2, arbitre);
        test.jouer();*/
        
    }
    
    private static final void creationJoueurs(){
            System.out.println("Bonjour et bienvenue dans le Championnat de Tennis du 'Grand Chelem'");
            System.out.println("Commençons tout d'abord par créer les joueurs du tournoi masculin : ");
            System.out.println("Souhaitez-vous en créer un ou les faire aléatoirement ? (o/n)");
            Scanner sc = new Scanner(System.in);
            String reponse = sc.nextLine();
            if (reponse.equals("o")){
                System.out.println("5");
            }
            else {
                System.out.println("4");
            }
        }
    
}

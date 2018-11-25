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
        // Jeanflo
        
        //creationJoueurs();
        
        // Gillou
        
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        Arbitre arbitre = new Arbitre();
        
        System.out.println(joueur1);
        System.out.println(joueur2);
        System.out.println(arbitre);
        System.out.println();
        
        System.out.println("Classement :");
        for(Joueur joueur : Joueur.getClassement())
        {
            System.out.println("\t" + joueur.getRang() + "\t" + joueur.getPoints() + "\t" + joueur.getNom() + " " + joueur.getPrenom());
        }
        System.out.println();
        
        System.out.println(m);
        /*Match test = new Match(joueur1, joueur2, arbitre);
        test.jouer();*/
    }
    
    public static final void creationJoueurs(){
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

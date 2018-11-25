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
    public static String buff;
    private static Integer nb_joueurs = 0;
    private static Integer nb_joueuses = 0;
    private static Integer nb_joueurs_total = 128;
    private static Integer nb_joueuses_total = 128;
    private static Joueur[] joueurs = new Joueur[nb_joueurs_total];
    private static Joueur[] joueuses = new Joueur[nb_joueuses_total];
    private static Integer nb_arbitres = 0;
    private static Integer nb_arbitres_total = 10;
    private static Arbitre[] arbitres = new Arbitre[nb_arbitres_total];
    private static Integer nb_spectateurs = 0;
    private static Integer nb_spectateurs_total = 100;
    private static Spectateur[] spectateurs = new Spectateur[nb_arbitres_total];
    
    public static void main(String[] args)
    {        
        // Jeanflo
        
        creationPersonnages();
        System.out.println(joueurs[54]);
        System.out.println(joueurs[127]);
        System.out.println(joueuses[0]);
        System.out.println(joueuses[100]);
        System.out.println("");
        
        // Gillou
        /*Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        Arbitre arbitre = new Arbitre();
        
        Match test = new Match(joueur1, joueur2, arbitre, TournoisEnum.AU);
        test.jouer();*/
        
    }
    
    private static final void creationPersonnages(){
        System.out.println("Bonjour et bienvenue dans le Championnat de Tennis du \"Grand Chelem\"");
        System.out.println("Commençons tout d'abord par créer les joueurs du tournoi masculin");
        System.out.print("Souhaitez-vous en créer un ou les faire aléatoirement ? (o/n) : ");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();
        while (reponse.equals("o") && (nb_joueurs < nb_joueurs_total)){
            creationPersonnagePersonnalise<Joueur>(Genre.Homme);
            System.out.print("Souhaitez-vous créer un autre joueur personnalisé ? (o/n) : ");
            reponse = sc.nextLine();
        }
        for (int i = nb_joueurs; i<nb_joueurs_total; i++){
            joueurs[nb_joueurs] = new Joueur(Genre.Homme);
            nb_joueurs++;
        }
        System.out.println("Tous les joueurs ont été créé !");
        System.out.println("");
        System.out.println("Poursuivons avec la création des joueuses du tournoi féminin");
        System.out.print("Souhaitez-vous en créer une ou les faire aléatoirement ? (o/n) : ");
        sc = new Scanner(System.in);
        reponse = sc.nextLine();
        while (reponse.equals("o") && (nb_joueuses < nb_joueuses_total)){
            //creationJoueurPersonnalise(Genre.Femme);
            System.out.print("Souhaitez-vous créer une autre joueuse personnalisée ? (o/n) : ");
            reponse = sc.nextLine();
        }
        for (int i = nb_joueuses; i<nb_joueuses_total; i++){
            joueuses[nb_joueuses] = new Joueur(Genre.Femme);
            nb_joueuses++;
        }
        System.out.println("Toutes les joueuses ont été créé !");
        System.out.println("");
        System.out.println("Créons maintenant les arbitres");
        System.out.print("Souhaitez-vous en créer un ou les faire aléatoirement ? (o/n) : ");
        sc = new Scanner(System.in);
        reponse = sc.nextLine();
        while (reponse.equals("o") && (nb_arbitres < nb_arbitres_total)){
            //creationJoueurPersonnalise(Genre.Femme);
            System.out.print("Souhaitez-vous créer un autre arbitre personnalisé ? (o/n) : ");
            reponse = sc.nextLine();
        }
        for (int i = nb_arbitres; i<nb_arbitres_total; i++){
            arbitres[nb_arbitres] = new Arbitre();
            nb_arbitres++;
        }
        System.out.println("Que serait un match sans spectateur ! Finisons en créant les spectateurs");
        System.out.print("Souhaitez-vous en créer un ou les faire aléatoirement ? (o/n) : ");
        sc = new Scanner(System.in);
        reponse = sc.nextLine();
        while (reponse.equals("o") && (nb_spectateurs < nb_spectateurs_total)){
            //creationJoueurPersonnalise(Genre.Femme);
            System.out.print("Souhaitez-vous créer un autre spectateur personnalisé ? (o/n) : ");
            reponse = sc.nextLine();
        }
        for (int i = nb_spectateurs; i<nb_spectateurs_total; i++){
            spectateurs[nb_spectateurs] = new Spectateur();
            nb_spectateurs++;
        }
    }
    
    private static final void creationPersonnagePersonnalise<Object>(Genre genre){
        System.out.println("Creation " + (genre == Genre.Homme ? "d'un joueur personnalisé" : "d'une joueuse personnalisée") + ", Veuillez entrer :");
        /*if (type instanceof Joueur){
            System.out.println("1");
        }
        if (type instanceof Arbitre){
            System.out.println("2");
        }*/
        System.out.print("Son prénom : ");
        Scanner sc = new Scanner(System.in);
        String prenom = sc.nextLine();
        System.out.print("Son nom courant : ");
        String nomCourant = sc.nextLine();
        String nomNaissance = "";
        if (genre == Genre.Femme){
            System.out.print("Etant une joueuse, voulez-vous lui donner un nom de naissance différent ? (mettre 'n' pour garder le même nom, entrez le nouveau nom sinon) : ");
            nomNaissance = sc.nextLine();
            if (nomNaissance.equals("n")){
                nomNaissance = nomCourant;
            }   
        }
        System.out.println("Sa date de naissance :");
        System.out.print("--> Jour : ");
        Integer jour = sc.nextInt();
        System.out.print("--> Mois : ");
        Integer mois = sc.nextInt();
        System.out.print("--> Année : ");
        Integer annee = sc.nextInt();
        Date dateNaissance = new Date(jour, mois, annee);
        System.out.print("Son lieu de naissance (ville) : ");
        buff = sc.nextLine();
        String lieuNaissance = sc.nextLine();
        System.out.print("Sa nationalité (en anglais) : ");
        String nationalite = sc.nextLine();
        System.out.print("Sa taille (en cm) : ");
        Float taille = sc.nextFloat();
        System.out.print("Son poids (en kg) : ");
        Float poids = sc.nextFloat();
        System.out.print("La couleur de " + (genre == Genre.Homme ? "son T-shirt" : "sa jupe") + " : ");
        buff = sc.nextLine();
        String couleur_str = sc.nextLine();
        while (Couleur.fromString(couleur_str) == null){
            System.out.print("Veuillez entrer une nouvelle couleur : ");
            couleur_str = sc.nextLine();
        }
        Couleur couleur = Couleur.fromString(couleur_str);
        System.out.print("Sa main (droite ou gauche) : ");
        String main_str = sc.nextLine();
        while (Main.fromString(main_str) == null){
            System.out.print("Veuillez entrer de nouveau sa main (droite ou gauche) : ");
            main_str = sc.nextLine();
        }
        Main main = Main.fromString(main_str);
        switch (genre){
            case Homme :    joueurs[nb_joueurs] = new Joueur(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, couleur, main);
                            nb_joueurs++;
                            break;
            case Femme :    joueuses[nb_joueuses] = new Joueur(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, couleur, main);
                            nb_joueuses++;
                            break;
        }
        System.out.println((genre == Genre.Homme ? "Le joueur personnalisé" : "La joueuse personnalisée") + " a été créé avec succés !");
        System.out.println("");
    }
}

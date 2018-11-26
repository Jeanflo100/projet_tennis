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
    private static Integer nb_spectateurs_total = 300;
    private static Spectateur[] spectateurs = new Spectateur[nb_spectateurs_total];
    
    public static void main(String[] args) throws InterruptedException
    {        
        // Jeanflo
        
        creationPersonnages();
        Tournois tournois = new Tournois(TournoisEnum.US, joueurs, arbitres);
        Joueur vainqueur = tournois.jouer();
        System.out.println(vainqueur);
                
                // Gillou
                /*for(TournoisEnum tournois : TournoisEnum.values())
                {
                System.out.println(tournois);
                }*/;
        
    }
    
    private static final void creationPersonnages(){
        System.out.println("Bonjour et bienvenue dans le Championnat de Tennis du \"Grand Chelem\"");
        System.out.println("Commençons tout d'abord par créer les joueurs du tournoi masculin");
        System.out.print("Souhaitez-vous en créer un ou les faire aléatoirement ? (o/n) : ");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();
        while (reponse.equals("o") && (nb_joueurs < nb_joueurs_total)){
            creationPersonnagePersonnalise("joueur", Genre.Homme);
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
            creationPersonnagePersonnalise("joueur", Genre.Femme);
            System.out.print("Souhaitez-vous créer une autre joueuse personnalisée ? (o/n) : ");
            reponse = sc.nextLine();
        }
        for (int i = nb_joueuses; i<nb_joueuses_total; i++){
            joueuses[nb_joueuses] = new Joueur(Genre.Femme);
            nb_joueuses++;
        }
        System.out.println("Toutes les joueuses ont été créé !");
        System.out.println("");
        System.out.println("Créons maintenant quelques arbitres !");
        System.out.print("Souhaitez-vous en créer un ou les faire aléatoirement ? (o/n) : ");
        sc = new Scanner(System.in);
        reponse = sc.nextLine();
        while (reponse.equals("o") && (nb_arbitres < nb_arbitres_total)){
            creationPersonnagePersonnalise("arbitre", null);
            System.out.print("Souhaitez-vous créer un autre arbitre personnalisée ? (o/n) : ");
            reponse = sc.nextLine();
        }
        for (int i = nb_arbitres; i<nb_arbitres_total; i++){
            arbitres[nb_arbitres] = new Arbitre();
            nb_arbitres++;
        }
        System.out.println("Tous les arbitres ont été créé !");
        System.out.println("");
        System.out.println("Finissons avec la création des spectateurs !");
        System.out.print("Souhaitez-vous en créer un ou les faire aléatoirement ? (o/n) : ");
        sc = new Scanner(System.in);
        reponse = sc.nextLine();
        while (reponse.equals("o") && (nb_spectateurs < nb_spectateurs_total)){
            creationPersonnagePersonnalise("spectateur", null);
            System.out.print("Souhaitez-vous créer un autre spectateur personnalisée ? (o/n) : ");
            reponse = sc.nextLine();
        }
        for (int i = nb_spectateurs; i<nb_spectateurs_total; i++){
            spectateurs[nb_spectateurs] = new Spectateur();
            nb_spectateurs++;
        }
        System.out.println("Tous les spectateurs ont été créé !");
        System.out.println("");
    }
    
    private static final void creationPersonnagePersonnalise(String type, Genre genre){
        System.out.println("Phase de personnalisation, Veuillez entrer :");
        Scanner sc = new Scanner(System.in);
        if (genre == null){
            System.out.print("Son genre (homme ou femme) : ");
            String genre_str = sc.nextLine();
            while (Genre.fromString(genre_str) == null){
                System.out.print("Veuillez entrer de nouveau son genre (homme ou femme) : ");
                genre_str = sc.nextLine();
            }
            genre = Genre.fromString(genre_str);
        }
        System.out.print("Son prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Son nom courant : ");
        String nomCourant = sc.nextLine();
        String nomNaissance = null;
        if (genre == Genre.Femme){
            System.out.print("Etant une femme, voulez-vous lui donner un nom de naissance différent ? (mettre 'n' pour garder le même nom, entrez le nouveau nom sinon) : ");
            nomNaissance = sc.nextLine();
            if (nomNaissance.equals("n")){
                nomNaissance = nomCourant;
            }   
        }
        else {
            nomNaissance = nomCourant;
        }
        System.out.println("Sa date de naissance :");
        System.out.print("--> Année : ");
        Integer annee = null;
        while (annee == null) {
            try {
                annee = sc.nextInt();
                if (annee < 1970 || annee > 2000){
                    System.out.print("Veuillez entrer une année comprise entre 1970 et 2000 pour avoir des joueurs pouvant réellement jouer : ");
                    annee = null;
                }
            }catch(Exception e){
                System.err.print("Veuillez entrez une année en chiffre : ");
            }
        }
        System.out.print("--> Mois : ");
        Integer mois = null;
        while (mois == null) {
            try {
                mois = sc.nextInt();
                if (mois < 0 || mois > 12){
                    System.out.print("Veuillez entrer une année comprise entre 1 et 12 : ");
                    mois = null;
                }
            }catch(Exception e){
                System.out.println("Veuillez entrez un mois en chiffre");
            }
        }
        System.out.print("--> Jour : ");
        Integer jour = null;
        while (jour == null) {
            try {
                jour = sc.nextInt();
                switch (mois){
                    case 2 : if (jour < 0 || jour > 28){
                                System.out.print("Veuillez entrer un jour comprise entre 1 et 28 : ");
                                jour = null;
                            }
                            break;
                    default : if (jour < 0 || jour > 31){
                                System.out.print("Veuillez entrer un jour comprise entre 1 et 31 : ");
                                jour = null;
                            }
                }
            }catch(Exception e){
                System.out.println("Veuillez entrez un jour en chiffre");
            }
        }
        Date dateNaissance = new Date(jour, mois, annee);
        System.out.print("Son lieu de naissance (ville) : ");
        buff = sc.nextLine();
        String lieuNaissance = sc.nextLine();
        System.out.print("Sa nationalité (en anglais) : ");
        String nationalite = sc.nextLine();
        System.out.print("Sa taille (en cm) : ");
        Float taille = null;
        while (taille == null) {
            try {
                taille = sc.nextFloat();
                if (taille < 150 || taille > 250){
                    System.out.print("Veuillez entrer une taille comprise entre 150 et 250 : ");
                    taille = null;
                }
            }catch(Exception e){
                System.out.println("Veuillez entrez une taille en chiffre");
            }
        }
        System.out.print("Son poids (en kg) : ");
        Float poids = null;
        while (poids == null) {
            try {
                poids = sc.nextFloat();
                if (poids < 50 || poids > 100){
                    System.out.print("Veuillez entrer une taille comprise entre 50 et 100 : ");
                    poids = null;
                }
            }catch(Exception e){
                System.out.println("Veuillez entrez un poids en chiffre");
            }
        }
        Couleur couleur = null;
        if (type != "arbitre"){
            switch (type){
                case "joueur" : System.out.print("La couleur de " + (genre == Genre.Homme ? "son short" : "sa jupe") + " : ");break;
                case "spectateur" : System.out.print("La couleur de " + (genre == Genre.Homme ? "sa chemise" : "ses lunettes") + " : ");break;
            }
            buff = sc.nextLine();
            String couleur_str = sc.nextLine();
            while (Couleur.fromString(couleur_str) == null){
                System.out.print("Veuillez entrer une nouvelle couleur : ");
                couleur_str = sc.nextLine();
            }
            couleur = Couleur.fromString(couleur_str);
        }
        Main main = null;
        if(type == "joueur"){
            System.out.print("Sa main (droite ou gauche) : ");
            String main_str = sc.nextLine();
            while (Main.fromString(main_str) == null){
                System.out.print("Veuillez entrer de nouveau sa main (droite ou gauche) : ");
                main_str = sc.nextLine();
            }
            main = Main.fromString(main_str);
        }
        switch (type){
            case "joueur" : switch (genre){
                                case Homme :    joueurs[nb_joueurs] = new Joueur(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, couleur, main);
                                                nb_joueurs++;
                                                break;
                                case Femme :    joueuses[nb_joueuses] = new Joueur(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, couleur, main);
                                                nb_joueuses++;
                                                break;
                            }
            case "arbitre" : arbitres[nb_arbitres] =    new Arbitre(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids);
                                                        break;
            case "spectateur" : spectateurs[nb_spectateurs] =   new Spectateur(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, couleur);
                                                                break;
        }
        System.out.println("Phase de personnalisation réussi avec succès !");
        System.out.println("");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author HUBERT Gilles, TASSART Jean-Florian
 */
public class Personne
{
    // Constantes de la classe    
    
    private static final Integer NB_PRENOMS = initNbPrenoms();
    private static final Integer NB_NOMS = initNbNoms();
    private static final Integer NB_VILLES = initNbVilles();
    private static Integer nbPersonne = 0;
    private static Personne lastSpeaker;
    
    
    
    private final Integer ID;
    private final String prenom;
    private final String nomNaissance;
    private final Date dateNaissance;
    private final String lieuNaissance;
    private final Genre genre;
    private String surnom;
    private String nomCourant;
    private String nationalite;
    private Float taille;
    private Float poids;
    private Date dateDeces;
    private Couleur couleur;
    
    
    public Personne()
    {
        incrementeNbPersonne();
        ID = getNbPersonne();
        genre = Genre.values()[(int) (Math.random() * Genre.values().length)];
        
        prenom = generationPrenom();        // Générera aussi la nationalité
        nomNaissance = generationNom();
        setNomCourant(nomNaissance);
        
        dateNaissance = Date.dateAleatoire(new Date(1, 1, 1970), new Date(1, 1, 2000));
        lieuNaissance = generationVille();
        
        setTaille(150 + (float) Math.random() * (200 - 150));
        setPoids(50 + (float) Math.random() * (100 - 50));
        setCouleur(Couleur.values()[(int) (Math.random() * Couleur.values().length)]); 
    }
    
    public Personne(Genre genre)
    {
        incrementeNbPersonne();
        ID = getNbPersonne();
        this.genre = genre;
        
        prenom = generationPrenom();        // Générera aussi la nationalité
        nomNaissance = generationNom();
        setNomCourant(nomNaissance);
        
        dateNaissance = Date.dateAleatoire(new Date(1, 1, 1970), new Date(1, 1, 2000));
        lieuNaissance = generationVille();
        
        setTaille(150 + (float) Math.random() * (200 - 150));
        setPoids(50 + (float) Math.random() * (100 - 50));
        setCouleur(Couleur.values()[(int) (Math.random() * Couleur.values().length)]);
    }
    
    public Personne(Genre genre, String prenom, String nomCourant, String nomNaissance, Date dateNaissance, String lieuNaissance, String nationalite, Float taille, Float poids, Couleur couleur){
        incrementeNbPersonne();
        ID = getNbPersonne();
        this.genre = genre;
        
        this.prenom = prenom;
        this.nomCourant = nomCourant;
        this.nomNaissance = nomNaissance;
        
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        
        this.taille = taille;
        this.poids = poids;
        setCouleur(couleur);
    }
    
    public Personne(Personne personne)
    {
        ID = personne.getID();
        genre = personne.getGenre();
        
        prenom = personne.getPrenom();
        nomNaissance = personne.getNomNaissance();
        copieNomCourant(personne.getNomCourant());
        
        dateNaissance = personne.getDateNaissance();
        lieuNaissance = personne.getLieuNaissance();
        setNationalite(personne.getNationalite());
        
        setTaille(personne.getTaille());
        setPoids(personne.getPoids());
        setCouleur(personne.getCouleur());
    }
    
    public static final Integer getNbPersonne()
    {
        return nbPersonne;
    }
    
    public final Integer getID()
    {
        return ID;
    }
    
    public final Genre getGenre()
    {
        return genre;
    }
    
    public final Integer getAge()
    {
        if(dateDeces == null)
        {
            Date dateActuelle = new Date();
            return dateActuelle.difference(dateNaissance).getAnnee();
        }
        return dateDeces.difference(dateNaissance).getAnnee();
    }
    
    public final String getPrenom()
    {
        return prenom;
    }
    
    public final String getNomNaissance()
    {
        return nomNaissance.toUpperCase();
    }
    
    public final String getNomCourant()
    {
        return nomCourant.toUpperCase();
    }
    
    public final String getNom()
    {
        return getNomCourant();
    }
    
    public final Float getTaille()
    {
        return taille;
    }
    
    public final Float getPoids()
    {
        return poids;
    }
    
    public final Couleur getCouleur()
    {
        return couleur;
    }
    
    public final String getLieuNaissance()
    {
        return lieuNaissance;
    }
    
    public final String getNationalite()
    {
        return nationalite;
    }
    
    public final Date getDateNaissance()
    {
        return new Date(dateNaissance);
    }
    
    public static final Personne getLastSpeaker()
    {
        return lastSpeaker == null ? null : new Personne(lastSpeaker);
    }
    
    public final void setNationalite(String nationalite)
    {
        this.nationalite = nationalite;
    }
    
    public final void setTaille(Float taille)
    {
        if(taille <= 0)
        {
            System.err.println("La taille doit être strictement positive.");
            return;
        }
        this.taille = taille;
    }
    
    public final void setPoids(Float poids)
    {
        if(poids <= 0)
        {
            System.err.println("Le poids doit être strictement positive.");
            return;
        }
        this.poids = poids;
    }
    
    public final void setCouleur(Couleur couleur)
    {
        this.couleur = couleur;
    }
    
    public final void setNomCourant(String nom)
    {
        if (getGenre() == Genre.Femme && Math.random() < 0.15){
            this.nomCourant = generationNom();
        }
        else
        {
            this.nomCourant = nom;
        }
    }
    
    public final void copieNomCourant(String nom)
    {
        nomCourant = nom;
    }
    
    public final void setNom(String nom)
    {
        setNomCourant(nom.toUpperCase());
    }
    
    private static final Integer initNbPrenoms(){
        try{
            InputStream flux = new FileInputStream("src\\projet_tennis\\Prenoms.txt"); 
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            int i = 0;
            while (buff.readLine() != null)
            {
                i++;
            }
            buff.close();
            return(i);
        }		
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return(null);
    }
    
    private static final Integer initNbNoms(){
        try{
            InputStream flux = new FileInputStream("src\\projet_tennis\\Noms.txt"); 
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            int i = 0;
            while (buff.readLine() != null)
            {
                i++;
            }
            buff.close();
            return(i);
        }		
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return(null);
    }
    
    private static final Integer initNbVilles(){
        try{
            InputStream flux = new FileInputStream("src\\projet_tennis\\Villes.txt"); 
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            int i = 0;
            while (buff.readLine() != null)
            {
                i++;
            }
            buff.close();
            return(i);
        }		
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return(null);
    }
    
    private final String generationPrenom(){
        try{
            String terme = "";
            String prenom;
            Genre genre;
            String nationalite;
            int nb_aleatoire;
            int ligne;
            char caractere;
            do{
                InputStream flux = new FileInputStream("src\\projet_tennis\\Prenoms.txt"); 
                InputStreamReader lecture = new InputStreamReader(flux);
                BufferedReader buff = new BufferedReader(lecture);
                nb_aleatoire = (int) (Math.random() * NB_PRENOMS);
                ligne = 0;
                while (ligne < nb_aleatoire)
                {
                    buff.readLine();
                    ligne++;
                }
                terme = "";
                while ((caractere = (char) buff.read()) != '\t'){
                    terme += caractere;
                }
                prenom = terme;
                terme = "";
                while ((caractere = (char) buff.read()) == '\t'){
                    continue;
                }
                terme += caractere;
                while ((caractere = (char) buff.read()) != '\t'){
                    terme += caractere;
                }
                switch (terme){
                    case "m": genre = Genre.Homme;break;
                    case "f": genre = Genre.Femme;break;
                    default: genre = null;
                }
                terme = "";
                while ((caractere = (char) buff.read()) == '\t'){
                    continue;
                }
                terme += caractere;
                while ((caractere = (char) buff.read()) != '\t' && caractere != '(' && caractere != ',' && caractere != '\n'){
                    terme += caractere;
                }
                try {
                    Double.valueOf(terme);
                    nationalite = "french";
                }catch(NumberFormatException e){
                    nationalite = terme;
                }
                buff.close();
            }while(getGenre() != genre && genre != null);
            setNationalite(nationalite);
            return(prenom);
        }		
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return(null);
    }
    
    protected final String generationNom(){
        try{
            InputStream flux = new FileInputStream("src\\projet_tennis\\Noms.txt"); 
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            int nb_aleatoire = (int) (Math.random() * NB_NOMS);
            int i = 0;
            String nom = "";
            char caractere;
            while (i < nb_aleatoire)
            {
                buff.readLine();
                i++;
            }
            while ((caractere = (char) buff.read()) != '\t' && caractere != ' '){
                nom += caractere;
            }
            buff.close();
            return(nom.toUpperCase());
        }		
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return(null);
    }
    
    private final String generationVille(){
        try{
            InputStream flux = new FileInputStream("src\\projet_tennis\\Villes.txt"); 
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            int nb_aleatoire = (int) (Math.random() * NB_VILLES);
            int i = 0;
            String ville = "";
            char caractere;
            while (i < nb_aleatoire)
            {
                buff.readLine();
                i++;
            }
            while ((caractere = (char) buff.read()) != '\n'){
                ville += caractere;
            }
            buff.close();
            return(ville);
        }		
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return(null);
    }
    
    private static final void setLastSpeaker(Personne personne)
    {
        lastSpeaker = new Personne(personne);
    }
    
    private static final void incrementeNbPersonne()
    {
        nbPersonne = getNbPersonne() + 1;
    }
    
    public final boolean isAlive()
    {
        return dateDeces == null;
    }
    
    public final void grandit(Float difference)
    {
        if(difference <= 0)
        {
            System.err.println(this + "n'a pas grandit.");
            return;
        }
        setTaille(getTaille() + difference);
    }
    
    public final void retrecit(Float difference)
    {
        if(difference <= 0)
        {
            System.err.println(this + "n'a pas rétrécit.");
            return;
        }
        setTaille(getTaille() - difference);
    }
    
    public final void grossit(Float difference)
    {
        if(difference <= 0)
        {
            System.err.println(this + "n'a pas grossit.");
            return;
        }
        setPoids(getPoids()+ difference);
    }
    
    public final void maigrit(Integer difference)
    {
        if(difference <= 0)
        {
            System.err.println(this + "n'a pas maigrit.");
            return;
        }
        setPoids(getPoids() - difference);
    }
    
    public void parler(Object texte)
    {
        parler(this, texte);
    }
    
    private final void parler(Object identite, Object texte)
    {
        if(getLastSpeaker() == null || !getLastSpeaker().getID().equals(this.getID()))
        {
            System.out.println(identite.toString() + " :");
        }
        
        System.out.println("\t" + texte.toString());
        
        setLastSpeaker(new Personne(this));
    }
    
    @Override
    public String toString()
    {
        return getNom() + " " + getPrenom();
    }
    
}

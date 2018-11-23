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
public class Personne
{
    // Constantes de la classe    
    
    private static final String[] PRENOMS_H;
    private static final String[] PRENOMS_F;
    private static final String[] NOMS;
    private static final String[] LIEUX;
    private static final String[] NATIONALITES;
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
        
        prenom = genre == Genre.Femme ? PRENOMS_F[(int) (Math.random() * PRENOMS_F.length)] : PRENOMS_H[(int) (Math.random() * PRENOMS_H.length)];
        nomNaissance = NOMS[(int) (Math.random() * NOMS.length)].toUpperCase();
        setNomCourant(nomNaissance);
        
        dateNaissance = Date.dateAleatoire(new Date(1, 1, 1970), new Date(1, 1, 2000));
        lieuNaissance = LIEUX[(int) (Math.random() * LIEUX.length)];
        setNationalite((int) (Math.random() * NATIONALITES.length));
        
        setTaille(150 + (float) Math.random() * (200 - 150));
        setPoids(50 + (float) Math.random() * (100 - 50));
        setCouleur(Couleur.values()[(int) (Math.random() * Couleur.values().length)]);
    }
    public Personne(Personne personne)
    {
        ID = personne.getID();
        genre = personne.getGenre();
        
        prenom = personne.getPrenom();
        nomNaissance = personne.getNomNaissance();
        setNomCourant(personne.getNomCourant());
        
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
    
    public final void setNationalite(Integer nationalite)
    {
        this.nationalite = NATIONALITES[nationalite];
    }
    
    public final void setNationalite(String nationalite)
    {
        for(String string : NATIONALITES)
        {
            if(string.equals(nationalite))
            {
                this.nationalite = string;
                return;
            }
        }
        setNationalite((int) (Math.random() * NATIONALITES.length));
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
            this.nomCourant = NOMS[(int) (Math.random() * NOMS.length)].toUpperCase();
        }
        else
        {
            this.nomCourant = nom.toUpperCase();
        }
    }
    
    public final void setNom(String nom)
    {
        setNomCourant(nom.toUpperCase());
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
        if(lastSpeaker == null || !lastSpeaker.getID().equals(this.getID()))
        {
            System.out.println(identite.toString() + " :");
        }
        
        System.out.println("\t" + texte.toString());
        
        lastSpeaker = new Personne(this);
    }
    
    @Override
    public String toString()
    {
        return getNom() + " " + getPrenom();
    }
    
    static
    {
        final Integer NB_IDENTTITE = 5;
        
        PRENOMS_H = new String[NB_IDENTTITE];
        PRENOMS_H[0] = "Julien";
        PRENOMS_H[1] = "Nathan";
        PRENOMS_H[2] = "Gilles";
        PRENOMS_H[3] = "Pierre";
        PRENOMS_H[4] = "Nicolas";
        
        PRENOMS_F = new String[NB_IDENTTITE];
        PRENOMS_F[0] = "Julie";
        PRENOMS_F[1] = "Margaux";
        PRENOMS_F[2] = "Marine";
        PRENOMS_F[3] = "Manon";
        PRENOMS_F[4] = "Natacha";
        
        NOMS = new String[NB_IDENTTITE];
        NOMS[0] = "Leroux";
        NOMS[1] = "Duvin";
        NOMS[2] = "Bigorneaux";
        NOMS[3] = "Coquillages";
        NOMS[4] = "Rouson";
        
        LIEUX  = new String[NB_IDENTTITE];
        LIEUX[0] = "Madrid";
        LIEUX[1] = "Paris";
        LIEUX[2] = "Londres";
        LIEUX[3] = "New York";
        LIEUX[4] = "Moscou";
        
        NATIONALITES = new String[NB_IDENTTITE];
        NATIONALITES[0] = "Espagnol";
        NATIONALITES[1] = "Français";
        NATIONALITES[2] = "Anglais";
        NATIONALITES[3] = "Américain";
        NATIONALITES[4] = "Russe";
    }
    
}

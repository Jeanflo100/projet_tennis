/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

import java.util.Arrays;
import java.util.HashSet;


/**
 *
 * @author HUBERT Gilles, TASSART Jean-Florian
 */
public final class Joueur extends Personne
{
    private static Joueur[] classement = new Joueur[0];
    
    private final Main main;
    private Integer points = 0;
    private HashSet sponsors = new HashSet();
    private String entraineur;
    
    public Joueur()
    {
        super();
        main = Main.values()[(int) ((Math.random() * Main.values().length)*0.7)];
        setSponsors(Sponsor.values()[(int) (Math.random() * Sponsor.values().length)]);
        setEntraineur(generationNom());
        setInClassement();
    }
    
    public Joueur(Genre genre)
    {
        super(genre);
        main = Main.values()[(int) ((Math.random() * Main.values().length)*0.7)];
        setSponsors(Sponsor.values()[(int) (Math.random() * Sponsor.values().length)]);
        setEntraineur(generationNom());
        setInClassement();
    }
    
    public Joueur(Genre genre, String prenom, String nomCourant, String nomNaissance, Date dateNaissance, String lieuNaissance, String nationalite, Float taille, Float poids, Couleur couleur, Main main){
        super(genre, prenom, nomCourant, nomNaissance, dateNaissance, lieuNaissance, nationalite, taille, poids, couleur);
        this.main = main;
        setSponsors(Sponsor.values()[(int) (Math.random() * Sponsor.values().length)]);
        setEntraineur(generationNom());
        setInClassement();
    }
    
    public Joueur(Joueur joueur)
    {
        super(joueur);
        main = joueur.getMain();
        setSponsors(joueur.getSponsors());
        setEntraineur(joueur.getEntraineur());
        points = joueur.getPoints();
    }
    
    public final void setSponsors(Sponsor sponsor)
    {
        this.sponsors.add(sponsor);
    }
    
    public final void setSponsors(HashSet sponsors)
    {
        sponsors.forEach((object) -> {
            this.sponsors.add(object);
        });
    }
    
    public final void setSponsors(Sponsor[] sponsors)
    {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }
    
    public final void setPoints(Integer points)
    {
        Integer index = getRang() - 1;
        this.points += points;
        while(!getID().equals(classement[index].getID()))
        {
            index++;
        }
        classement[index] = new Joueur(this);
        Arrays.sort(classement, new JoueurComparator());
    }
    
    public final void setEntraineur(String nom)
    {
        this.entraineur = nom;
    }
    
    private final void setInClassement()
    {
        Joueur[] classementTmp = new Joueur[getClassement().length];
        System.arraycopy(getClassement(), 0, classementTmp, 0, classement.length);
        
        classement = new Joueur[classementTmp.length + 1];
        System.arraycopy(classementTmp, 0, classement, 0, classementTmp.length);
        classement[classement.length - 1] = new Joueur(this);
        
        Arrays.sort(classement, new JoueurComparator());
    }
    
    public static final Joueur[] getClassement()
    {
        Joueur[] classementTmp = new Joueur[classement.length];
        System.arraycopy(classement, 0, classementTmp, 0, classement.length);
        return classementTmp;
    }
    
    public Main getMain()
    {
        return main;
    }
    
    public Sponsor[] getSponsors()
    {
        Sponsor[] sponsors = new Sponsor[this.sponsors.size()];
        Integer index = 0;
        for (Object sponsor : this.sponsors)
        {
            sponsors[index] = (Sponsor)sponsor;
            index++;
        }
        return sponsors;
    }
    
    public final Integer getPoints()
    {
        return points;
    }
    
    public final String getEntraineur()
    {
        return entraineur;
    }
    
    /**
     * Le rang d'un(e) joueur/se donne une idée du nombre de joueurs qui ont strictement plus de points. rang 1 -> personne n'est strictement meilleur / rang 5 -> 4 personnes sont strictement meilleures
     * Si 2 joueurs sont ex aequo alors ils ont le même rends, mais personne n'est au rang suivant
     * @return
     */
    public final Integer getRang()
    {
        Integer index = 0;
        while(index < getClassement().length)
        {
            if(getID().equals(getClassement()[index].getID()))
            {
                break;
            }
            index++;
        }
        if(index == getClassement().length)
        {
            System.err.println("Ce joueur n'est pas dans le classement.");
            return 0;
        }
        if(index != 0 && getPoints().equals(getClassement()[index - 1].getPoints()))
        {
            return getClassement()[index-1].getRang();
        }
        return index + 1;
    }
    
    public static final Integer getNbJoueur()
    {
        return getClassement().length;
    }
    
    public final void changementTenue() throws InterruptedException
    {
        parler("Attendez ! Je dois changer de tenue !");
        Thread.sleep(3000);
        parler("C'est bon, merci !");
    }
    
    @Override
    public final String toString()
    {
        switch (getGenre()){
            case Femme : return "Joueuse " + getNom();
            default : return "Joueur " + getNom();
        }
        
    }
}

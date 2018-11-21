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
public class Joueur extends Personne
{
    private static Integer nbJoueur = 0;
    
    private final Main main;
    private Sponsor[] sponsor = new Sponsor[0];
    private Integer classement;
    private Personne entraineur; // Voilà une raison qui justifie que l'on ne mette pas Personne en astrait :p
    
    public Joueur()
    {
        super();
        nbJoueur++;
        main = Main.DROITE;
    }
    
    public final void setSponsor(Sponsor[] sponsor)
    {
        Integer nbSponsor = sponsor.length;
        this.sponsor = new Sponsor[nbSponsor];
        System.arraycopy(sponsor, 0, this.sponsor, 0, nbSponsor);
    }
    public final void setSponsor(Sponsor sponsor)
    {
        this.sponsor = new Sponsor[1];
        this.sponsor[0] = sponsor;
    }
    public final void addSponsor(Sponsor sponsor)
    {
        Integer nbSponsor = this.sponsor.length + 1;
        Sponsor newSponsor[] = new Sponsor[nbSponsor];
        System.arraycopy(this.sponsor, 0, newSponsor, 0, nbSponsor - 1);
        
        newSponsor[nbSponsor - 1] = sponsor;
        
        setSponsor(newSponsor);
    }
    public final void addSponsor(Sponsor[] sponsor)
    {
        Integer nbSponsor = this.sponsor.length + sponsor.length;
        Sponsor newSponsor[] = new Sponsor[nbSponsor];
        System.arraycopy(this.sponsor, 0, newSponsor, 0, this.sponsor.length - 1);
        
        for (Sponsor sponsor1 : newSponsor)
        {
            
        }
        System.arraycopy(sponsor, 0, newSponsor, this.sponsor.length, sponsor.length);
    
        //newSponsor[nbSponsor - 1] = sponsor;
        
        setSponsor(newSponsor);
    }
    public final Sponsor[] removeDouble(Sponsor[] sponsor)
    {
        Integer nbSponsor = 0;
        for(Integer i = 0; i < sponsor.length; i++)
        {
            Boolean doublon = false;
            for(Integer j = 0; j < i; j++)
            {
                if(sponsor[i].equals(sponsor[j]))
            }
        }
    }
    
    public void setClassement(Integer classement)
    {
        this.classement = classement;
    }
    
    public void setEntraineur(String entraineur)
    {
        //this.entraineur = entraineur;
    }
    
    public Main getMain()
    {
        return(this.main);
    }
    
    public Sponsor[] getSponsor()
    {
        return(this.sponsor);
    }
    
    public Integer getClassement()
    {
        return(this.classement);
    }
    
    /*public String getEntraineur()
    {
        return(this.entraineur);
    }*/
    
    public void changementTenue()
    {
        parler("Je change de tenue !");
    }
    
    @Override
    public final void parler(Object texte)
    {
        parler("Joueur " + getNom().toUpperCase(), texte);
    }
}

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
public class Joueur extends Personne {
    
    protected Main main;
    protected Sponsor[] sponsor;
    protected Integer classement;
    protected String entraineur;
    
    public Joueur()
    {
        super();
    }
    
    public void setMain(Main main)
    {
        this.main = main;
    }
    
    public void setSponsor(Sponsor[] sponsor)
    {
        int nb_sponsor = sponsor.length;
        this.sponsor = new Sponsor[nb_sponsor];
        System.arraycopy(sponsor, 0, this.sponsor, 0, nb_sponsor);
    }
    
    public void setClassement(Integer classement)
    {
        this.classement = classement;
    }
    
    public void setEntraineur(String entraineur)
    {
        this.entraineur = entraineur;
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
    
    public String getEntraineur()
    {
        return(this.entraineur);
    }
    
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

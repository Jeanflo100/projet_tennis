package projet_tennis;



public class Joueur extends Personne {
    
    protected Main main;
    protected Sponsor[] sponsor;
    protected Integer classement;
    protected String entraineur;
    
    public Joueur(){
        
    }
    
    public void setMain(Main main){
        this.main = main;
    }
    
    public void setSponsor(Sponsor[] sponsor){
        int nb_sponsor = sponsor.length;
        this.sponsor = new Sponsor[nb_sponsor];
        System.arraycopy(sponsor, 0, this.sponsor, 0, nb_sponsor);
    }
    
    public void setClassement(Integer classement){
        this.classement = classement;
    }
    
    public void setEntraineur(String entraineur){
        this.entraineur = entraineur;
    }
    
    public Main getMain(){
        return(this.main);
    }
    
    public Sponsor[] getSponsor(){
        return(this.sponsor);
    }
    
    public Integer getClassement(){
        return(this.classement);
    }
    
    public String getEntraineur(){
        return(this.entraineur);
    }
    
    public void changementTenue(){
        System.out.println("Je change de tenue !");
    }
    
}

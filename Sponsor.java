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
public enum Sponsor
{
    DECATHLON ("Decathlon"),
    ECURIE_ZT ("Ecurie ZT"),
    ACER ("Acer"),
    LDLC ("LDLC"),
    FEED ("Feed"),
    REDBULL ("RedBull");
    
    private final String sponsor;

    private Sponsor(String sponsor)
    {
        this.sponsor = sponsor;
    }
    
    @Override
    public final String toString()
    {
        return sponsor;
    }
    
    /**
     * Cette fonction permettra de générer l'une des constances à partir d'un string. (Servira notemment pour permettre à l'utilisateur de choisir au travers d'une saisie au clavier
     * @param name
     * @return
     */
    public final static Sponsor fromString(String name)
    {
        for(Sponsor value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucun sponsor.");
        return null;
    }
}
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
public enum Mois
{
    JANVIER ("Janvier"),
    FEVRIER ("Février"),
    MARS ("Mars"),
    AVRIL ("Avril"),
    MAI ("Mai"),
    JUIN ("Juin"),
    JUILLET ("Juillet"),
    AOUT ("Août"),
    SEPTEMBRE ("Septembre"),
    OCTOBRE ("Octobre"),
    NOVEMBRE ("Novembre"),
    DECEMBRE ("Décembre");
    
    private final String mois;
    
    private Mois(String mois)
    {
        this.mois = mois;
    }
    
    @Override
    public final String toString()
    {
        return mois;
    }
    
    /**
     * Cette fonction permettra de générer l'une des constances à partir d'un string. (Servira notemment pour permettre à l'utilisateur de choisir au travers d'une saisie au clavier
     * @param name
     * @return
     */
    public final static Mois fromString(String name)
    {
        for(Mois value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucun mois.");
        return null;
    }
}
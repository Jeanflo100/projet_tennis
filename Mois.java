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
    
    Mois (String mois)
    {
        this.mois = mois;
    }
    
    @Override
    public final String toString ()
    {
        return mois;
    }
    
    public final static Mois fromString (String name)
    {
        for(Mois value : values())
        {
            if(name.equals(value.toString()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucun mois");
        return null;
    }
}

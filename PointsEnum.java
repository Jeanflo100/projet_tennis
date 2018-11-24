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
public enum PointsEnum
{
    ZERO ("Zéro"),
    QUINZE ("15"),
    TRENTE ("30"),
    QUARANTE ("40"),
    AVANTAGE ("Avantage"),
    JEU ("Jeu");
    
    private final String point;
    
    private PointsEnum(String point)
    {
        this.point = point;
    }
    
    @Override
    public final String toString()
    {
        return point;
    }
    
    public final static PointsEnum fromString(String name)
    {
        for(PointsEnum value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucune point.");
        return null;
    }
}

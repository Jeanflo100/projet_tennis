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
    ZERO ("0"),
    QUINZE ("15"),
    TRENTE ("30"),
    QUARANTE ("40"),
    AVANTAGE ("AV"),
    GAGNE ("Gagné");
    
    private String point;
    
    private PointsEnum(String point)
    {
        this.point = point;
    }
    
    @Override
    public final String toString()
    {
        return point;
    }
}

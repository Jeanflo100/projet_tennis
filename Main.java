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
public enum Main
{
    DROITE ("droite"),
    GAUCHE ("gauche");
    
    private final String main;
    
    private Main(String main)
    {
        this.main = main;
    }
    
    @Override
    public final String toString()
    {
        return main;
    }
    
    public final static Main fromString(String name)
    {
        for(Main value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucune main.");
        return null;
    }
}
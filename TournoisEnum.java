/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

/**
 *
 * @author ISEN
 */
public enum TournoisEnum
{
    Homme ("US Open"),
    Femme ("Open d'Australie"),
    truc ("Roland-Garros"),
    machin ("Wimbledon");
    
    private final String tournois;
    
    private TournoisEnum(String tournois)
    {
        this.tournois = tournois;
    }
    
    @Override
    public final String toString()
    {
        return tournois;
    }
    
    public final static TournoisEnum fromString(String name)
    {        
        for(TournoisEnum value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucun Tournois.");
        return null;
    }
}

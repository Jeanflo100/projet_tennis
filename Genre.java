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
public enum Genre
{
    Homme ("homme"),
    Femme ("femme");
    
    private final String genre;
    
    private Genre(String genre)
    {
        this.genre = genre;
    }
    
    @Override
    public final String toString()
    {
        return genre;
    }
    
    public final static Genre fromString(String name)
    {
        if(name.toLowerCase().equals("H"))
        {
            name = "homme";
        }
        else if(name.toLowerCase().equals("f"))
        {
            name = "femme";
        }
        
        for(Genre value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucun genre.");
        return null;
    }
}

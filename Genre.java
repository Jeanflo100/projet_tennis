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
    Homme ("hommme"),
    Femme ("femme");
    
    private final String genre;
    
    Genre(String genre)
    {
        this.genre = genre;
    }
    
    @Override
    public final String toString()
    {
        return genre;
    }
}

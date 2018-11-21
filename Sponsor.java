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

    Sponsor(String sponsor)
    {
        this.sponsor = sponsor;
    }
    
    @Override
    public final String toString()
    {
        return sponsor;
    }
}
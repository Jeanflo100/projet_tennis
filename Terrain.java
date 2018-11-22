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
public enum Terrain
{
    OPEN_D_AUSTRALIE ("plexicushion"),
    ROLAND_GARROS ("terre batue"),
    WIMLBLEDON ("gazon"),
    US_OPEN ("decoturf");
    
    private final String terrain;

    private Terrain(String terrain)
    {
        this.terrain = terrain;
    }
    
    @Override
    public final String toString()
    {
        return terrain;
    }
}

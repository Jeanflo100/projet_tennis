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
    
    /**
     * Cette fonction permettra de générer l'une des constances à partir d'un string. (Servira notemment pour permettre à l'utilisateur de choisir au travers d'une saisie au clavier
     * @param name
     * @return
     */
    public final static Terrain fromString(String name)
    {
        for(Terrain value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucun Terrain.");
        return null;
    }
}

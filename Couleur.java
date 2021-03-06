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
public enum Couleur
{
    ORANGE ("orange"),
    BLEU ("bleu"),
    VERT ("vert"),
    VIOLET ("violet"),
    ROUGE ("rouge"),
    JAUNE ("jaune"),
    NOIR ("noir"),
    BLANC ("blanc");
    
    private final String couleur;

    private Couleur(String couleur)
    {
        this.couleur = couleur;
    }
    
    @Override
    public final String toString()
    {
        return couleur;
    }
    
    public final static Couleur fromString(String name)
    {
        for(Couleur value : values())
        {
            if(name.toLowerCase().equals(value.toString().toLowerCase()))
            {
                return value;
            }
        }
        System.err.println("La chaine de caractère ne correspond à aucune couleur.");
        return null;
    }
}
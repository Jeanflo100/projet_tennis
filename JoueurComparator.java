/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

import java.util.Comparator;

/**
 *
 * @author HUBERT Gilles, TASSART Jean-Florian
 */

public class JoueurComparator implements Comparator<Joueur>
{
    @Override
    public int compare(Joueur j1, Joueur j2)
    {
        return -j1.getPoints().compareTo(j2.getPoints());
    }  
}

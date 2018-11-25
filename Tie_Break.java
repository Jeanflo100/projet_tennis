/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

import java.util.Scanner;

/**
 *
 * @author HUBERT Gilles, TASSART Jean-Florian
 */
public final class Tie_Break
{
    private final Score<Integer> score = new Score<>(0, 0);
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    
    public Tie_Break(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
    }
    
    public final void jouer()
    {
        arbitre.ennoncerServeur(joueur1);
        System.out.println();
        arbitre.parler(this);
        while(!score.get(1).equals(PointsEnum.JEU) && !score.get(2).equals(PointsEnum.JEU))
        {
            Scanner sc = new Scanner(System.in);
            echange(sc.nextInt());
        }
    }
    
    public final void echange()
    {
        final Float alea = (float) Math.random();
        if (alea < 0.5)
        {
            arbitre.parler("Point : " + serveur.getNom());
            Score.incremente(score, 1);
        }
        else
        {
            arbitre.parler("Point : " + receveur.getNom());
            Score.incremente(score, 2);
        }
        arbitre.parler(this);
    }
    
    public final void echange(Integer nombre)
    {
        if (nombre == 1)
        {
            arbitre.parler("Point : " + serveur.getNom());
            Score.incremente(score, 1);
        }
        else
        {
            arbitre.parler("Point : " + receveur.getNom());
            Score.incremente(score, 2);
        }
        arbitre.parler(this);
    }
    
    @Override
    public final String toString()
    {        
        return score.toString();
    }
}
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
    private Joueur serveur;
    private Joueur receveur;
    
    public Tie_Break(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
        serveur = new Joueur(joueur1);
        receveur = new Joueur(joueur2);
    }
    
    public final void changerServeur()
    {
        serveur = serveur.getID().equals(joueur1.getID()) ? new Joueur(joueur2) : new Joueur(joueur1);
        receveur = serveur.getID().equals(joueur1.getID()) ? new Joueur(joueur2) : new Joueur(joueur1);
    }
    
    public final boolean jouer()
    {
        arbitre.ennoncerServeur(serveur);
        System.out.println();
        arbitre.parler(this);
        while((score.get(1).compareTo(7) < 0 && score.get(2).compareTo(7) < 0) || (Math.abs(score.get(1)-score.get(2)) < 2))
        {
            if((score.get(1) + score.get(2))%2 == 1)
            {
                changerServeur();
                arbitre.ennoncerServeur(serveur);
                System.out.println();
            }
            Scanner sc = new Scanner(System.in);
            echange(sc.nextInt());
            arbitre.parler(this);
        }
        return score.get(1).compareTo(score.get(2)) > 0;
    }
    
    public final void echange()
    {
        final Float alea = (float) Math.random();
        if (alea < 0.5)
        {
            arbitre.parler("Point : " + joueur1.getNom());
            Score.incremente(score, 1);
        }
        else
        {
            arbitre.parler("Point : " + joueur2.getNom());
            Score.incremente(score, 2);
        }
    }
    
    public final void echange(Integer nombre)
    {
        if (nombre == 1)
        {
            arbitre.parler("Point : " + joueur1.getNom());
            Score.incremente(score, 1);
        }
        else
        {
            arbitre.parler("Point : " + joueur2.getNom());
            Score.incremente(score, 2);
        }
    }
    
    @Override
    public final String toString()
    {
        if((score.get(1).compareTo(7) < 0 && score.get(2).compareTo(7) < 0) || (Math.abs(score.get(1)-score.get(2)) < 2))
        {
            return score.toString();
        }
        return "Jeu " + (score.get(1).compareTo(score.get(2)) > 0 ? joueur1.getNom() : joueur2.getNom());
    }
}
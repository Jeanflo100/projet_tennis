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
public class Jeu
{
    private final Score<Points> score = new Score<>(new Points(), new Points());
    private final Joueur serveur;
    private final Joueur receveur;
    private final Arbitre arbitre;
    private Boolean egalite = false;
    
    public Jeu(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        serveur = new Joueur(joueur1);
        receveur = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
    }
    
    public final void setEgalite(Boolean valeur)
    {
        egalite = valeur;
    }
    
    public final Boolean getEgalite()
    {
        return egalite;
    }
    
    public final boolean jouer()
    {
        setEgalite(false);
        arbitre.ennoncerServeur(serveur);
        System.out.println();
        arbitre.parler(this);
        while(!score.get(1).get().equals(PointsEnum.JEU) && !score.get(2).get().equals(PointsEnum.JEU))
        {
            Scanner sc = new Scanner(System.in);
            echange(sc.nextInt());
        }
        return score.get(1).get().equals(PointsEnum.JEU);
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
        String texte;
        texte = score.toString();
        
        if((score.get(1).get().compareTo(PointsEnum.QUARANTE) == 0) && (score.get(2).get().compareTo(PointsEnum.QUARANTE) == 0))
        {
            texte = getEgalite() ? "Égalité" : PointsEnum.QUARANTE.toString() + " A";
            setEgalite(true);
        }
        
        if(score.get(1).get().compareTo(PointsEnum.AVANTAGE) == 0)
        {
            texte = score.get(1).get().toString() + " " + serveur.getNom();
        }
        else if(score.get(2).get().compareTo(PointsEnum.AVANTAGE) == 0)
        {
            texte = score.get(2).get().toString() + " " + receveur.getNom();
        }
        
        if(score.get(1).get().compareTo(PointsEnum.JEU) == 0)
        {
            texte = score.get(1).get().toString() + " " + serveur.getNom();
        }
        else if(score.get(2).get().compareTo(PointsEnum.JEU) == 0)
        {
            texte = score.get(2).get().toString() + " " + receveur.getNom();
        }
        
        return texte;
    }
}

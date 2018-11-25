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
    private Boolean fini = false;
    private Joueur gagnant;
    private Joueur perdant;
    
    public Tie_Break(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
        serveur = new Joueur(joueur1);
        receveur = new Joueur(joueur2);
    }
    
    
    public final Score<Integer> getScore()
    {
        return new Score<>(score.get(1), score.get(2));
    }
    public final Integer getScore(Integer joueur)
    {
        return getScore().get(joueur);
    }
    
    public final Joueur getJoueur1()
    {
        return new Joueur(joueur1);
    }
    
    public final Joueur getJoueur2()
    {
        return new Joueur(joueur2);
    }
    
    public final Arbitre getArbitre()
    {
        return new Arbitre(arbitre);
    }
    
    public final Boolean getFini()
    {
        return fini;
    }
    private final void setFini()
    {
        fini = true;
    }
    
    /**
     *
     * @return null si le match n'a pas encore été joué
     */
    public final Joueur getGagnant()
    {
        return new Joueur(gagnant);
    }
    private final void setGagnant(Joueur gagnant)
    {
        this.gagnant = new Joueur(gagnant);
    }
    
    /**
     *
     * @return null si le match n'a pas encore été joué
     */
    public final Joueur getPerdant()
    {
        return new Joueur(perdant);
    }
    private final void setPerdant(Joueur perdant)
    {
        this.perdant = new Joueur(perdant);
    }
    
    private void setResultat(Joueur gagnant, Joueur perdant)
    {
        setGagnant(new Joueur(gagnant));
        setPerdant(new Joueur(perdant));
        setFini();
    }
    
    public final Joueur getServeur()
    {
        return new Joueur(serveur);
    }
    private final void setServeur(Joueur serveur)
    {
        this.serveur = new Joueur(serveur);
    }
    
    public final Joueur getReceveur()
    {
        return new Joueur(receveur);
    }
    private final void setReceveur(Joueur serveur)
    {
        this.serveur = new Joueur(serveur);
    }
    
    public final void changerServeur()
    {
        setServeur(getServeur().getID().equals(getJoueur1().getID()) ? new Joueur(getJoueur2()) : new Joueur(getJoueur1()));
        setReceveur(getReceveur().getID().equals(getJoueur1().getID()) ? new Joueur(getJoueur2()) : new Joueur(getJoueur1()));
    }
    
    public final boolean jouer()
    {
        getArbitre().ennoncerServeur(getServeur());
        System.out.println();
        getArbitre().parler(this);
        while((getScore(1).compareTo(7) < 0 && getScore(2).compareTo(7) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))
        {
            if((getScore(1) + getScore(2))%2 == 1)
            {
                changerServeur();
                getArbitre().ennoncerServeur(getServeur());
                System.out.println();
            }
            Scanner sc = new Scanner(System.in);
            String saisie;
            do
            {                
                saisie = sc.nextLine();
            } while (!saisie.equals("1") && !saisie.equals("2"));
            echange(Integer.parseInt(saisie));
            if((getScore(1).compareTo(7) < 0 && getScore(2).compareTo(7) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))
            {
                getArbitre().parler(this);
            }
        }
        
        if(getScore(1) > getScore(2))                                                                               // Lorsque l'un des joueur a agné 7 points avec un écart de 2 ou plus, alors il a forcément gagné plus de set que l'adversaire.
        {
            setResultat(getJoueur1(), getJoueur2());            
        }
        else
        {
            setResultat(getJoueur2(), getJoueur1());
        }
        
        return getScore(1).compareTo(getScore(2)) > 0;
    }
    
    public final void echange()
    {
        final Float alea = (float) Math.random();
        if (alea < 0.5)
        {
            getArbitre().parler("Point " + getJoueur1().getNom());
            Score.incremente(score, 1);
        }
        else
        {
            getArbitre().parler("Point " + getJoueur2().getNom());
            Score.incremente(score, 2);
        }
    }
    
    public final void echange(Integer nombre)
    {
        if (nombre == 1)
        {
            getArbitre().parler("Point " + getJoueur1().getNom());
            Score.incremente(score, 1);
        }
        else
        {
            getArbitre().parler("Point " + getJoueur2().getNom());
            Score.incremente(score, 2);
        }
    }
    
    @Override
    public final String toString()
    {
        return getScore().toString();
    }
}
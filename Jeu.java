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
public final class Jeu
{
    private final Score<Points> score = new Score<>(new Points(), new Points());
    private final Joueur serveur;
    private final Joueur receveur;
    private final Arbitre arbitre;
    private Boolean egalite = false;
    private Boolean fini = false;
    private Joueur gagnant;
    private Joueur perdant;
    
    public Jeu(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        serveur = new Joueur(joueur1);
        receveur = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
    }
    
    
    public final Score<Points> getScore()
    {
        return new Score<>(score.get(1), score.get(2));
    }

    /**
     * Permet de récupérer plus simplement le score de l'un des deux joueurs
     * @param joueur
     * @return
     */
    public final PointsEnum getScore(Integer joueur)
    {
        return getScore().get(joueur).get();
    }
    
    public final Joueur getServeur()
    {
        return new Joueur(serveur);
    }
    
    public final Joueur getReceveur()
    {
        return new Joueur(receveur);
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
    
    private final void setEgalite()
    {
        egalite = true;
    }
    
    public final Boolean getEgalite()
    {
        return egalite;
    }
    
    public final boolean jouer()
    {
        getArbitre().ennoncerServeur(getServeur());
        System.out.println();
        getArbitre().parler(this);
        while(!getScore(1).equals(PointsEnum.JEU) && !getScore(2).equals(PointsEnum.JEU))
        {
            Scanner sc = new Scanner(System.in);
            String saisie;
            do
            {                
                saisie = sc.nextLine();
            } while (!saisie.equals("0") && !saisie.equals("1"));
            echange(Integer.parseInt(saisie));
            if(!getScore(1).equals(PointsEnum.JEU) && !getScore(2).equals(PointsEnum.JEU))
            {
                getArbitre().parler(this);
            }
        }
        
        if(getScore(1).compareTo(PointsEnum.JEU) == 0)
        {
            setResultat(getServeur(), getReceveur());
        }
        else if(getScore(2).compareTo(PointsEnum.JEU) == 0)
        {
            setResultat(getReceveur(), getServeur());
        }
        
        return getScore(1).equals(PointsEnum.JEU);
    }
    
    public final void echange()
    {
        final Float alea = (float) Math.random();
        if (alea < 0.5)
        {
            getArbitre().parler("Point " + getServeur().getNom());
            Score.incremente(score, 1);
        }
        else
        {
            getArbitre().parler("Point " + getReceveur().getNom());
            Score.incremente(score, 2);
        }
    }
    
    public final void echange(Integer nombre)
    {
        if (nombre == 1)
        {
            getArbitre().parler("Point " + getServeur().getNom());
            Score.incremente(score, 1);
        }
        else
        {
            getArbitre().parler("Point " + getReceveur().getNom());
            Score.incremente(score, 2);
        }
    }
    
    @Override
    public final String toString()
    {
        String texte;
        texte = getScore().toString();
        
        if((getScore(1).compareTo(PointsEnum.QUARANTE) == 0) && (getScore(2).compareTo(PointsEnum.QUARANTE) == 0))
        {
            texte = getEgalite() ? "Égalité" : PointsEnum.QUARANTE.toString() + " A";
            setEgalite();
        }
        
        if(getScore(1).compareTo(PointsEnum.AVANTAGE) == 0)
        {
            texte = getScore(1).toString() + " " + getServeur().getNom();
        }
        else if(getScore(2).compareTo(PointsEnum.AVANTAGE) == 0)
        {
            texte = getScore(2).toString() + " " + getReceveur().getNom();
        }
        
        return texte;
    }
}

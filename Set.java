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
public class Set
{
    private Boolean serviceJ1;
    protected final Score<Integer> score = new Score<>(0, 0);
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    private Boolean fini = false;
    private Joueur gagnant;
    private Joueur perdant;
    
    public Set(Joueur joueur1, Joueur joueur2, Arbitre arbitre, Boolean serviceJ1)
    {
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
        setServiceJ1(serviceJ1);
    }
    
    
    public final Boolean getServiceJ1()
    {
        return serviceJ1;
    }
    protected final void setServiceJ1(Boolean bool)
    {
        this.serviceJ1 = bool;
    }
    
    public final Score<Integer> getScore()
    {
        return new Score<>(score.get(1), score.get(2));
    }

    /**
     * Permet de récupérer plus simplement le score de l'un des deux joueurs
     * @param joueur
     * @return
     */
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
    protected final void setFini()
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
    protected final void setGagnant(Joueur gagnant)
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
    protected final void setPerdant(Joueur perdant)
    {
        this.perdant = new Joueur(perdant);
    }
    
    protected void setResultat(Joueur gagnant, Joueur perdant)
    {
        setGagnant(new Joueur(gagnant));
        setPerdant(new Joueur(perdant));
        setFini();
    }
    
    
    public Score<Integer> jouer()
    {
        while(((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2)) && !(getScore(1).equals(6) && getScore(2).equals(6)))
        {
            Jeu jeu = getServiceJ1() ? new Jeu(getJoueur1(), getJoueur2(), getArbitre()) : new Jeu(getJoueur2(), getJoueur1(), getArbitre());
            Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
            setServiceJ1(!getServiceJ1());
            if(((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2)) && !(getScore(1).equals(6) && getScore(2).equals(6)))
            {
                getArbitre().parler("Jeu " + jeu.getGagnant().getNom());
                getArbitre().parler("Score Jeux : " + getJoueur1().getNom() + " " + getScore(1) + " - " + getScore(2) + " " + getJoueur2().getNom());
            }
        }
        if(getScore(1).equals(getScore(2)))
        {
            Tie_Break jeu = getServiceJ1() ? new Tie_Break(getJoueur1(), getJoueur2(), getArbitre()) : new Tie_Break(getJoueur2(), getJoueur1(), getArbitre());
            Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
        }
        
        if(getScore(1) > getScore(2))                                                                               // Lorsque l'un des joueur a agné 3 set, alors il a forcément gagné plus de set que l'adversaire.
        {
            setResultat(getJoueur1(), getJoueur2());            
        }
        else
        {
            setResultat(getJoueur2(), getJoueur1());
        }
        
        return getScore();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

/**
 * Cette classe modélise le cas particuliers du 5ème set pour lequel les règles différents légèrement entre les différents tournois
 * @author HUBERT Gilles, TASSART Jean-Florian
 */
public class LastSet extends Set
{
    private final TournoisEnum tournois;
    
    public LastSet(Joueur joueur1, Joueur joueur2, Arbitre arbitre, Boolean serviceJ1, Boolean passe, TournoisEnum tournois)
    {
        super(joueur1, joueur2, arbitre, serviceJ1, passe);
        this.tournois = tournois;
    }
    
    public final TournoisEnum getTournois()
    {
        return tournois;
    }
    
    @Override
    public Score<Integer> jouer()
    {
        switch(getTournois())
        {
            case AU:
                while((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))              // Open d'Australie : pas de Tie Break dans le dernier set. L'un des deux joueurs doit gagner en gagnant 6 jeux et avoir au moins 2 jeu d'avance sur l'adversaire
                {
                    Jeu jeu = getServiceJ1() ? new Jeu(getJoueur1(), getJoueur2(), getArbitre(), passe) : new Jeu(getJoueur2(), getJoueur1(), getArbitre(), passe);
                    Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
                    setServiceJ1(!getServiceJ1());
                    if((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))
                    {
                        getArbitre().parler("Jeu " + jeu.getGagnant().getNom());
                        getArbitre().parler("Score Jeux : " + getJoueur1().getNom() + " " + getScore(1) + " - " + getScore(2) + " " + getJoueur2().getNom());
                    }
                }
                break;
            case RG:
                while((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))              // Roland Garros : Même chose que l'Open d'australie
                {
                    Jeu jeu = getServiceJ1() ? new Jeu(getJoueur1(), getJoueur2(), getArbitre(), passe) : new Jeu(getJoueur2(), getJoueur1(), getArbitre(), passe);
                    Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
                    setServiceJ1(!getServiceJ1());
                    if((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))
                    {
                        getArbitre().parler("Jeu " + jeu.getGagnant().getNom());
                        getArbitre().parler("Score Jeux : " + getJoueur1().getNom() + " " + getScore(1) + " - " + getScore(2) + " " + getJoueur2().getNom());
                    }
                }
                break;
            case W:
                while(((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2)) && !(getScore(1).equals(12) && getScore(2).equals(12))) // Wimbledon : Tie Break uniquement lorsque les joueurs sont arrivé à 12 jeux chacun
                {
                    Jeu jeu = getServiceJ1() ? new Jeu(getJoueur1(), getJoueur2(), getArbitre(), passe) : new Jeu(getJoueur2(), getJoueur1(), getArbitre(), passe);
                    Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
                    setServiceJ1(!getServiceJ1());
                    if((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))
                    {
                        getArbitre().parler("Jeu " + jeu.getGagnant().getNom());
                        getArbitre().parler("Score Jeux : " + getJoueur1().getNom() + " " + getScore(1) + " - " + getScore(2) + " " + getJoueur2().getNom());
                    }
                }
                if(getScore(1).equals(getScore(2)))
                {
                    Tie_Break jeu = getServiceJ1() ? new Tie_Break(getJoueur1(), getJoueur2(), getArbitre(), passe) : new Tie_Break(getJoueur2(), getJoueur1(), getArbitre(), passe);
                    Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
                }
                break;
            case US:
                while(((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2)) && !(getScore(1).equals(6) && getScore(2).equals(6)))   // US Open : Set normale
                {
                    Jeu jeu = getServiceJ1() ? new Jeu(getJoueur1(), getJoueur2(), getArbitre(), passe) : new Jeu(getJoueur2(), getJoueur1(), getArbitre(), passe);
                    Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
                    setServiceJ1(!getServiceJ1());
                    if((getScore(1).compareTo(6) < 0 && getScore(2).compareTo(6) < 0) || (Math.abs(getScore(1) - getScore(2)) < 2))
                    {
                        getArbitre().parler("Jeu " + jeu.getGagnant().getNom());
                        getArbitre().parler("Score Jeux : " + getJoueur1().getNom() + " " + getScore(1) + " - " + getScore(2) + " " + getJoueur2().getNom());
                    }
                }
                if(getScore(1).equals(getScore(2)))
                {
                    Tie_Break jeu = getServiceJ1() ? new Tie_Break(getJoueur1(), getJoueur2(), getArbitre(), passe) : new Tie_Break(getJoueur2(), getJoueur1(), getArbitre(), passe);
                    Score.incremente(score, jeu.jouer() == getServiceJ1() ? 1 : 2);
                }
                break;
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
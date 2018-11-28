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
public final class Match
{
    private final TournoisEnum tournois;
    private final Score<Integer> score = new Score<>(0, 0);     // Score actuel du match : nombre de Set gagné pou chaque joueur
    private final Score<Integer>[] scoresSet = new Score[5];    // Tableau des scores de chaque set fait. Il ne peut y avoir que 5 set maximum dans un match
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    private Boolean fini = false;
    private Joueur gagnant;
    private Joueur perdant;
    private Boolean passe;
    
    
    public Match(Joueur joueur1, Joueur joueur2, Arbitre arbitre, TournoisEnum tournois, Boolean passe)
    {
        this.tournois = tournois;
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
        this.passe = passe;
    }
    
    
    public final TournoisEnum getTournois()
    {
        return tournois;
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
    
    public final Score<Integer>[] getScoresSet()
    {
        final Score<Integer>[] scoresSetCopy = new Score[scoresSet.length];
        System.arraycopy(scoresSet, 0, scoresSetCopy, 0, scoresSet.length);
        return scoresSetCopy;
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
    
    
    public final Joueur jouer() throws InterruptedException
    {
        if(!passe)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez-vous passer le match : " + getJoueur1().getNom() + " contre" + getJoueur2().getNom() + " ? (o/n");
            String reponse;
            do
            {            
                reponse = sc.nextLine();
            } while (!reponse.toLowerCase().equals("o") && !reponse.toLowerCase().equals("n"));
            passe = reponse.toLowerCase().equals("o");
        }
        
        Boolean serviceJ1 = Math.random() < 0.5;                                                                        // Tirage au sort
        Integer nbSet = 0;                                                                                              // index pour remplir le tableau de score des sets
        while((getScore(1).compareTo(3) < 0 && getScore(2).compareTo(3) < 0) && nbSet < 4)                              // Tant qu'aucun joueur n'a gagné 3 sets et qu'ils ne sont pas au dernier set possible
        {
            Set set = new Set(getJoueur1(), getJoueur2(), getArbitre(), serviceJ1, passe);                                     // On créé un nouveau set
            scoresSet[nbSet] = set.jouer();                                                                             // On le fait jouer et on met le score dans le tableau
            serviceJ1 = (getScoresSet()[nbSet].get(1) + getScoresSet()[nbSet].get(2))%2 == 0 ? serviceJ1 : !serviceJ1;  // Si le nombre de set joué est pair, le même joueur servira en premier au prochain set. Si le nombre de set jouer est impair, le serveur change
            Score.incremente(score, getScoresSet()[nbSet].get(1) > getScoresSet()[nbSet].get(2) ? 1 : 2);               // Si le joueur1 a gagné, on incrément son nombre de set gagné. sinon, on incrément le nombre de set gagné du joueur 2
            nbSet++;                                                                                                    // On passe à l'index du set suivant dans le tableau de score des sets
            if(getScore(1).compareTo(3) < 0 && getScore(2).compareTo(3) < 0)                                            // Si un auter set doit suivre, alors l'arbitre indique quel joueur vient de gagner le jeu et le set, puis il rappel le nombre de set gagné pour chacun des joueurs 
            {
                getArbitre().parler("Jeu, Set " + set.getGagnant().getNom());
                getArbitre().parler("Score Septs : " + getJoueur1().getNom() + " " + getScore(1) + " - " + getScore(2) + " " + getJoueur2().getNom());
                if(Math.random()<0.1)                                                                                   // 10% de chance qu'un des deux joueurs change de tenue à la fin d'un set
                {
                    Joueur celuiQuiChangeDeTenue = Math.random() < 0.5 ? getJoueur1() : getJoueur2();
                    celuiQuiChangeDeTenue.changementTenue(passe);
                }
            }
        }
        
        if(nbSet == 4)                                                                                                  // Si ils en sont au dernier set, même procédé, mais avec un set qui prend en compte les différentes règles suivant les tournois
        {
            LastSet set = new LastSet(getJoueur1(), getJoueur2(), getArbitre(), serviceJ1, passe, getTournois());
            scoresSet[nbSet] = set.jouer();
            Score.incremente(score, getScoresSet()[nbSet].get(1) > getScoresSet()[nbSet].get(2) ? 1 : 2);
        }
        
        if(getScore(1) > getScore(2))                                                                                   // Lorsque l'un des joueur a agné 3 set, alors il a forcément gagné plus de set que l'adversaire.
        {
            setResultat(getJoueur1(), getJoueur2());            
        }
        else
        {
            setResultat(getJoueur2(), getJoueur1());
        }
        
        getArbitre().parler("Jeu, Set, et Match " + getGagnant().getNom());                                             // L'arbitre indique le vainqueur puis rappelles les jeux gagné dans chaque sets
        getArbitre().parler(this);
        getGagnant().setPoints(Integer.max(1, Math.abs(getGagnant().getRang() - getPerdant().getRang())));              // Enfin, on donne et on retire des points à chaque joueur pour faire évoluer le classement
        getPerdant().setPoints(Integer.min(-1, -Math.abs(getGagnant().getRang() - getPerdant().getRang())));
        return getGagnant();
    }
    
    public final Joueur jouer(Boolean oo) throws InterruptedException
    {
        if(!passe)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez-vous passer le match : " + getJoueur1().getNom() + " contre" + getJoueur2().getNom() + " ? (o/n");
            String reponse;
            do
            {            
                reponse = sc.nextLine();
            } while (!reponse.toLowerCase().equals("o") && !reponse.toLowerCase().equals("n"));
            passe = reponse.toLowerCase().equals("o");
        }
        
        Boolean serviceJ1 = Math.random() < 0.5;                                                                        // Tirage au sort
        Integer nbSet = 0;                                                                                              // index pour remplir le tableau de score des sets
        while((getScore(1).compareTo(3) < 0 && getScore(2).compareTo(3) < 0) && nbSet < 4)                              // Tant qu'aucun joueur n'a gagné 3 sets et qu'ils ne sont pas au dernier set possible
        {
            Set set = new Set(getJoueur1(), getJoueur2(), getArbitre(), serviceJ1, passe);                                     // On créé un nouveau set
            scoresSet[nbSet] = set.jouer();                                                                             // On le fait jouer et on met le score dans le tableau
            serviceJ1 = (getScoresSet()[nbSet].get(1) + getScoresSet()[nbSet].get(2))%2 == 0 ? serviceJ1 : !serviceJ1;  // Si le nombre de set joué est pair, le même joueur servira en premier au prochain set. Si le nombre de set jouer est impair, le serveur change
            Score.incremente(score, getScoresSet()[nbSet].get(1) > getScoresSet()[nbSet].get(2) ? 1 : 2);               // Si le joueur1 a gagné, on incrément son nombre de set gagné. sinon, on incrément le nombre de set gagné du joueur 2
            nbSet++;                                                                                                    // On passe à l'index du set suivant dans le tableau de score des sets
            if(getScore(1).compareTo(3) < 0 && getScore(2).compareTo(3) < 0)                                            // Si un auter set doit suivre, alors l'arbitre indique quel joueur vient de gagner le jeu et le set, puis il rappel le nombre de set gagné pour chacun des joueurs 
            {
                getArbitre().parler("Jeu, Set " + set.getGagnant().getNom());
                getArbitre().parler("Score Septs : " + getJoueur1().getNom() + " " + getScore(1) + " - " + getScore(2) + " " + getJoueur2().getNom());
                if(Math.random()<0.1)                                                                                   // 10% de chance qu'un des deux joueurs change de tenue à la fin d'un set
                {
                    Joueur celuiQuiChangeDeTenue = Math.random() < 0.5 ? getJoueur1() : getJoueur2();
                    celuiQuiChangeDeTenue.changementTenue(passe);
                }
            }
        }
        
        if(nbSet == 4)                                                                                                  // Si ils en sont au dernier set, même procédé, mais avec un set qui prend en compte les différentes règles suivant les tournois
        {
            LastSet set = new LastSet(getJoueur1(), getJoueur2(), getArbitre(), serviceJ1, passe, getTournois());
            scoresSet[nbSet] = set.jouer();
            Score.incremente(score, getScoresSet()[nbSet].get(1) > getScoresSet()[nbSet].get(2) ? 1 : 2);
        }
        
        if(getScore(1) > getScore(2))                                                                                   // Lorsque l'un des joueur a agné 3 set, alors il a forcément gagné plus de set que l'adversaire.
        {
            setResultat(getJoueur1(), getJoueur2());            
        }
        else
        {
            setResultat(getJoueur2(), getJoueur1());
        }
        
        getArbitre().parler("Jeu, Set, et Match " + getGagnant().getNom());                                             // L'arbitre indique le vainqueur puis rappelles les jeux gagné dans chaque sets
        getArbitre().parler(this);
        getGagnant().setPoints(Integer.max(1, Math.abs(getGagnant().getRang() - getPerdant().getRang())), true);              // Enfin, on donne et on retire des points à chaque joueur pour faire évoluer le classement
        getPerdant().setPoints(Integer.min(-1, -Math.abs(getGagnant().getRang() - getPerdant().getRang())), true);
        return getGagnant();
    }
    
    
    @Override
    public final String toString()
    {
        if(!getFini())
        {
            return "Le match n'a pas encore été joué.";
        }
        String string = "\n";
        final Integer lettreNom = Integer.max(getJoueur1().getNom().length(), getJoueur2().getNom().length());
        
        for(Integer i = 1; i <= 2; i++)                                                                                 // Pour chacun des deux joueurs
        {
            Joueur joueur = new Joueur(i.equals(1) ? getJoueur1() : getJoueur2());                                      // Sélection du joueur
            string +=  joueur.getNom();                                                                                 // On indique son nom, pui
            for(Integer j = joueur.getNom().length(); j < lettreNom; j++)                                               // On ajoute autant d'espace que nécessaire pour ne pas avoir de décalage si l'autre nom n'a pas le même nombre de caractère
            {
                string += " ";
            }
            string += "\t";
            for(Integer j = 0; j < getScoresSet().length; j++)                                                          // On affiche chacun des jeux gagné pour chaque sets joué
            {
                if(getScoresSet()[j] == null)                                                                           // Si un set n'a pas été joué, on ne l'affiche pas et les suivant non plus
                {
                    break;
                }
                string += getScoresSet()[j].get(i) + " ";
            }
            string +="\n";
        }
        
        return string;
    }
}
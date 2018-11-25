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
public class Match
{
    private final Score<Integer> score = new Score<>(0, 0);     // Score actuel du match : nombre de Set gagné pou chaque joueur
    private final Score<Integer>[] scoresSet = new Score[5];    // Tableau des scores de chaque set fait. Il ne peut y avoir que 5 set maximum dans un match
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    
    public Match(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        this.joueur1 = new Joueur(joueur1);
        this.joueur2 = new Joueur(joueur2);
        this.arbitre = new Arbitre(arbitre);
    }
    
    
    public final void jouer()
    {
        Boolean serviceJ1 = Math.random() < 0.5;                                                                // Tirage au sort
        Integer nbSet = 0;                                                                                      // index pour remplir le tableau de score des sets
        while(score.get(1).compareTo(3) < 0 && score.get(2).compareTo(3) < 0)                                   // Tant qu'aucun joueur n'a gagné 3 sets
        {
            Set set = new Set(joueur1, joueur2, arbitre, serviceJ1);                                            // On créé un nouveau set
            scoresSet[nbSet] = set.jouer();                                                                     // On le fait jouer et on met le score dans le tableau
            nbSet++;                                                                                            // On passe à l'index du set suivant dans le tableau de score des sets
            serviceJ1 = (scoresSet[nbSet].get(1) + scoresSet[nbSet].get(2))%2 == 0 ? serviceJ1 : !serviceJ1;    // Si le nombre de set joué est pair, le même joueur servira en premier au prochain set. Si le nombre de set jouer est impair, le serveur change
            Score.incremente(score, scoresSet[nbSet].get(1)>scoresSet[nbSet].get(2) ? 1 : 2);                   // Si le joueur1 a gagné, on incrément son nombre de set gagné. sinon, on incrément le nombre de set gagné du joueur 2
        }
        arbitre.parler("Jeu " + (score.get(1) > score.get(2) ? joueur1.getNom() : joueur2.getNom()));           // Lorsque l'un des joueur a agné 3 set, alors il a forcément gagné plus de set que l'adversaire. On indique le vainqueur en conséquence.
    }
}
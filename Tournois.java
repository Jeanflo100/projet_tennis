/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

import java.util.Arrays;

/**
 *
 * @author HUBERT Gilles, TASSART Jean-Florian
 */
public class Tournois
{
    private final TournoisEnum tournois;
    private final Arbitre[] arbitres;
    
    private final Joueur[] participants128 = new Joueur[128];
    private final Joueur[] participants64 = new Joueur[64];
    private final Joueur[] participants32 = new Joueur[32];
    private final Joueur[] participants16 = new Joueur[16];
    private final Joueur[] participants8 = new Joueur[8];
    private final Joueur[] participants4 = new Joueur[4];
    private final Joueur[] participants2 = new Joueur[2];
    private final Joueur[][] tableau = {participants128, participants64, participants32, participants16, participants8, participants4, participants2};
    
    public Tournois(TournoisEnum tournois, Joueur[] participants, Arbitre[] arbitres)
    {
        this.tournois = tournois;
        System.arraycopy(participants, 0, this.participants128, 0, this.participants128.length);
        this.arbitres = new Arbitre[arbitres.length];
        System.arraycopy(arbitres, 0, this.arbitres, 0, arbitres.length);
    }
    
    public final Joueur jouer() throws InterruptedException
    {
        Match match;
        for(Integer i = 0; i < tableau.length; i++)
        {
            if(i == 0)
            {
                continue;
            }
            for (Integer j = 0; j < tableau[i].length; j++)
            {
                match = new Match(tableau[i - 1][2 * j], tableau[i - 1][2 * j + 1], arbitres[(int)(Math.random() * arbitres.length)],tournois);
                tableau[i][j] = match.jouer();
            }
        }
        
        Match finale = new Match(participants2[0], participants2[1], arbitres[(int)(Math.random() * arbitres.length)], tournois);
        return finale.jouer();
    }
}
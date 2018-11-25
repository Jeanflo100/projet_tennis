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
public final class Tie_Break
{
    private final Score<Integer> score = new Score<>(0, 0);
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    
    public Tie_Break(Joueur joueur1, Joueur joueur2, Arbitre arbitre)
    {
        joueur1 = new Joueur(joueur1);
        joueur2 = new Joueur(joueur2);
        this.arbitre = arbitre;
    }
    
    public final void setEgalite(Boolean valeur)
    {
        egalite = valeur;
    }
    
    public final Boolean getEgalite()
    {
        return egalite;
    }
    
    public final void jouer()
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
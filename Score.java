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

public final class Score<Type> 

{ 

    private Type pointJ1; 

    private Type pointJ2; 

     

    public Score(Object score1, Object score2) 

    { 

        set(1, score1); 

        set(2, score2); 

    } 

     

    public final void set(Integer joueur, Object point) 

    { 

        switch(joueur) 

        { 

            case 1: 

                pointJ1 = (Type)point; 

                break; 

            case 2: 

                pointJ2 = (Type)point; 

                break; 

            default: 

                System.err.println("Ce joueur est inexistant."); 

                break; 

        } 

    } 

     

    public final Type get(Integer joueur) 

    { 

        switch(joueur) 

        { 

            case 1: 

                return pointJ1; 

            case 2: 

                return pointJ2; 

            default: 

                System.err.println("Ce joueur est inexistant."); 

                return null; 

        } 

    } 

     

    public static final void incremente(Score score, Integer joueur) 

    { 

        if((score.get(joueur) instanceof Points) && (score.get(3 - joueur) instanceof Points)) 

        { 

            ((Points) score.get(joueur)).incremente((Points) score.get(3 - joueur)); 

        } 

        else if((score.get(joueur) instanceof Integer) && (score.get(3 - joueur) instanceof Integer)) 

        { 

            score.set(joueur, (Integer) score.get(joueur) + 1); 

        } 

        else 

        { 

            System.err.println("Type générique de Score non reconnu"); 

        } 

    } 

     

    public static final void decremente(Score score, Integer joueur) 

    { 

        if((score.get(joueur) instanceof Points) && (score.get(3 - joueur) instanceof Points)) 

        { 

            ((Points) score.get(joueur)).decremente((Points) score.get(3 - joueur)); 

        } 

        else if((score.get(joueur) instanceof Integer) && (score.get(3 - joueur) instanceof Integer)) 

        { 

            score.set(joueur, (Integer) score.get(joueur) - 1); 

        } 

        else 

        { 

            System.err.println("Type générique de Score non reconnu"); 

        } 

    } 

     

    @Override 

    public final String toString() 

    { 

        return (get(1) + " - " + get(2)); 

    } 

} 
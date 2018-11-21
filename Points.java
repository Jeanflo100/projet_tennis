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
public final class Points
{
    private PointsEnum valeur = PointsEnum.ZERO;
    
    private final void set(PointsEnum point)
    {
        valeur = point;
    }
    
    private final PointsEnum get()
    {
        return valeur;
    }
    
    public final void incremente(Points adversaire)
    {
        switch(valeur)
        {
            case ZERO:
                set(PointsEnum.QUINZE);
                break;
            case QUINZE:
                set(PointsEnum.TRENTE);
                break;
            case TRENTE:
                set(PointsEnum.QUARANTE);
                break;
            case QUARANTE:
                final Integer comparaison = adversaire.get().compareTo(PointsEnum.QUARANTE);
                if(comparaison < 0)
                {
                    set(PointsEnum.GAGNE);
                }
                else if(comparaison == 0)
                {
                    set(PointsEnum.AVANTAGE);
                }
                else
                {
                    adversaire.decremente(this);
                }
                break;
            case AVANTAGE:
                set(PointsEnum.GAGNE);
                break;
            case GAGNE:
                System.err.println("Le joueur a déjà gagné.");
                break;
            default:
                System.err.println("Impossible d'incrémenté le score " + get());
                break;
        }
    }
    
    public final void decremente(Points adversaire)
    {
        switch(valeur)
        {
            case ZERO:
                System.err.println("Le score du joueur est déjà au plus bas");
                break;
            case QUINZE:
                set(PointsEnum.ZERO);
                break;
            case TRENTE:
                set(PointsEnum.QUINZE);
                break;
            case QUARANTE:
                set(PointsEnum.TRENTE);
                break;
            case AVANTAGE:
                set(PointsEnum.QUARANTE);
                break;
            case GAGNE:
                final Integer comparaison = adversaire.get().compareTo(PointsEnum.QUARANTE);
                if (comparaison < 0)
                {
                    set(PointsEnum.QUARANTE);
                }
                else if (comparaison == 0)
                {
                    set(PointsEnum.AVANTAGE);
                }
                else
                {
                    System.err.println("Erreur dans le contage des points");
                }
                break;
            default:
                System.err.println("Impossible de décrémenté le score : " + get());
                break;
        }
    }
    
    @Override
    public final String toString()
    {
        return get().toString();
    }
}

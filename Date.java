/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tennis;

import java.util.Calendar;

/**
 *
 * @author HUBERT Gilles, TASSART Jean-Florian
 */
public final class Date
{
    private Calendar date = Calendar.getInstance();
    
    public Date(){}
    public Date(Integer jour, Integer mois, Integer annee)
    {
        set(jour, mois, annee);
    }
    public Date(Integer jour, String mois, Integer annee)
    {
        set(jour, mois, annee);
    }
    public Date(Date date)
    {
        set(date.getJour(), date.getMois(), date.getAnnee());
    }
    
    public final void setJour(Integer jour)
    {
        date.set(Calendar.DATE, jour);
    }
    public final void setMois(Integer mois)
    {
        date.set(Calendar.MONTH, mois - 1);
    }
    public final void setMois(String mois)
    {
        final Mois test = Mois.fromString(mois);
        if(test != null)
        {
            final Integer moisInt = test.ordinal();
            date.set(Calendar.MONTH, moisInt);
            return;
        }
        System.err.println("Le mois n'est pas reconnu.");
    }
    public final void setAnnee(Integer annee)
    {
        date.set(Calendar.YEAR, annee);
    }
    public final void set(Integer jour, Integer mois, Integer annee)
    {
        setJour(jour);
        setMois(mois);
        setAnnee(annee);
    }
    public final void set(Integer jour, String mois, Integer annee)
    {
        setJour(jour);
        setMois(mois);
        setAnnee(annee);
    }
    
    public final Integer getJour()
    {
        return date.get(Calendar.DATE);
    }
    public final Integer getMois()
    {
        return date.get(Calendar.MONTH) + 1;
    }
    public final Integer getAnnee()
    {
        return date.get(Calendar.YEAR);
    }

    public final Integer compareA(Date date)
    {
        if (getAnnee() < date.getAnnee())
        {
            return -1;
        }
        if (getAnnee() > date.getAnnee())
        {
            return 1;
        }
        if (getMois() < date.getMois())
        {
            return -1;
        }
        if (getMois() > date.getMois())
        {
            return 1;
        }
        if (getJour() < date.getJour())
        {
            return -1;
        }
        if (getJour() > date.getJour())
        {
            return 1;
        }
        return 0;
    }
    public static final Integer compare(Date date1, Date date2)
    {
        return date1.compareA(date2);
    }
    public static final Date dateAleatoire(Date date1, Date date2)
    {
        if (date1.compareA(date2) == 0)
        {
            return new Date(date1.getJour(), date1.getMois(), date1.getAnnee());
        }
        
        if (date1.compareA(date2) > 0)
        {
            Date date3 = new Date(date1);
            date1 = new Date(date2);
            date2 = new Date(date3);
        }
        
        final Integer anneeMin = Integer.min(date1.getAnnee(), date2.getAnnee());
        final Integer anneeMax = Integer.max(date1.getAnnee(), date2.getAnnee());
        
        Integer jour;
        Integer mois;
        Integer annee;
        Date date;
        do
        {
            jour = (int) (Math.random() * 31) + 1;
            mois = (int) (Math.random() * 12) + 1;
            annee = anneeMin + (int) (Math.random() * (anneeMax - anneeMin + 1));
            date = new Date(jour, mois, annee);
        } while ((date.compareA(date1) < 0) || (date.compareA(date2) > 0));
        return date;
    }
    public final Date difference(Date date)
    {
        Date dateMin = new Date(this);
        Date dateMax = new Date(date);
        if(this.compareA(date) > 0)
        {
            dateMin = new Date(date);
            dateMax = new Date(this);
        }
        
        Integer annee = dateMax.getAnnee() - dateMin.getAnnee();
        if ((dateMax.getMois() < dateMin.getMois()) || ((dateMax.getMois() == dateMin.getMois()) && (dateMax.getJour() < dateMin.getJour())))
        {
            annee--;
        }
        
        Integer mois = dateMax.getMois() - dateMin.getMois();
        if(dateMax.getJour() < dateMin.getJour())
        {
            mois--;
        }
        
        Integer jour = dateMax.getJour() - dateMin.getJour();
        
        return new Date(jour, mois, annee);
    }
    public static final Date difference(Date date1, Date date2)
    {
        return date1.difference(date2);
    }
    
    @Override
    public final String toString()
    {
        return getJour() + " " + Mois.values()[getMois() - 1] + " " + getAnnee();
    }
}

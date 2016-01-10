package com.example.fnk.rftbead.MyClassesSummary;
import java.util.List;


/**
 * Created by Főnök on 2016.01.03..
 */
public class SummaryStatRowCalculator {

    public int getAllChampionKill(List<SummaryStatRow> list)
    {
        int sum = 0;
        for(SummaryStatRow item:list)
        {
            sum += item.getTotalChampionKills();
        }
        return sum;
    }

    public int getWins(List<SummaryStatRow> list)
    {
        int sum=0;
        for(SummaryStatRow item:list)
        {
            sum+=item.getWins();
        }
        return sum;
    }

    public int getAssists(List<SummaryStatRow> list)
    {
        int sum=0;
        for(SummaryStatRow item:list)
        {
            sum+=item.getAssists();
        }
        return sum;
    }

    public int getTurrets(List<SummaryStatRow> list)
    {
        int sum=0;
        for(SummaryStatRow item:list)
        {
            sum+=item.getTurrets();
        }
        return sum;
    }

    public int getFarm(List<SummaryStatRow> list)
    {
        int sum=0;
        for(SummaryStatRow item:list)
        {
            sum+=item.getFarm();
        }
        return sum;
    }

}

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

}

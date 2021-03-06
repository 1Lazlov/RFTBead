package com.example.fnk.rftbead;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnk.rftbead.MyClassesRanked.RankedStatRow;
import com.example.fnk.rftbead.MyClassesRanked.RankedStatRowCalculator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RankedStat extends AppCompatActivity {


    TextView Kills, Assits, Farm, Deaths, Win, Lose, Match;


    private String resultString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranked_stat);

        List<RankedStatRow> allRow = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            resultString= extras.getString("result");
            allRow = getjson(resultString);
        }
        RankedStatRowCalculator calculator = new RankedStatRowCalculator();
        int totalKill = calculator.getAllChampionKill(allRow);
        int totalAssist = calculator.getAllChampionAssist(allRow);
        int totalFarm=calculator.getAllMinionKill(allRow);
        int totalDeath=calculator.getTotalDeaths(allRow);
        int totalWin=calculator.getTotalWins(allRow);
        int totalLose=calculator.getTotalLost(allRow);
        int totalMatch=calculator.getTotalMatch(allRow);
        

        Kills = (TextView) findViewById(R.id.kills);
        Assits=(TextView) findViewById(R.id.assits);
        Farm=(TextView) findViewById(R.id.farm);
        Deaths=(TextView) findViewById(R.id.deaths);
        Win=(TextView) findViewById(R.id.win);
        Lose=(TextView) findViewById(R.id.lose);
        Match=(TextView) findViewById(R.id.match);

        Kills.append(""+totalKill+"  |  "+totalKill/totalMatch+"K/G");
        Assits.append(""+totalAssist+"  |  "+totalAssist/totalMatch+"A/G");
        Farm.append("" + totalFarm+"  |  "+totalFarm/totalMatch+"F/G");
        Deaths.append(""+totalDeath+"  |  "+totalDeath/totalMatch+"D/G");
        Win.append(""+totalWin);
        Lose.append(""+totalLose);
        Match.append(""+totalMatch);

       // Toast.makeText(this,"Összes gyilkosság: "+totalKill+"  Összes assziszt: "+totalAssist+" Összes farm: "+totalFarm,Toast.LENGTH_LONG).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ranked_stat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private List<RankedStatRow> getjson(String jsonstring)
    {
        List<RankedStatRow> statsList = new ArrayList<>();

        JSONObject jsonObject = null;
        try
        {
            jsonObject = new JSONObject(jsonstring);
            JSONArray champions = jsonObject.getJSONArray("champions");
            for(int i = 0; i < champions.length()-1;i++)
            {
                //azért megy csak -1 -ig, mert a legutolsó , az id:0-s az összesített statisztikákat tárolja.
                //https://eune.api.pvp.net/api/lol/eune/v1.3/stats/by-summoner/38521350/ranked?season=SEASON2015&api_key=dfa1a4ba-09c0-4200-80d5-6f42a4fc7fd9

                JSONObject champData = champions.getJSONObject(i);
                JSONObject stats = champData.getJSONObject("stats");

                int championID = champData.getInt("id");
                int totalAssists = stats.getInt("totalAssists");
                int totalChampionKills = stats.getInt("totalChampionKills");
                int totalMinonKills=stats.getInt("totalMinionKills");
                int totalDeaths=stats.getInt("totalDeathsPerSession");
                int totalSessionWon=stats.getInt("totalSessionsWon");
                int totalSessionLost=stats.getInt("totalSessionsLost");

                Log.d("MYLOGGER", "champid: " + championID + "  totalassziszt:" + totalAssists + " totalgyilok" + totalChampionKills +
                        " totalfarm" + totalMinonKills + " totalhalal" + totalDeaths + " totalgyozelem"+totalSessionWon+" totalvereseg"+totalSessionLost);

                RankedStatRow rankedStat = new RankedStatRow();
                rankedStat.setTotalAssists(totalAssists);
                rankedStat.setTotalChampionKills(totalChampionKills);
                rankedStat.setTotalFarm(totalMinonKills);
                rankedStat.setTotalDeaths(totalDeaths);
                rankedStat.setTotalWins(totalSessionWon);
                rankedStat.setTotalLost(totalSessionLost);

                statsList.add(rankedStat);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return statsList;
    }


}


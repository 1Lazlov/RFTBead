package com.example.fnk.rftbead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fnk.rftbead.MyClassesSummary.SummaryStatRow;
import com.example.fnk.rftbead.MyClassesSummary.SummaryStatRowCalculator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class SummaryStatActivity extends AppCompatActivity {



    TextView Kills, Wins, Turrets, Farm, Assist;

    private String resultString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_stat);

        Bundle extras = getIntent().getExtras();
        List<SummaryStatRow> allRow = new ArrayList<>();
        if(extras != null) {
            resultString= extras.getString("result");
            allRow = getjson(resultString);
        }
        SummaryStatRowCalculator calculator = new SummaryStatRowCalculator();


        int totalKill = calculator.getAllChampionKill(allRow);
        int totalWin=calculator.getWins(allRow);
        int totalAssists=calculator.getAssists(allRow);
        int totalTurrets=calculator.getTurrets(allRow);
        int totalFarm=calculator.getFarm(allRow);


        Kills = (TextView) findViewById(R.id.kills);
        Wins=(TextView) findViewById(R.id.wins);
        Assist=(TextView) findViewById(R.id.nassists);
        Turrets=(TextView) findViewById(R.id.turrets);
        Farm=(TextView) findViewById(R.id.nfarm);

        Kills.append(""+totalKill);
        Wins.append(""+totalWin);
        Assist.append(""+totalAssists);
        Turrets.append(""+totalTurrets);
        Farm.append(""+totalFarm);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summary_stat, menu);
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

    private List<SummaryStatRow> getjson(String jsonstring)
    {
        List<SummaryStatRow> statsList = new ArrayList<>();

        JSONObject jsonObject = null;
        try
        {
            jsonObject = new JSONObject(jsonstring);
            JSONArray playerStatSummaries = jsonObject.getJSONArray("playerStatSummaries");

            JSONObject champData = playerStatSummaries.getJSONObject(playerStatSummaries.length() - 1);
            JSONObject aggregatedStats = champData.getJSONObject("aggregatedStats");

            int totalWins=champData.getInt("wins");
            int totalKills = aggregatedStats.getInt("totalChampionKills");
            int totalAssists=aggregatedStats.getInt("totalAssists");
            int totalTurrets=aggregatedStats.getInt("totalTurretsKilled");
            int totalFarm=aggregatedStats.getInt("totalMinionKills");

            SummaryStatRow summaryStat = new SummaryStatRow();

            summaryStat.setTotalChampionKills(totalKills);
            summaryStat.setWins(totalWins);
            summaryStat.setAssists(totalAssists);
            summaryStat.setTurrets(totalTurrets);
            summaryStat.setFarm(totalFarm);

            statsList.add(summaryStat);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return statsList;
    }



}

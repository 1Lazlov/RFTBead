package com.example.fnk.rftbead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Page2 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page2, menu);
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

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button2:
            {
                Storage storage = new Storage(this);

                Queries queries = new Queries();
                String query = queries.getGameData(false,storage.getSummonerId(),storage.getSummonerRegion());

                Connection connection = new Connection(this,"getgamedataranked");
                connection.execute(query);
                break;
            }
            case R.id.button3:
            {
                Storage storage = new Storage(this);

                Queries queries = new Queries();
                String query = queries.getGameData(true,storage.getSummonerId(),storage.getSummonerRegion());
                Log.d("MYLOGGER",query);
                Connection connection = new Connection(this,"getgamedatasummary");
                connection.execute(query);
                break;
            }
        }
    }
}

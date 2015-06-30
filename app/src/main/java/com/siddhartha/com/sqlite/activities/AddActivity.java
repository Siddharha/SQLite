package com.siddhartha.com.sqlite.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.siddhartha.com.sqlite.R;
import com.siddhartha.com.sqlite.adapters.MyListAdapter;

import java.io.Serializable;

public class AddActivity extends AppCompatActivity {

    ListView listView;
    MyListAdapter myListAdapter;
    Serializable i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_slide_out_bottom);

        initialize();


    }

    private void display() {
        listView.setAdapter(myListAdapter);
    }

    private void initialize() {
        listView = (ListView)findViewById(R.id.listView);
       // myListAdapter = new MyListAdapter(this,i);

    }

    @Override
    protected void onResume() {
        super.onResume();
        i = getIntent().getParcelableExtra("Name");
        Log.e("Show --> ", i.toString());
        display();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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
}

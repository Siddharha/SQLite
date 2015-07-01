package com.siddhartha.com.sqlite.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.siddhartha.com.sqlite.R;
import com.siddhartha.com.sqlite.adapters.MyListAdapter;
import com.siddhartha.com.sqlite.bean.items;
import com.siddhartha.com.sqlite.util.DatabaseHandler;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    ListView listView;
    MyListAdapter myListAdapter;
    ArrayList<items> arrayList;
    Button btn_dlt;
   // Serializable i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_slide_out_bottom);

        initialize();
        loadData();


    }

    private void loadData() {
        DatabaseHandler db = new DatabaseHandler(this);
        for(int i=0;i<db.getAllContacts().size();i++)
        {
           // items P = new items();
            arrayList.add(db.getAllContacts().get(i));
        }

        Log.e("Array Items --> ",arrayList.toString());
        myListAdapter = new MyListAdapter(this,arrayList);
        db.close();
    }

    private void display() {
        listView.setAdapter(myListAdapter);
        if(arrayList.size()== 0)
        {
            btn_dlt.setVisibility(View.GONE);
        }
        else
        {
            btn_dlt.setVisibility(View.VISIBLE);
        }
    }

    private void initialize() {
        listView = (ListView)findViewById(R.id.listView);
       //
        arrayList = new ArrayList<items>();
        btn_dlt = (Button)findViewById(R.id.btn_dlt);

    }

    @Override
    protected void onResume() {
        super.onResume();
      //  i = getIntent().getParcelableExtra("Name");
      //  Log.e("Show --> ", i.toString());
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

    public void btn_dlt(View view)
    {
        DatabaseHandler db = new DatabaseHandler(this);


        db.deleteContacts();
        db.close();
        myListAdapter.notifyDataSetChanged();

        Toast.makeText(getBaseContext(),"Deleted Database!",Toast.LENGTH_SHORT).show();
    }
}

package com.siddhartha.com.sqlite.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.siddhartha.com.sqlite.R;
import com.siddhartha.com.sqlite.bean.items;
import com.siddhartha.com.sqlite.util.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView Name_txt;
    EditText txt_number;
   ArrayList<String> arrayList1,arrayList2;
    ArrayAdapter arrayAdapter;
    List<items> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();




    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");


        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        contacts = db.getAllContacts();

        for (items cn : contacts) {
            String log = "Id: " + cn.getIndex() + " ,Name: " + cn.getNames() + " ,Phone: " + cn.getNumbers();
            // Writing Contacts to log
            // Log.e("Name: ", log);
            arrayList1.add(cn.getNames());
            arrayList2.add(cn.getNumbers());


        }
        Log.e("Name: ", arrayList1.toString());
        arrayAdapter = new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,arrayList1);
        Name_txt.setAdapter(arrayAdapter);
        Name_txt.setThreshold(1);

        overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_fade_out);
    }


    private void initialize() {
        Name_txt = (AutoCompleteTextView)findViewById(R.id.Name_txt);
        txt_number = (EditText)findViewById(R.id.txt_number);
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
    }

    public void Clk_add(View view)
    {

      //  items details = new items();
        String x,y;
        x = Name_txt.getText().toString();
        y = txt_number.getText().toString();

        Intent intent = new Intent(getBaseContext(), AddActivity.class);
        if(!x.equals("")) {
            DatabaseHandler db = new DatabaseHandler(this);
            db.addContact(new items(x, y));
            db.close();
        }

        startActivity(intent);


    }
}
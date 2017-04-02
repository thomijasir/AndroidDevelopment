package com.thomionewave.animalcustomearray;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Langka extends AppCompatActivity {
    String[] hewan = {"Anoa","Bekantan","Jalak Bali","Enggang gading"};
    String names[] = new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langka);


        ListView daftardataternak = (ListView) findViewById(R.id.listlangka);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,hewan);
        daftardataternak.setAdapter(adapter);
    }
    // Untuk Baca JasonFile
    public String bacaJason() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}

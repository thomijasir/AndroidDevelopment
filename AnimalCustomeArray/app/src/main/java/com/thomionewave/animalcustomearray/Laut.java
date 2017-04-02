package com.thomionewave.animalcustomearray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Laut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laut);
        final ArrayList<CustomArray> datalaut = new ArrayList<>();
        datalaut.add(new CustomArray("Angsa", "Cygnus Olor", R.drawable.angsa,R.raw.angsa));
        datalaut.add(new CustomArray("Ayam", "Cygnus Olor", R.drawable.ayam,R.raw.ayam));
        datalaut.add(new CustomArray("Bebek","Cygnus Olor", R.drawable.bebek,R.raw.bebek));
        datalaut.add(new CustomArray("Domba","Cygnus Olor", R.drawable.domba,R.raw.domba));

        ListView daftardatalaut = (ListView) findViewById(R.id.listlaut);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, datalaut, R.color.category_phrases);
        daftardatalaut.setAdapter(adapter);

        daftardatalaut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i("On Click", datalaut.get(position). toString());
            }
        });
    }
}

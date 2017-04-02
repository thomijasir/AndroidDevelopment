package com.thomionewave.animalcustomearray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Ternak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak);
        final ArrayList<CustomArray> dataternak = new ArrayList<>();
        dataternak.add(new CustomArray("Angsa", "Cygnus Olor", R.drawable.angsa,R.raw.angsa));
        dataternak.add(new CustomArray("Ayam", "Cygnus Olor", R.drawable.ayam,R.raw.ayam));
        dataternak.add(new CustomArray("Bebek","Cygnus Olor", R.drawable.bebek,R.raw.bebek));
        dataternak.add(new CustomArray("Domba","Cygnus Olor", R.drawable.domba,R.raw.domba));

        ListView daftardataternak = (ListView) findViewById(R.id.listternak);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, dataternak, R.color.category_numbers);
        daftardataternak.setAdapter(adapter);

        daftardataternak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i("On Click", dataternak.get(position). toString());
            }
        });
    }
}

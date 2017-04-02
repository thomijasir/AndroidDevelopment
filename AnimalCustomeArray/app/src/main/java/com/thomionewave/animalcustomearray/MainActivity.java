package com.thomionewave.animalcustomearray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ternak = (TextView) findViewById(R.id.ternaklist);
        ternak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ternak.class);
                startActivity(intent);
            }
        });

        TextView hutan = (TextView) findViewById(R.id.hutanlist);
        hutan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Hutan.class);
                startActivity(intent);
            }
        });

        TextView laut = (TextView) findViewById(R.id.lautlist);
        laut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Laut.class);
                startActivity(intent);
            }
        });

        TextView langka = (TextView) findViewById(R.id.langkalist);
        langka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Langka.class);
                startActivity(i);
            }
        });

    }
    public void about(View view){
        Toast.makeText(getApplicationContext(), "Thomi Jasir 6706151124", Toast.LENGTH_LONG).show();
    }
}

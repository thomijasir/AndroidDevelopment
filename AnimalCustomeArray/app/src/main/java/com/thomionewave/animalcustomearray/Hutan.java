package com.thomionewave.animalcustomearray;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Hutan extends AppCompatActivity {


    public MediaPlayer PlayMedia(int mediafiles){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, mediafiles);
        return mediaPlayer;
    }
    public int GetResource(String values){
        int resID = getResources().getIdentifier(values.toLowerCase() , "drawable", getPackageName());
        return resID;
    }

    public int GetRaw(String values){
        int rawID = getResources().getIdentifier(values.toLowerCase() , "raw", getPackageName());
        return rawID;
    }

    private String TAG = Hutan.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView daftardatahutan;

    // URL to get contacts JSON
    private static String url = "http://dif.indraazimi.com/data.json";

    // Variable Array List
    ArrayList<CustomArray> datahutan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hutan);
        datahutan = new ArrayList<>();

        daftardatahutan = (ListView) findViewById(R.id.listhutan);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, datahutan, R.color.category_family);
        daftardatahutan.setAdapter(adapter);
        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Hutan.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("hutan");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String nama = c.getString("nama");
                        String latin = c.getString("latin");

                        // adding contact to contact list
                        if(GetResource(nama) != 0){
                            datahutan.add(new CustomArray(nama,latin, GetResource(nama),GetRaw(nama)));
                        }

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Duh Internet Sia Wafat... :(",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
        }

    }


}

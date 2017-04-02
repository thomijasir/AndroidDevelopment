package com.thomionewave.animalcustomearray;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Praktikan on 27/02/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter {
    private int mbackgroundColor;

    public CustomArrayAdapter(Context konteks, ArrayList<CustomArray> object, int backgroundColor) {
        super(konteks, 0, object);
        mbackgroundColor = backgroundColor;
    }

    public MediaPlayer PlayMedia(int mediafiles){
        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), mediafiles);
        return mediaPlayer;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_custom, parent, false);
        }
        final CustomArray current = (CustomArray) getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);

        imageView.setImageResource(current.getC());
        imageView.setVisibility(View.VISIBLE);

        final ImageView playbut = (ImageView) convertView.findViewById(R.id.playbutton);
        playbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayMedia(current.getD()).start();
                playbut.setImageResource(R.drawable.ic_pause_circle_filled);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playbut.setImageResource(R.drawable.ic_play_circle_filled);
                    }
                }, 600);
            }
        });

        LinearLayout words = (LinearLayout) convertView.findViewById(R.id.words);
        words.setBackgroundColor(ContextCompat.getColor(getContext(), mbackgroundColor));

        TextView miwokWord = (TextView) convertView.findViewById(R.id.texta);
        miwokWord.setText(current.getA());

        TextView defaultWord = (TextView) convertView.findViewById(R.id.textb);
        defaultWord.setText(current.getB());

        return convertView;
    }
}

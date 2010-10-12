package com.android.eq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.android.eq.domain.Emotion;
import com.android.eq.service.Emotions;

public class Home extends Activity {
    public static final String EMOTION_ID = "EMOTION_ID";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new EmotionsAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Emotion emotion = new Emotions().emotionAt(position);

                Intent intent = new Intent(Home.this, EnterText.class);
                intent.putExtra(EMOTION_ID, emotion.getId());
                startActivity(intent);
            }
        });
    }
}
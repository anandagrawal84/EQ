package com.android.eq;

import java.util.ArrayList;

import android.app.Activity;
import com.android.eq.service.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.eq.domain.Emotion;
import com.android.eq.domain.Mood;
import com.android.eq.service.Emotions;


public class EnterText extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_text);

        TextView prompt = (TextView) findViewById(R.id.prompt);
        final Emotion emotion = new Emotions().findById(getIntent().getLongExtra(Home.EMOTION_ID, -1));
        prompt.setText("Why so " + emotion.getDescription() + "?");
        final EditText text = (EditText)findViewById(R.id.text);
        Button createButton = (Button) findViewById(R.id.create);
        createButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
            	String reason = text.getText().toString();
                Toast.makeText(EnterText.this, "" + emotion.getDescription(), Toast.LENGTH_SHORT).show();
                DbAdapter dbAdapter = new DbAdapter(getApplicationContext());
                dbAdapter.createMood(new Mood(emotion.getId() , reason));
                
//                ArrayList<Mood> moods = dbAdapter.fetchAllMoods();
//                String reasons = null;
//                for (Mood mood : moods) {
//                     reasons += mood.getReason();
//                }
//                text.setText(reasons);
            }
        });
    }
}

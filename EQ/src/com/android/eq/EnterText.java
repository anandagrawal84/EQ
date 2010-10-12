package com.android.eq;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.eq.domain.Emotion;
import com.android.eq.service.Emotions;

public class EnterText extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_text);

        final long position = 1;
        TextView prompt = (TextView) findViewById(R.id.prompt);
        final Emotion emotion = new Emotions().findById(getIntent().getLongExtra(Home.EMOTION_ID, -1));
        prompt.setText("Why so " + emotion.getDescription() + "?");

        Button createButton = (Button) findViewById(R.id.create);
        createButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Toast.makeText(EnterText.this, "" + emotion.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

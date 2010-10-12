package com.android.eq.service;

import com.android.eq.R;
import com.android.eq.domain.Emotion;

import java.util.ArrayList;

public class Emotions {
    private ArrayList<Emotion> emotions = new ArrayList<Emotion>();

    public Emotions() {
        emotions.add(new Emotion(1, R.drawable.smile, "Happy"));
        emotions.add(new Emotion(2, R.drawable.serious, "Serious"));
        emotions.add(new Emotion(3, R.drawable.sad, "sad"));
    }

    public ArrayList<Emotion> all() {
        return emotions;
    }

    public Emotion emotionAt(int index){
        return emotions.get(index);
    }

    public Emotion findById(long id){
        for (Emotion emotion : emotions) {
            if (emotion.getId() == id) {
                return emotion;
            }
        }
        return null;
    }
}

package com.android.eq.domain;

import android.content.ContentValues;
import com.android.eq.service.DbAdapter;
import java.util.Date;

public class Mood {
    private long emotionId;
    private String reason;
    private Date created_on;


    public Mood(long emotionId, String reason) {
        this.emotionId = emotionId;
        this.reason = reason;
        this.created_on = new Date();
    }

    public Mood(long emotionId, String reason, Date created_on) {
        this.emotionId = emotionId;
        this.reason = reason;
        this.created_on = created_on;
    }

    public long getEmotionId() {
        return emotionId;
    }

    public String getReason() {
        return reason;
    }
	
    public ContentValues toContentValues() {
		ContentValues values = new ContentValues();
		values.put(DbAdapter.EMOTION_ID, emotionId);
		values.put(DbAdapter.MOOD_REASON, reason);
		values.put(DbAdapter.MOOD_CREATED_ON, created_on.toString());
		return values;
	}

}

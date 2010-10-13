package com.android.eq.domain;

public class Emotion {
    private long id;
    private long imageId;
    private String description;


    public Emotion(long id, long imageId, String description) {
        this.id = id;
        this.imageId = imageId;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }
}

package com.example.Quizz_app.Adapter;

public class DataProduct {
    String topic;

    String decriptionTopic;

    int imageTopic;

    public DataProduct() {
    }

    public DataProduct(String topic, String decriptionTopic, int imageTopic) {
        this.topic = topic;
        this.decriptionTopic = decriptionTopic;
        this.imageTopic = imageTopic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDecriptionTopic() {
        return decriptionTopic;
    }

    public void setDecriptionTopic(String decriptionTopic) {
        this.decriptionTopic = decriptionTopic;
    }

    public int getImageTopic() {
        return imageTopic;
    }

    public void setImageTopic(int imageTopic) {
        this.imageTopic = imageTopic;
    }
}

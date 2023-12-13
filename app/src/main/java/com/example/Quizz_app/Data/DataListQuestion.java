package com.example.Quizz_app.Data;

public class DataListQuestion {
    int id;
    String listQuestion;
    public DataListQuestion() {
    }
    public DataListQuestion(String listQuestion, int id) {
        this.id = id;
        this.listQuestion = listQuestion;
    }
    public String getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(String listQuestion) {
        this.listQuestion = listQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

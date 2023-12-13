package com.example.Quizz_app.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {
    // data binding

    MutableLiveData<String> topic = new MutableLiveData<>();
    MutableLiveData<Integer> level = new MutableLiveData<>();
    MutableLiveData<String> answer = new MutableLiveData<>();

    MutableLiveData<String> id = new MutableLiveData<>();

    MutableLiveData<Integer> scores = new MutableLiveData<>();

    MutableLiveData<Integer> correctQuestion = new MutableLiveData<>();

    public MutableLiveData<Integer> getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores.setValue(scores);
    }

    public MutableLiveData<String> getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer.setValue(answer);
    }

    public MutableLiveData<String> getTopic() {
        return topic;
    }

    public MutableLiveData<Integer> getLevel() {
        return level;
    }
    public MutableLiveData<String> getId() {
        return id;
    }

    public void setTopic(String a) {
        this.topic.setValue(a);
    }

    public void setLevel(int a) {
        this.level.setValue(a);
    }

    public void setId(int id) {
        this.id.setValue(String.valueOf(id));
    }

    public MutableLiveData<Integer> getCorrectQuestion() {
        return correctQuestion;
    }

    public void setCorrectQuestion(int correctQuestion) {
        this.correctQuestion.setValue(correctQuestion);
    }
}

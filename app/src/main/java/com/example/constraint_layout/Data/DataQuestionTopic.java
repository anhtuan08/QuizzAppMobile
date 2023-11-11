package com.example.constraint_layout.Data;

import android.widget.RadioButton;
import android.widget.TextView;

public class DataQuestionTopic {
    TextView textViewQuestion;

    RadioButton q1, q2, q3, q4;

    public DataQuestionTopic() {
    }

    public DataQuestionTopic(TextView textViewQuestion, RadioButton q1, RadioButton q2, RadioButton q3, RadioButton q4) {
        this.textViewQuestion = textViewQuestion;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
    }

    public TextView getTextViewQuestion() {
        return textViewQuestion;
    }

    public void setTextViewQuestion(TextView textViewQuestion) {
        this.textViewQuestion = textViewQuestion;
    }

    public RadioButton getQ1() {
        return q1;
    }

    public void setQ1(RadioButton q1) {
        this.q1 = q1;
    }

    public RadioButton getQ2() {
        return q2;
    }

    public void setQ2(RadioButton q2) {
        this.q2 = q2;
    }

    public RadioButton getQ3() {
        return q3;
    }

    public void setQ3(RadioButton q3) {
        this.q3 = q3;
    }

    public RadioButton getQ4() {
        return q4;
    }

    public void setQ4(RadioButton q4) {
        this.q4 = q4;
    }
}

package com.quiz.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String quizName;
    @Transient
    private List<Question> question;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }
}

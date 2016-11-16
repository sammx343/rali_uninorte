package com.example.jairbsena.raliuninorte;

import java.io.Serializable;

/**
 * Created by ftorr on 16/11/2016.
 */

public class Place implements Serializable {
    public String descriptionPlace;
    public String idBeacon;
    public String textPlace;
    public String questionPlace;
    public String[] answersPlace;
    public String answerCorrect;

    public Place() {
    }

    public Place(String descriptionPlace, String idBeacon, String textPlace, String questionPlace, String[] answersPlace, String answerCorrect) {
        this.descriptionPlace = descriptionPlace;
        this.idBeacon = idBeacon;
        this.textPlace = textPlace;
        this.questionPlace = questionPlace;
        this.answersPlace = answersPlace;
        this.answerCorrect = answerCorrect;
    }

    public String getDescriptionPlace() {
        return descriptionPlace;
    }

    public void setDescriptionPlace(String descriptionPlace) {
        this.descriptionPlace = descriptionPlace;
    }

    public String getIdBeacon() {
        return idBeacon;
    }

    public void setIdBeacon(String idBeacon) {
        this.idBeacon = idBeacon;
    }

    public String getTextPlace() {
        return textPlace;
    }

    public void setTextPlace(String textPlace) {
        this.textPlace = textPlace;
    }

    public String getQuestionPlace() {
        return questionPlace;
    }

    public void setQuestionPlace(String questionPlace) {
        this.questionPlace = questionPlace;
    }

    public String[] getAnswersPlace() {
        return answersPlace;
    }

    public void setAnswersPlace(String[] answersPlace) {
        this.answersPlace = answersPlace;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }
}

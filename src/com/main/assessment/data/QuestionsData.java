package com.main.assessment.data;

import java.util.ArrayList;
import java.util.List;

import com.main.assessment.concrete.Questions;

/**
 * QuestionsData
 */
public class QuestionsData {

    private static List<Questions> questions = new ArrayList<>();

    /*
     * to get all questions
     */
    public List<Questions> getAllQuestions() {
        return questions;
    }

    /*
     * to get a particular question
     */
    public Questions getQuestions(String qId) {
        return questions.stream().filter(question -> question.getQuestionId().equals(qId)).findFirst().orElse(null);
    }
}
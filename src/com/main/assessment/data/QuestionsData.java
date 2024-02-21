package com.main.assessment.data;

import java.util.ArrayList;
import java.util.List;

import com.main.assessment.concrete.Questions;

/**
 * QuestionsData
 */
public class QuestionsData {

    private static List<Questions> questions = new ArrayList<>(
            List.of(
                    new Questions("dhinesh1", "Is java is 100 % pure object oriented language ?", "no",
                            new ArrayList<>(List.of("yes", "no", "maybe", "none"))),
                    new Questions("dhinesh2", "Is comparable tightly coupled with concrete class?", "yes",
                            new ArrayList<>(List.of("yes", "no", "maybe", "none"))),
                    new Questions("saranya1", "Is comparator tightly coupled with concrete class?", "no",
                            new ArrayList<>(List.of("yes", "no", "maybe", "none"))),
                    new Questions("saranya2",
                            "Which data structure defined in the structure of key-value pairs in java ?", "Map",
                            new ArrayList<>(List.of("Map", "Set", "List", "Queue")))));

    /*
     * to get all questions
     */
    public List<Questions> getAllQuestions() {
        return questions;
    }

    /*
     * to get a particular question
     */
    public Questions getQuestion(String qId) {
        return questions.stream().filter(question -> question.getQuestionId()
                .equals(qId)).findFirst().orElse(null);
    }

    /*
     * to get list of questions by question group Id
     */
    public List<Questions> getQuestionsByGroupId(String groupId) {
        return questions.stream().filter(question -> question.getQuestionId()
                .contains(groupId)).toList();
    }

    /*
     * to add a new Question
     */
    public void addQuestion(Questions question) {
        questions.add(question);
    }
}
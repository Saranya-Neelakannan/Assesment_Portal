package com.main.assessment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.main.assessment.concrete.Admin;
import com.main.assessment.concrete.Questions;
import com.main.assessment.data.AdminData;
import com.main.assessment.data.QuestionsData;

/**
 * AdminService
 */
public class AdminService {
    private AdminData adminData = new AdminData();
    private QuestionsData qData = new QuestionsData();
    private Admin admin = new Admin();
    private BufferedReader reader;

    public AdminService(BufferedReader reader) {
        this.reader = reader;
    }

    /*
     * to login the admin
     */
    public boolean login(String username, String password) {
        admin = adminData.getAdmin(username, password);
        if (admin != null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * to create a new group of questions.
     */
    public boolean createQuestionGroup() throws IOException {
        System.out.print("Enter the name of the Question group : ");
        String groupName = reader.readLine();
        if (qData.getQuestionsByGroupId(groupName).size() == 0) {
            System.out.print("Enter the no of questions you want to add : ");
            int noOfQuestions = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= noOfQuestions; i++) {
                getQuestions(groupName, String.valueOf(i));
            }
            return true;
        } else {
            return false;
        }
    }

    /*
     * to get a particular question from the admin
     */
    public void getQuestions(String qGroupName, String count) throws IOException {
        String qId = qGroupName + count;
        System.out.print("Enter the question : ");
        String question = reader.readLine();
        System.out.print("Enter the answer of the question : ");
        String answer = reader.readLine();
        System.out.print("Enter the Options of the above question : ");
        List<String> options = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.print("Option " + i + 1 + " : ");
            options.add(reader.readLine());
            System.out.println();
        }
        qData.addQuestion(new Questions(qId, question, answer, options));
    }

}
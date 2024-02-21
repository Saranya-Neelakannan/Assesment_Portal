package com.main.assessment;

import java.io.InputStreamReader;

import com.main.assessment.controller.AdminController;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * AssessmentPortal
 */
public class AssessmentPortal {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AdminController adminController = new AdminController(reader);
        adminController.start();
    }
}
package com.main.assessment.utilities;

/**
 * Utils
 */
public class Utils {

    private Utils() {
    }

    /*
     * to view the admin menus with it's choices.
     */
    public static void adminMenu() {
        System.out.println("1.View all Employees.\n2.View All Questions.\n3.View Questions by Group Name.\n");
    }

    /*
     * to view the employee menus with it's choices.
     */
    public static void employeeMenu() {
        System.out.println(
                "1.Login.\n2.Register.\n3.Begin Assessment.\n4.View all Assessments.\n5.View Pending Assessments.\n6.View Completed Assessments.\n7.View all Assessment Marks.\n8.View Particular Question Group Assessment Mark.\n");
    }

}
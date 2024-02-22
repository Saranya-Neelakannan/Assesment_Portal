package com.main.assessment.utilities;

/**
 * Utils
 */
public class Utils {

	/*
	 * to view the admin menus with it's choices.
	 */
	public static void adminMenu() {
		System.out.println(
				"1.Add Employee.\n2.Delete Employee.\n3.View all Employees.\n4.View All Questions.\n5.View Questions by Group Name.\n6.Assign Assessments to the Employee.\n7.Create Questions.\n");
	}

	/*
	 * to view the employee menus with it's choices.
	 */
	public static void employeeMenu() {
		System.out.println(
				"1.Begin Assessment.\n2.View all Assessments.\n3.View Pending Assessments.\n4.View Completed Assessments.\n5.View all Assessment Marks.\n6.View Particular Question Group Assessment Mark.\n");
	}

	/*
	 * to view the initial menu
	 */
	public static void initialMenu() {
		System.out.println("1.Admin.\n2.Employee.\n3.Exit.\n");
	}

	private Utils() {
	}

}
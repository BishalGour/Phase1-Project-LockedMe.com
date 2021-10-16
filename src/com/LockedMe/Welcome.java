package com.LockedMe;

import java.util.Scanner;

public class Welcome {
	public static void main(String[] args) {
		// Welcome Page
		System.out.println("*					*");
		System.out.println("*   WELCOME TO LockedMe.com APP	*");
		System.out.println("*   This is developed by Bishal Gour *");
		System.out.println("*					*");
		System.out.println("==========================================");

		System.out.println("Select an option and the press Enter");
		System.out.println(" 1. Registration\n 2. Login\n");
		int option = new Scanner(System.in).nextInt();
		switch (option) {
		case 1:
			new Login().RegisterUser();
			break;
		case 2:
			Boolean validation = new Login().login();
			if (validation == true) {
				// Call UserInterface function
				UserInterface ui = new UserInterface();
				ui.userInterface();
			} else {
				System.out.println("Not a valid User ");
			}
			break;
		}
	}
}

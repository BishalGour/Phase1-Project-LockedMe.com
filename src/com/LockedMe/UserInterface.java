package com.LockedMe;

import java.util.Scanner;

public class UserInterface {
	void exit(){
		System.out.println("Program exited succesfully !");
	}

	//Prompt user interface options.
	void userInterface(){
		System.out.println("Select any option from below ");
		System.out.println("1. Retrieving the file names in an ascending order");
		System.out.println("2. Business Level Operations  ");
		System.out.println("3. Close the Application  ");

		//Read Input from user
		Scanner input=new Scanner(System.in);
		int option= input.nextInt();

		switch(option)
		{
		case 1: new FileOperations().listFiles(); break;

		case 2:new FileOperations().businessOperations(); break;

		case 3: exit(); break;
		}
		input.close();
	}
}

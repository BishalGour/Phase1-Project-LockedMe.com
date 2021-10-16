package com.LockedMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {
	UserInterface ui = new UserInterface();
	Scanner s = new Scanner(System.in);
	public String dir = System.getProperty("user.dir").concat("\\userFiles\\");

	void listFiles() {
		// dir=dir.concat("\\userFiles\\");
		File directoryPath = new File(dir);
		String str[] = directoryPath.list();
		String temp;
		System.out.println("Strings in sorted order:");
		for (int j = 0; j < str.length; j++) {
			for (int i = j + 1; i < str.length; i++) {
				// comparing adjacent strings
				if (str[i].compareTo(str[j]) < 0) {
					temp = str[j];
					str[j] = str[i];
					str[i] = temp;
				}
			}
			System.out.println(str[j]);
		}
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		ui.userInterface();
	}

	void addFile() {
		// Get relative path

		File f = new File(dir);
		f.mkdir();

		System.out.println("Please Enter File name : ");
		String fileName = s.next();

		File stockFile = new File(dir + fileName);
		try {

			if (stockFile.createNewFile()) {
				System.out.println(stockFile.getName() + " created succesfully");
			} else {
				System.out.println("File already exists.");
			}

			System.out.println("Do you want to insert content to your file:Y/N ");

			String option = s.next();

			if (option.equalsIgnoreCase("Y")) {
				System.out.println("Enter contents to written in file :");
				String contents = new Scanner(System.in).nextLine();
				System.out.println(contents);
				FileWriter writer = new FileWriter(stockFile);

				writer.write(contents);
				writer.close();
				System.out.println("Successfully wrote to the file:" + stockFile.getName());

			} else {
				System.out.println("Cannot be inserted");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		ui.userInterface();
	}

	void deleteFile() {

		System.out.println("Enter file name to delete: ");
		File deleteFile = new File(dir.concat(s.next()));

		if (deleteFile.delete()) {
			System.out.println("File: " + deleteFile.getName() + " Deleted succesfully");
		} else {
			System.out.println("File not found \n");
		}
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		ui.userInterface();
	}

	int fileSearch() {
		File searchFile = new File(dir);
		String[] fileNames = searchFile.list();
		System.out.println(Arrays.toString(fileNames));
		int min = 0, max = fileNames.length - 1;
		int mid;

		System.out.println("Enter file name to search: ");
		String key = s.next();

		while (min <= max) {
			mid = (min + max) / 2;
			if (fileNames[mid].compareTo(key) < 0) {
				min = mid + 1;
			} else if (fileNames[mid].compareTo(key) > 0) {
				max = mid - 1;
			} else {
				return 1;
			}
		}
		return -1;
	}

	void businessOperations() {
		// Business operations
		System.out.println("Select any option from below for business operation");
		System.out.println(" 1) Add a file to the Application");
		System.out.println(" 2) Delete an existing file from Application");
		System.out.println(" 3) Search a file from an Application");
		System.out.println(" 4) Return to Main context");
		System.out.println(" 5) Close the Application");

		// user input
		// Scanner s=new Scanner(System.in);
		int option = s.nextInt();

		// UserInterface ui=new UserInterface();

		switch (option) {
		case 1:
			addFile();
			break;
		case 2:
			deleteFile();
			break;
		case 3:
			int flag = fileSearch();
			if (flag == 1) {
				System.out.println("File found at directory:" + dir);
			} else {
				System.out.println("File not found at directory:" + dir);
			}

			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
			ui.userInterface();
			break;
		case 4:
			ui.userInterface();
			break;
		case 5:
			ui.exit();
			break;
		}
	}
}
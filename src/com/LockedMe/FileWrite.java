package com.LockedMe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {
	public static void main(String[] args) {
		String dir = System.getProperty("user.dir").concat("\\userFiles\\UserCreds");

		try (FileWriter f = new FileWriter(dir, true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) {
			p.println("Bishal/12345");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
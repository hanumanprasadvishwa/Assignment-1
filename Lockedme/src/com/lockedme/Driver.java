package com.lockedme;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		final String ROOT_DIRECTORY_PATH = "D:\\Files";
		String fileName;
		LockedMeBO bo = new LockedMeBO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To LockedMe.Com");
		System.out.println("Developer Information");
		System.out.println("Mr.Hanuman-Learner(Full Stack Java Developer-Cohort-2)");
		int ch, ch1;
		do {
			while (true) {
				System.out.println("1-List Files In Ascending Order");
				System.out.println("2-Edit");
				System.out.println("3-Exit");
				System.out.println("Enter Your Choice");
				ch = sc.nextInt();
				if (ch == 1 || ch == 2 || ch == 3)
					break;
				System.err.println("Please Enter Correct Choice");
			}
			switch (ch) {
			case 1:
				bo.displayFilesInAscendingOrder(ROOT_DIRECTORY_PATH);
				break;
			case 2:
				do {
					while (true) {
						System.out.println("1-Add Files To The Specified Directory");
						System.out.println("2-Delete Files From The Specified Directory");
						System.out.println("3-Search a File From The Specified Directory");
						System.out.println("4-Switch To Main Menu");
						ch1 = sc.nextInt();
						if (ch1 == 1 || ch1 == 2 || ch1 == 3 || ch1 == 4)
							break;
						System.err.println("Please Enter Correct Choice");
					}
					switch (ch1) {
					case 1:
						System.out.println("Enter The File Name To Add");
						fileName = readFileName(sc);
						bo.addFile(fileName, ROOT_DIRECTORY_PATH);
						break;
					case 2:
						System.out.println("Enter The File Name To Remove");
						fileName = readFileName(sc);
						bo.deleteFile(fileName, ROOT_DIRECTORY_PATH);
						break;
					case 3:
						System.out.println("Enter The File Name To Search");
						fileName = readFileName(sc);
						bo.searchFile(fileName, ROOT_DIRECTORY_PATH);
						break;
					}
				} while (ch1 <= 3);
				break;
			/*
			 * default: System.err.println("Please Enter Correct Choice");
			 */
			}
		} while (ch < 3);
	}

	private static String readFileName(Scanner sc) {
		sc.nextLine();
		String fileName = sc.nextLine();
		return fileName;
	}
}

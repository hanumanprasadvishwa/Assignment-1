package com.lockedme;

import java.io.File;

public class LockedMeBO {
	public void displayFilesInAscendingOrder(String directoryPath) {
		try {
			File f = new File(directoryPath);
			File files[] = f.listFiles();
			Sort(files, files.length);
			for (File fileEntry : files) {
				if (fileEntry.isFile())
					System.out.println(fileEntry.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Sort(File[] files, int n) {
		int x, j, swaps;
		File temp;
		for (x = n - 2; x >= 0; x--) {
			swaps = 0;
			for (j = 0; j <= x; j++) {
				if (files[j].getName().compareTo(files[j + 1].getName()) > 0) {
					temp = files[j];
					files[j] = files[j + 1];
					files[j + 1] = temp;
					swaps++;
				}
			}
			if (swaps == 0)
				break;
		}
	}

	public void addFile(String fileName, String directoryPath) {
		try {
			File directory = new File(directoryPath);
			if (directory.isDirectory()) {
				File f = new File(directoryPath + "/" + fileName);
				if (!f.exists()) {
					f.createNewFile();
					System.out.println("File Added Successfully");
				}

				else {
					System.out.println("File Already Existed");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFile(String fileName, String directoryPath) {
		boolean isDeleted = false;
		boolean isExisted = false;
		try {
			File f = new File(directoryPath);
			File files[] = f.listFiles();
			for (File fileEntry : files) {
				if (fileEntry.getName().equals(fileName)) {
					isExisted = true;
					if (fileEntry.delete())
						isDeleted = true;
				}
			}
			if (isExisted && isDeleted)
				System.out.println("File Deleted Successfully");
			else
				System.out.println("File Is Not Existed To Delete");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchFile(String filename, String directorypath) {
		boolean isExisted = false;
		try {
			File f = new File(directorypath);
			File files[] = f.listFiles();
			for (File fileEntry : files) {
				if (fileEntry.isFile()) {
					if (fileEntry.getName().equals(filename))
						isExisted = true;
				}
			}
			if (isExisted)
				System.out.println("File Found");
			else
				System.out.println("File Is Not Existed In The Directory");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

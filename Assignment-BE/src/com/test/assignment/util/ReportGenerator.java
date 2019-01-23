package com.test.assignment.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {
	private static final String REPORT_TXT = "report_";

	private static final String NEW_LINE_SEPARATOR = "\n";

	private ReportGenerator() {
	}

	public static void generateReport(String header, List<String> records) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(REPORT_TXT + System.currentTimeMillis() + ".txt");
			fileWriter.append(header.trim());
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (String string : records) {
				fileWriter.append(string);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

		} catch (IOException e) {
			System.out.println("Error while flushing/closing fileWriter !!!");

		} finally {

			try {

				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");

			}

		}

	};

}

package com.test.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.test.assignment.model.TransactionRecord;
import com.test.assignment.parser.FileProcessorFactory;

/**
 * An application to find ".csv" or ".xml" file to read the transactions and
 * report any failed transactions
 *
 */
public class BankStatementReportApp {

	public static void main(String[] args) throws IOException {

		File folder = new File(".");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			validateTransactionsNdGenerateReport(file);
		}
	}

	/**
	 * Process each file data, validate and generate report
	 * 
	 * @param file
	 */
	private static void validateTransactionsNdGenerateReport(File file) {
		if (file.isFile()) {
			List<TransactionRecord> transRecords = new ArrayList<>();
			if (file.getName().endsWith(".csv") || file.getName().endsWith(".CSV")) {
				FileProcessorFactory.getFileProcessor("csv").process(file);
			} else if (file.getName().endsWith(".xml") || file.getName().endsWith(".XML")) {
				FileProcessorFactory.getFileProcessor("xml").process(file);
			}
		}
	}
}

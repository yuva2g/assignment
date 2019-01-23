package com.test.assignment.parser;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.test.assignment.util.ReportGenerator;

/**
 * CSV File Parser to parse csv content
 *
 */
public class CSVFileProcessor implements FileProcessor {

	private static final String COMMA = ",";
	private static final String FILE_HEADER = "Reference, Description";
	private static DecimalFormat doubleformat = new DecimalFormat("#0.00");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void process(File file) {
		try {
			Set<String> recordSet = new HashSet<>();
			List<String> errorRecords = new LinkedList<>();
			Scanner scanner = new Scanner(file);
			boolean skipHeader = false;
			while (scanner.hasNextLine()) {
				if (!skipHeader) {
					scanner.nextLine();
					skipHeader = true;
					continue;
				}
				String nextLine = scanner.nextLine();
				nextLine.trim();
				boolean isDuplicate = false;
				if (!nextLine.equals("")) {
					String[] split = nextLine.split(COMMA);
					String transactionRefId = split[0];
					String desc = split[2];
					if (!recordSet.contains(transactionRefId)) {
						recordSet.add(transactionRefId);

					} else {
						isDuplicate = true;
					}
					double startBal = Double.parseDouble(split[3]);
					double mutationVal = Double.parseDouble(split[4]);
					double expectedEndBal = Double.parseDouble(doubleformat.format(startBal + mutationVal));
					double actualEndBal = Double.parseDouble(split[5]);
					if (isDuplicate || actualEndBal != expectedEndBal) {
						errorRecords.add(transactionRefId + COMMA + desc);
					}
				}
			}
			scanner.close();
			ReportGenerator.generateReport(FILE_HEADER, errorRecords);
		} catch (IOException e) {
			System.out.println("Error while flushing/closing fileWriter !!!");
		}
	}
}
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


public class CSVFileParser implements FileParser {

	private static final String COMMA = ",";
	private static final String FILE_HEADER = "Reference, Description";
	private static DecimalFormat doubleformat = new DecimalFormat("#0.00");

	@Override
	public void parse(File file) {
		try {
			Set<String> refSet = new HashSet<>();
			List<String> errorRecords=new LinkedList<>();
			Scanner scanner;
			scanner = new Scanner(file);
			boolean skipHeader = false;
			while (scanner.hasNextLine()) {
				if (!skipHeader) {
					scanner.nextLine();
					skipHeader = true;
					continue;
				}
				String nextLine = scanner.nextLine();
				nextLine.trim();
				boolean isDuplicate=false;
				if (!nextLine.equals("")) {
					String[] split = nextLine.split(COMMA);
					String recref = split[0];
					if(!refSet.contains(recref)) {
						refSet.add(recref);
						
					}
					else {
						isDuplicate=true;
					}
					// String acctNo = split[1];
					String desc = split[2];
					double startBal = Double.parseDouble(split[3]);
					double mutationVal = Double.parseDouble(split[4]);
					double expectedEndBal = Double.parseDouble(doubleformat.format(startBal + mutationVal));
					double actualEndBal = Double.parseDouble(split[5]);
					if (isDuplicate || actualEndBal != expectedEndBal) {
						errorRecords.add(recref+COMMA+desc);
						
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

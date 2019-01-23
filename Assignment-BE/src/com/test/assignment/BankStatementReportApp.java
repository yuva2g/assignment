package com.test.assignment;

import java.io.File;
import java.io.IOException;

import com.test.assignment.parser.FileParserFactory;

public class BankStatementReportApp {

	public static void main(String[] args) throws IOException {
		File folder = new File(".");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	if(file.getName().endsWith(".csv") ||file.getName().endsWith(".CSV")  ) {
		    		FileParserFactory.getFileParser("csv").parse(file);
		    	}
		    	else if(file.getName().endsWith(".xml") ||file.getName().endsWith(".XML")  ) {
		    		FileParserFactory.getFileParser("xml").parse(file);
		    	}
		    }
		}
	}
}

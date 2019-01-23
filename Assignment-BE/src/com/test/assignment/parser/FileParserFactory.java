package com.test.assignment.parser;

public class FileParserFactory {

	private static FileParser csvParser = new CSVFileParser();
	private static FileParser xmlParser = new XMLFileParser();

	private FileParserFactory() {
	}

	public static FileParser getFileParser(String str) {
		str=str.toUpperCase();
		switch (str) {
		case "CSV":
			return csvParser;
		case "XML":
			return xmlParser;
		default:
			return csvParser;
		}
	}
}

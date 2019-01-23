package com.test.assignment.parser;

/**
 * A factory which identifies the File processor based on file type
 * 
 */
public class FileProcessorFactory {

	private static FileProcessor csvProcessor = new CSVFileProcessor();
	private static FileProcessor xmlProcessor = new XMLFileProcessor();

	/**
	 * A private constructor
	 */
	private FileProcessorFactory() {
	}

	public static FileProcessor getFileProcessor(String str) {
		str = str.toUpperCase();
		switch (str) {
		case "CSV":
			return csvProcessor;
		case "XML":
			return xmlProcessor;
		default:
			return csvProcessor;
		}
	}
}

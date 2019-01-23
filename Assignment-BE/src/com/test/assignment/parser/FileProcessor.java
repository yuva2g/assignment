package com.test.assignment.parser;

import java.io.File;

/**
 * A Processor interface while will process files based on type
 * 
 */
public interface FileProcessor {

	/**
	 * Method which process the file based on type
	 * 
	 * @param file
	 */
	public void process(File file);
}
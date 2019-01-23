package com.test.assignment.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * CSV File Parser to parse csv content
 *
 */
public class XMLFileProcessor implements FileProcessor {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void process(File file) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("records");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					for (int i = 0; i < eElement.getChildNodes().getLength(); i++) {
						Node childNode = nList.item(temp);

						System.out.println("\nCurrent Element :" + childNode.getNodeName());

						if (childNode.getNodeType() == Node.ELEMENT_NODE) {

							Element childRecord = (Element) childNode;

							System.out.println("Staff id : "
									+ childRecord.getElementsByTagName("accountNumber").item(i).getTextContent());
							System.out.println("First Name : "
									+ childRecord.getElementsByTagName("description").item(i).getTextContent());
							System.out.println("Last Name : "
									+ childRecord.getElementsByTagName("startBalance").item(i).getTextContent());
							System.out.println("Nick Name : "
									+ childRecord.getElementsByTagName("mutation").item(i).getTextContent());
							System.out.println("Salary : "
									+ childRecord.getElementsByTagName("endBalance").item(i).getTextContent());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package gagan.practice;

import gagan.practice.jaxb.JaxbUtil;
import gagan.practice.jaxb.beans.generated.CustomerOrder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

/**
 * @author Gagan
 *
 */
public class HelloWorld {
	
	public static void main(String arg[]){
		
		// Get Object from XML		
		CustomerOrder customerOrder = getCustomerOrderObject();		
		System.out.println("CustomerOrder Object : " + customerOrder.getOrderNumber());
		
		// Get XML from Object	
		String customerOrderXML = getCustomerOrderXML(customerOrder);
		System.out.println("CustomerOrder XML : " + customerOrderXML);
	}

	private static CustomerOrder getCustomerOrderObject() {
		
		CustomerOrder customerOrder = null;
		String inputXML = "";
		String contextPath = "gagan.practice.jaxb.beans.generated";
		String fileLocation = "C:\\Users\\Gagan\\Workspace\\JavaPractice\\JAXBPractice\\XML\\CustomerOrder.xml";
		File file = new File(fileLocation);
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try {
	            byte[] buff = new byte[1024];
	            int bytesRead;
	            
	            while (-1 != (bytesRead = fileInputStream.read(buff, 0, buff.length))){
					inputXML += new String(buff, 0, bytesRead);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				customerOrder = (CustomerOrder)JaxbUtil.getObjectFromXML(inputXML, contextPath);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return customerOrder;
	}

	private static String getCustomerOrderXML(CustomerOrder customerOrder) {
		
		String outputXML = null;
		String contextPath = "gagan.practice.jaxb.beans.generated";

		try {
			outputXML = JaxbUtil.getXMLFromObject(customerOrder, contextPath);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return outputXML;
	}
}

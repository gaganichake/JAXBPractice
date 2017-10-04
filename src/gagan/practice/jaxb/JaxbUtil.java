package gagan.practice.jaxb;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Gagan
 *
 */
public class JaxbUtil {

	public static Object getObjectFromXML(String inputXML, String contextPath) throws JAXBException {
		
		Object object = null;
		if (inputXML != null) {
			try {
				JAXBContext context = JAXBContext
						.newInstance(contextPath);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				ByteArrayInputStream byteArrIS = new ByteArrayInputStream(
						inputXML.getBytes());
				object = unmarshaller.unmarshal(byteArrIS);
			} catch (JAXBException jaxbException) {
				throw jaxbException;
			}
		}
		return object;
	}

	public static String getXMLFromObject(Object object, String contextPath) throws JAXBException {
		
		StringBuffer outputXML = new StringBuffer();
		outputXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		try {
			JAXBContext context = JAXBContext
					.newInstance(contextPath);
			StringWriter stringWriter = new StringWriter();
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			marshaller.marshal(object, stringWriter);
			outputXML.append(stringWriter.toString());
		} catch (JAXBException jaxbException) {
			throw jaxbException;
		}
		return outputXML.toString();
	}
}

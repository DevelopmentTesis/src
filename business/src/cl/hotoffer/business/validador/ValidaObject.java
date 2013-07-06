package cl.hotoffer.business.validador;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidaObject {

	public ValidaObject() {
		// TODO Auto-generated constructor stub
	}

	public static void validate(Object object) throws JAXBException,
			SAXException, IOException {

		JAXBContext jc = JAXBContext.newInstance(object.getClass());
		JAXBSource source = new JAXBSource(jc, object);

		SchemaFactory sf = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("hotoffer.xsd"));

		Validator validator = schema.newValidator();

		validator.validate(source);

	}

}

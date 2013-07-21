package cl.hotoffer.business.validador;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;

import cl.hotoffer.exception.BusinessException;

public class ValidaObject {

	private static final Logger LOGGER = Logger.getLogger(ValidaObject.class);

	public void validate(Object object) throws BusinessException {

		JAXBContext jc;
		try {
			LOGGER.info("VALIDAR OBJETO : " + object.getClass().getName());
			jc = JAXBContext.newInstance(object.getClass());

			JAXBSource source = new JAXBSource(jc, object);

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			LOGGER.info("ABRIR ARCHIVO : hotoffer.xsd");
			Schema schema = sf.newSchema(new File("hotoffer.xsd"));

			Validator validator = schema.newValidator();

			validator.validate(source);
		} catch (Exception e) {
			LOGGER.error("ERROR VALIDACION OBJECTO BUSINESS " + e);
			throw new BusinessException(e);
		}

	}

	public ValidaObject() {

	}
}

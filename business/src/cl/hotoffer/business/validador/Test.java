package cl.hotoffer.business.validador;

import cl.hotoffer.exception.BusinessException;

import com.android.model.TipoPublicacion;

public class Test {

	/**
	 * @param args
	 * @throws BusinessException
	 */
	public static void main(String[] args) throws BusinessException {

		TipoPublicacion tipoPublicacion = new TipoPublicacion();

		tipoPublicacion.setIdPublicacion(1);
		tipoPublicacion.setDescripcion("asdasd");

		new ValidaObject().validate(tipoPublicacion);

	}

}

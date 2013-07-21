package cl.hotoffer.business.validador;

import cl.hotoffer.exception.BusinessException;

import com.android.model.Usuario;

public class Test {

	/**
	 * @param args
	 * @throws BusinessException
	 */
	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(null);
		usuario.setNombre("asd");
		usuario.setPassword("adsd");

		try {
			new ValidaObject().validate(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

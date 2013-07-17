package test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cl.hotoffer.exception.ValidaAccesoException;

import com.android.database.dao.UsuarioDAO;
import com.android.database.dao.ValidaAcceso;
import com.android.model.Usuario;

public class TestCase {

	private static UsuarioDAO usuarioDAO;

	@BeforeClass
	public static void befor() {
		usuarioDAO = new UsuarioDAO();
	}

	@AfterClass
	public static void runAfterClass() {
		usuarioDAO = null;
	}

	@Test
	public void select() {

		List<Usuario> list = usuarioDAO.selectAll();

		assertNotNull("LISTA", list);

	}

	@Test
	public void validaUsuario() {

		ValidaAcceso dao = new UsuarioDAO();

		Usuario usuario = new Usuario();
		usuario.setNombre("kerne");
		usuario.setPassword("kerne");

		try {
			Assert.assertTrue(dao.validaAcceso(usuario));
		} catch (ValidaAccesoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void selectKey() {
		UsuarioDAO dao = new UsuarioDAO();
		assertNotNull(dao.selectById(2));

	}

}

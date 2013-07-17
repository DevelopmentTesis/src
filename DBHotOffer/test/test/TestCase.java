package test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.android.database.dao.UsuarioDAO;
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

		UsuarioDAO dao = new UsuarioDAO();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nombre", "kerne");
		map.put("password", "kerne");

		Assert.assertTrue(dao.isUsuario(map));

	}

	@Test
	public void selectKey() {
		UsuarioDAO dao = new UsuarioDAO();
		assertNotNull(dao.selectById(2));

	}

}

package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import cl.hotoffer.exception.BusinessException;
import cl.hotoffer.exception.UsuarioException;

import com.android.database.dao.PublicacionDAO;
import com.android.database.dao.UsuarioDAO;
import com.android.database.dao.impl.PublicacionDaoImpl;
import com.android.database.dao.impl.UsuarioDaoImpl;
import com.android.model.Geolocalizacion;
import com.android.model.Persona;
import com.android.model.Publicacion;
import com.android.model.Usuario;

public class TestCase {

	@Test
	public void validaUsuario() {

		UsuarioDAO dao = new UsuarioDaoImpl();

		Usuario usuario = new Usuario();
		usuario.setNombre("kerne");
		usuario.setPassword("kerne");

		try {
			Assert.assertTrue(dao.validaAcceso(usuario));

		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void selectAll() throws UsuarioException {

		UsuarioDAO dao = new UsuarioDaoImpl();

		for (Usuario u : dao.selectAll()) {
			System.out.println(u.getNombre());
		}
	}

	@Test
	public void insert() {

		UsuarioDAO dao = new UsuarioDaoImpl();
		try {
			Persona persona = new Persona();
			persona.setNombre("test2");
			persona.setApellido("test1");
			persona.setFechaNacimiento("19880602");
			persona.setPais(1);
			persona.setCiudad(1);
			persona.setSexo("M");
			persona.setTipoUsuario(1);

			Usuario usuario = new Usuario();
			usuario.setNombre("prueba");
			usuario.setPassword("prueba");
			persona.setUsuario(usuario);

			dao.insert(persona);

		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void selectKey() throws UsuarioException {
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		assertNotNull(dao.selectById(2));

	}

	@Test
	public void getPublicaciones() throws BusinessException {

		PublicacionDAO dao = new PublicacionDaoImpl();

		for (Publicacion p : dao.getPublicacion()) {
			System.out.println(p.getUsuario().getNombre());
		}

	}

	@Test
	public void guardarPublicacion() throws BusinessException {

		PublicacionDAO dao = new PublicacionDaoImpl();
		Publicacion pub = new Publicacion();
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);
		pub.setUsuario(usuario);
		pub.setIdTipoPublicacion(1);

		Geolocalizacion geo = new Geolocalizacion();
		geo.setCordLatitud(123123);
		geo.setCordLonguitud(23123123);
		pub.setGeolocalizacion(geo);

		pub.setComentario("PRUEBA PUBLICACION");
		pub.setPrecio("12312");
		pub.setTienda("TIENDA");

		dao.guardarPublicacion(pub);

	}

}

package test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cl.hotoffer.business.validador.ValidaObject;
import cl.hotoffer.exception.BusinessException;
import cl.hotoffer.exception.PublicacionException;
import cl.hotoffer.exception.UsuarioException;

import com.android.database.dao.PublicacionDAO;
import com.android.database.dao.UsuarioDAO;
import com.android.database.dao.impl.PublicacionDaoImpl;
import com.android.database.dao.impl.UsuarioDaoImpl;
import com.android.model.Comentario;
import com.android.model.Geolocalizacion;
import com.android.model.Persona;
import com.android.model.Publicacion;
import com.android.model.TipoPublicacion;
import com.android.model.Usuario;

public class TestCase {

	@Test
	public void validaUsuario() throws BusinessException, UsuarioException {

		UsuarioDAO dao = new UsuarioDaoImpl();

		Usuario usuario = new Usuario();
		// usuario.setIdUsuario();
		usuario.setNombre("kerne");
		usuario.setPassword("kerne");

		new ValidaObject().validate(usuario);

		Assert.assertTrue(dao.validaAcceso(usuario));

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
			persona.setNombre("cesar");
			persona.setApellido("araya");
			persona.setFechaNacimiento("19880602");
			persona.setPais(1);
			persona.setCiudad(1);
			persona.setSexo("M");
			persona.setTipoUsuario(1);

			Usuario usuario = new Usuario();
			usuario.setNombre("kerne");
			usuario.setPassword("kerne");
			persona.setUsuario(usuario);

			System.out.println(dao.insert(persona));

		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void selectKey() throws UsuarioException {
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		List<Usuario> usuario = dao.selectByName("s");

		for (Usuario usuario2 : usuario) {
			System.out.println(usuario2.getNombre());
		}

	}

	@Test
	public void getPublicaciones() throws PublicacionException {

		PublicacionDAO dao = new PublicacionDaoImpl();

		List<Publicacion> list = dao.getPublicacion();

		for (Publicacion p : list) {
			System.out.println(p.getFechaPublicacion());
		}
		assertNotNull(dao.getPublicacion());

	}

	@Test
	public void getTipoPublicaciones() throws PublicacionException {

		PublicacionDAO dao = new PublicacionDaoImpl();

		for (TipoPublicacion t : dao.tiposPublicaciones()) {
			System.out.println(t.getDescripcion());
		}

	}

	@Test
	public void guardarPublicacion() throws PublicacionException {

		PublicacionDAO dao = new PublicacionDaoImpl();

		Publicacion pub = new Publicacion();
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(new Integer(1));
		pub.setUsuario(usuario);
		pub.setIdTipoPublicacion(2);

		Geolocalizacion geo = new Geolocalizacion();
		geo.setCordLatitud("-33.4360476");
		geo.setCordLonguitud("-70.6780484");
		pub.setGeolocalizacion(geo);

		pub.setComentario("YA ESTAMOS CASI LISTO CON LA APLICACION HOTOFFER OJALA SEA DE SU AGRADO, PARA PODER TITULARME DE INGENIERIA EN INFORMATICA");
		pub.setPrecio("12000");
		pub.setTienda("PELARCO");

		dao.guardarPublicacion(pub);

	}

	@Test
	public void buscarPublicaciones() {

		PublicacionDAO dao = new PublicacionDaoImpl();

		try {
			assertNotNull(dao.buscarPublicaciones(2));
		} catch (PublicacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void buscarComentarios() throws PublicacionException {

		PublicacionDAO dao = new PublicacionDaoImpl();
		assertNotNull(dao.comentariosPublicacion(1));

		for (Comentario it : dao.comentariosPublicacion(1)) {
			System.out.println(it.getUsuario());
		}

	}

}

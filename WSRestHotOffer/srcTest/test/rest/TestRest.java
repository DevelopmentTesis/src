package test.rest;

import org.jboss.resteasy.client.ProxyFactory;
import org.junit.Assert;
import org.junit.Test;

import cl.hotoffer.exception.ValidaAccesoException;

import com.android.rest.acceso.RestValidaAcceso;

public class TestRest {

	private RestValidaAcceso acceso;

	@Test
	public void validaUsuario() throws ValidaAccesoException {
		acceso = ProxyFactory
				.create(RestValidaAcceso.class,
						"http://localhost:8080/WSRestHotOffer?nombre=kerne&password=kerne");

		Assert.assertTrue(acceso.validaAcceso("kerne", "kerne"));

	}

}

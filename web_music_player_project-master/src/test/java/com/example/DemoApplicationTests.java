package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.dominio.Cancion;
import com.example.repositorio.CancionRepositorio;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	CancionRepositorio cancionRepositorio;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCanciones() {
		
		Cancion cancion = new Cancion("El relajo", "Sala", "...", null, null);
		Assert.assertNull(cancion.getId());
		Cancion c1 = cancionRepositorio.save(cancion);
		System.out.println("ID = " + c1.getId());
		Assert.assertNotNull(c1.getId());

		c1.setGenero("Salsa");
		Cancion c2 = cancionRepositorio.save(c1);
		Cancion c3 = cancionRepositorio.buscarPorId(c1.getId());

		Assert.assertEquals(c2.getNombre(), c3.getNombre());
	}
}

package restjpa.launcher.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import restjpa.launcher.model.IClienteDAO;
import restjpa.launcher.model.entities.ClienteVO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BuscarClienteTests {

	@Autowired
	TestEntityManager manager;
	@Autowired
	IClienteDAO dao;

	@Before
	public void setUp() throws Exception {
		ClienteVO cliente = new ClienteVO("1-7", "Rock", "Strongo", "a@a.com", "81234");
		this.manager.persist(cliente);
		cliente = new ClienteVO("1-8", "Cosme", "Fulanito", "b@b.com", "99234");
		this.manager.persist(cliente);
		cliente = new ClienteVO("1-9", "Lalo", "Landa", "c@c.com", "981234");
		this.manager.persist(cliente);
	}

	/*
	 * Acà solamente se busca un cliente y  devuelve boolean si lo encontrò (true)
	 * ya que no se especifica si hay que obtenerlo o no
	 */
	@Test
	public void cuandoBuscarClienteEntoncesTrue(){
		boolean cliente = this.dao.existsById("1-7");
		assertTrue(cliente);
	}

}

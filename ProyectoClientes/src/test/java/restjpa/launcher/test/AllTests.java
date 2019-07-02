package restjpa.launcher.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgregarClientesTests.class, BuscarClienteTests.class, EliminarClienteTests.class,
		ListarClientesTests.class, ModificarClienteTests.class })
public class AllTests {

}

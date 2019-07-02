package restjpa.launcher.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import restjpa.launcher.model.IClienteDAO;
import restjpa.launcher.model.entities.ClienteVO;

@RestController
public class RESTcontrolador {

	@Autowired
	IClienteDAO daoCliente;
	
	@GetMapping("/clientes")
	public List<ClienteVO> getClientes(){
		return this.daoCliente.findAll();
	}
	
	@GetMapping("/clientes/buscar/{nombre}")
	public Optional<ClienteVO> getNombre(@PathVariable(value="nombre") String nombre) {
		return this.daoCliente.findByNombre(nombre);
	}
	
	@GetMapping("/clientes/{rut}")
	public ClienteVO getRut(@PathVariable(value="rut") String rut) {
		return daoCliente.findById(rut).orElse(new ClienteVO());
	}
	
	@PostMapping("/clientes")
	public boolean addCliente(@RequestBody ClienteVO body) {
		if(!this.daoCliente.existsById(body.getRut())) {
			this.daoCliente.save(body);
			return true;
		}
		return false;
	}
	
	@PutMapping("/clientes")
	public boolean modifyCliente(@RequestBody ClienteVO body) {
		if (this.daoCliente.existsById(body.getRut())) {
			this.daoCliente.save(body);
			return true;
		}
		return false;
	}
	
	@DeleteMapping("/clientes/{rut}")
	public boolean deleteCliente(@PathVariable String rut) {
		if (rut.equalsIgnoreCase("99999999-9")) {
			this.daoCliente.deleteAll();
			return true;
		}
		else if(this.daoCliente.existsById(rut)) {
			this.daoCliente.deleteById(rut);
			return !this.daoCliente.existsById(rut);
		}
		return false;
	}
	
}

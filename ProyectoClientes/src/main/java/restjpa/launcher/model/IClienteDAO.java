package restjpa.launcher.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restjpa.launcher.model.entities.ClienteVO;

@Repository
public interface IClienteDAO extends JpaRepository<ClienteVO, String> {
	public Optional<ClienteVO> findByNombre(String nombre);
}

package Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.*;

@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long>{
	Contato findById(long id);
}

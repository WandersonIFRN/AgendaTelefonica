package Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.*;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}

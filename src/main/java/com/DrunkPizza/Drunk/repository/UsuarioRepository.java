package com.DrunkPizza.Drunk.repository;

import com.DrunkPizza.Drunk.entity.Usuario;
import com.DrunkPizza.Drunk.entity.Clientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);

}

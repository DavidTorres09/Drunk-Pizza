
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.Rol;
import com.DrunkPizza.Drunk.entity.Usuario;
import com.DrunkPizza.Drunk.repository.UsuarioRepository;
import java.util.ArrayList;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UsuarioService  implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar un usuario por el username
        Usuario usuario = usuarioRepository.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        //Si se encontro el usuario
        
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Rol rol:usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se retorna el usuario con detalles
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
    
    
    
}

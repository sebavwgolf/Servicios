
package com.ayudaencasa.app.services.impl;

import com.ayudaencasa.app.entities.User;
import com.ayudaencasa.app.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserIndexService implements UserDetailsService{

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         
    
         Optional<User> opt = userRepo.findByEmail(email);
         
         if(!opt.isPresent()){
             throw new UsernameNotFoundException("Email not found");
         }
         
         User usuario = opt.get();
        
        if(usuario != null){
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            GrantedAuthority p1 = new SimpleGrantedAuthority("MODULO_FOTO");
            permisos.add(p1);
            GrantedAuthority p2 = new SimpleGrantedAuthority("MODULO_LIBRO");
            permisos.add(p2);
            GrantedAuthority p3 = new SimpleGrantedAuthority("MODULO_AUTOR");
            permisos.add(p3);
            
            
            org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), permisos);
            return user;
        }else{
            return null;
        }
    }
        
    
    
}

package pe.edu.cibertec.Fastrack_DSWll_Grupo7.Service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Rol;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Model.bd.Usuario;
import pe.edu.cibertec.Fastrack_DSWll_Grupo7.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomusuario(username);
        return autenticacionUsuario(usuario,
                obtenerListaRolesUsuario(usuario.getRoles()));
    }
    public Usuario findByNomusuario(String usuario){
        return usuarioRepository.findByNomusuario(usuario);
    }
    public List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol> listaRoles){
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Rol rol : listaRoles){
            roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        return new ArrayList<>(roles);
    }
    private UserDetails autenticacionUsuario(Usuario usuario,
                                             List<GrantedAuthority> authorityList){
        return new User(usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true, authorityList);
    }

}
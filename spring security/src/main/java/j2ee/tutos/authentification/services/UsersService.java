package j2ee.tutos.authentification.services;

import j2ee.tutos.authentification.repositories.User;
import j2ee.tutos.authentification.repositories.UsersRepository;
import j2ee.tutos.authentification.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws AuthenticationException {
        User user = usersRepository.findUserByName(name);
        return new UserPrincipal(user);
    }

}

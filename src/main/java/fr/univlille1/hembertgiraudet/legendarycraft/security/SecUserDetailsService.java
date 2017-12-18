package fr.univlille1.hembertgiraudet.legendarycraft.security;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Account;
import fr.univlille1.hembertgiraudet.legendarycraft.model.SecUserDetails;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }else{
            UserDetails details = new SecUserDetails(user);
            return details;
        }
    }
}

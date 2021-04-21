package com.isamrs.backend.service.impl;

import com.isamrs.backend.model.Authority;
import com.isamrs.backend.model.User;
import com.isamrs.backend.repository.AuthorityRepository;
import com.isamrs.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User u = userRepository.findUserByEmail(username);

        Authority authority=authorityRepository.findByUser(u);

        if (u == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", username));

        } else {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(grantedAuthority);

            return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(),
                    authorities);
        }

    }
}

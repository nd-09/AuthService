package com.user.authservice.service;

import com.user.authservice.models.User;
import com.user.authservice.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println("USER name from UserDetailServiceIMPL"+user.get().getUsername());
        System.out.println("USER role from UserDetailServiceIMPL"+user.get().getRole());
        System.out.println("USER token from UserDetailServiceIMPL"+user.get().getToken());
        System.out.println("USER password from UserDetailServiceIMPL"+user.get().getPassword());


        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.get().getUsername())
                .password(user.get().getPassword())
                .authorities(new SimpleGrantedAuthority(user.get().getRole()))
                .build();
    }
}

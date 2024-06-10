package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    private List<User> users;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        users = new ArrayList<>();
        users.add(new User(1,"tien","tien@gmail.com", passwordEncoder.encode("123"), true, List.of("USER", "ADMIN")));
        users.add(new User(2,"tien1","tien1@gmail.com", passwordEncoder.encode("123"), true, List.of("USER")));
        users.add(new User(3,"tien2","tien2@gmail.com", passwordEncoder.encode("123"), false, List.of("USER")));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }
}

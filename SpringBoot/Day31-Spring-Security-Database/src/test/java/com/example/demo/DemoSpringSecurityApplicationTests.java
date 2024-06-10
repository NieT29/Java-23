package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class DemoSpringSecurityApplicationTests {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void save_roles() {
        Role roleUser = Role.builder().name("USER").build();
        Role roleAdmin = Role.builder().name("ADMIN").build();

        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
    }

    @Test
    void save_users() {
        Role roleUser = roleRepository.findByName("USER").orElse(null);
        Role roleAdmin = roleRepository.findByName("ADMIN").orElse(null);

        User user1 = User.builder()
                .name("Tien")
                .email("tien@gmail.com")
                .password(passwordEncoder.encode("123"))
                .enabled(true)
                .roles(List.of(roleUser, roleAdmin))
                .build();

        User user2 = User.builder()
                .name("Tien1")
                .email("tien1@gmail.com")
                .password(passwordEncoder.encode("123"))
                .enabled(true)
                .roles(List.of(roleUser))
                .build();

        User user3 = User.builder()
                .name("Tien2")
                .email("tien2@gmail.com")
                .password(passwordEncoder.encode("123"))
                .enabled(false)
                .roles(List.of(roleUser))
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}

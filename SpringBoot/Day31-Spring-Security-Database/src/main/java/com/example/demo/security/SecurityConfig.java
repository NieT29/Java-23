package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final CustomFilter customFilter;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        String[] paths = {"/dashboard", "/admin/category","/admin/product","/admin/brand", "/admin/order"};

        // cấu hình path
        http.authorizeHttpRequests(auth -> {
            auth.anyRequest().permitAll();
//            auth.requestMatchers("/").permitAll();
//            auth.requestMatchers("/user").hasRole("USER");
//            auth.requestMatchers("/admin").hasRole("ADMIN");
//
//            // Xem dashboard + quản lí{category, product, brand, order} - role: ADMIN, SLAE
//            auth.requestMatchers(paths).hasAnyRole("ADMIN", "SALE");
//
//            auth.requestMatchers("/admin/user").hasRole("ADMIN");
//            auth.requestMatchers("/admin/blog").hasAnyRole("ADMIN","SALE", "AUTHOR");
//            auth.requestMatchers("/profile").hasRole("USER");

//            auth.requestMatchers("/author").hasAnyRole("ADMIN", "USER");
//            auth.requestMatchers("/css/**", "/js/**", "/image/**");
//            auth.requestMatchers(paths).permitAll();
//            auth.requestMatchers("/author").hasAnyRole("ADMIN", "USER");
//            auth.requestMatchers(HttpMethod.GET, "/aa/**", "/bb/**").hasRole("ADMIN");
//            auth.requestMatchers("/abc", "/bcd").hasAuthority("ROLE_USER");
//            auth.requestMatchers("/abc", "/bcd").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");

//            auth.anyRequest().authenticated(); // tất cả các request khác đều cần xác thực
        });

        // cấu hình login
//        http.formLogin(formLogin -> {
//            formLogin.loginPage("/login");
//            formLogin.defaultSuccessUrl("/", true); // nếu login thành công thì chuyển hướng về trang chủ
//            formLogin.permitAll(); // tất cả đều được truy cập vào trang cá nhân
//        });

        // cấu hình logout
        http.logout(logout -> {
            logout.logoutSuccessUrl("/"); // nếu logout thành công thì chuyển hướng về trang chủ
            logout.deleteCookies("JSESSIONID"); // xóa cookie
            logout.invalidateHttpSession(true); // hủy session
            logout.clearAuthentication(true); // xóa thông tin xác thực
            logout.permitAll(); // tất cả đều được truy cập vào trang logout
        });

        // cấu hình xác thực
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

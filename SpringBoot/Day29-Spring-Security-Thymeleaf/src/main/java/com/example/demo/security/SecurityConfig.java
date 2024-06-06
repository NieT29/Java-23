package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] paths = {"/dashboard", "/admin/category","/admin/product","/admin/brand", "/admin/order"};

        // cấu hình path
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/user").hasRole("USER");
            auth.requestMatchers("/admin").hasRole("ADMIN");

            // Xem dashboard + quản lí{category, product, brand, order} - role: ADMIN, SLAE
            auth.requestMatchers(paths).hasAnyRole("ADMIN", "SALE");

            auth.requestMatchers("/admin/user").hasRole("ADMIN");
            auth.requestMatchers("/admin/blog").hasAnyRole("ADMIN","SALE", "AUTHOR");
            auth.requestMatchers("/profile").hasRole("USER");

//            auth.requestMatchers("/author").hasAnyRole("ADMIN", "USER");
//            auth.requestMatchers("/css/**", "/js/**", "/image/**");
//            auth.requestMatchers(paths).permitAll();
//            auth.requestMatchers("/author").hasAnyRole("ADMIN", "USER");
//            auth.requestMatchers(HttpMethod.GET, "/aa/**", "/bb/**").hasRole("ADMIN");
//            auth.requestMatchers("/abc", "/bcd").hasAuthority("ROLE_USER");
//            auth.requestMatchers("/abc", "/bcd").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");

            auth.anyRequest().authenticated(); // tất cả các request khác đều cần xác thực
        });

        // cấu hình login
        http.formLogin(formLogin -> {
            formLogin.loginPage("/login");
            formLogin.defaultSuccessUrl("/", true); // nếu login thành công thì chuyển hướng về trang chủ
            formLogin.permitAll(); // tất cả đều được truy cập vào trang cá nhân
        });

        // cấu hình logout
        http.logout(logout -> {
            logout.logoutSuccessUrl("/"); // nếu logout thành công thì chuyển hướng về trang chủ
            logout.deleteCookies("JSESSIONID"); // xóa cookie
            logout.invalidateHttpSession(true); // hủy session
            logout.clearAuthentication(true); // xóa thông tin xác thực
            logout.permitAll(); // tất cả đều được truy cập vào trang logout
        });

        return http.build();
    }
}

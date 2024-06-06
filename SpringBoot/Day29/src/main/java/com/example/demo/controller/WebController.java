package com.example.demo.controller;

import com.example.demo.security.IAuthenticationFacade;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebController {
    @Autowired
    private IAuthenticationFacade iAuthenticationFacade;

    // ai cũng có thể truy cập
    @GetMapping("/")
    public  String getHome() {
        return "Home Page";
    }

    // có role user mới có thể truy cập được
    @GetMapping("/user")
    public  String getUser() {
        return "User Page";
    }

    // có role admin mới có thể truy cập được
    @GetMapping("/admin")
    public  String getAdmin() {
        return "Admin Page";
    }

    @GetMapping("/infor1")
    public ResponseEntity<?> getInfor1() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("/infor2")
    public ResponseEntity<?> getInfor2(Principal principal) {
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/infor3")
    public ResponseEntity<?> getInfor3(Authentication authentication) {
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("/infor4")
    public ResponseEntity<?> getInfor4(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/infor5")
    public ResponseEntity<?> getInfor5() {
        Authentication authentication = iAuthenticationFacade.getAuthentication();
        return ResponseEntity.ok(authentication);
    }
}

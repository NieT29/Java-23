package com.example.demo.controller;

import com.example.demo.security.IsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    // ai cũng có thể truy cập
    @GetMapping("/")
    public  String getHome() {
        return "index";
    }

    // có role user mới có thể truy cập được
//    @Secured("ROLE_USER")
    @IsUser
    @GetMapping("/user")
    public  String getUser() {
        return "user";
    }

    // có role admin mới có thể truy cập được
//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public  String getAdmin() {
        return "admin";
    }

    // login
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    // Xem dashboard - ADMIN, SALE
    @GetMapping("/admin/dashboard")
    public String getDashboard() {
        return "dashboard";
    }

    //Quản lý user (CRU) - ADMIN
    @GetMapping("/admin/user")
    public String getUsers() {
        return "admin/users";
    }

    //Quản lý category (CRUD) ADMIN, SALE
    @GetMapping("/admin/category")
    public String getCategory() {
        return "admin/category";
    }

    //Quản lý sản phẩm (CRUD) ADMIN, SALE
    @GetMapping("/admin/product")
    public String getProduct() {
        return "admin/product";
    }

    //Quản lý brand (CRUD) ADMIN, SALE
    @GetMapping("/admin/brand")
    public String getBrand() {
        return "admin/brand";
    }

    //Quản lý order (CRU) ADMIN, SALE
    @GetMapping("/admin/order")
    public String getOrder() {
        return "admin/order";
    }

    // Quản lý bài viết (CRUD) ADMIN, SALE, AUTHOR
    @GetMapping("/admin/blog")
    public String getBlog() {
        return "admin/blog";
    }

    //Xem thông tin cá nhân, thay đổi thông tin cá nhân USER
    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }

//    @GetMapping("/infor1")
//    public ResponseEntity<?> getInfor1() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return ResponseEntity.ok(authentication);
//    }
//
//    @GetMapping("/infor2")
//    public ResponseEntity<?> getInfor2(Principal principal) {
//        return ResponseEntity.ok(principal);
//    }
//
//    @GetMapping("/infor3")
//    public ResponseEntity<?> getInfor3(Authentication authentication) {
//        return ResponseEntity.ok(authentication);
//    }
//
//    @GetMapping("/infor4")
//    public ResponseEntity<?> getInfor4(HttpServletRequest request) {
//        Principal principal = request.getUserPrincipal();
//        return ResponseEntity.ok(principal);
//    }
//
//    @GetMapping("/infor5")
//    public ResponseEntity<?> getInfor5() {
//        Authentication authentication = iAuthenticationFacade.getAuthentication();
//        return ResponseEntity.ok(authentication);
//    }
}

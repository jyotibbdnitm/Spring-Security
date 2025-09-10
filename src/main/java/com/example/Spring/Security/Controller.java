package com.example.Spring.Security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/Security")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String SecurityImp(){
        return "You have to Secure this Data";
    }

    @GetMapping("/SecureDone")
    public String SecureDone(){
        return "Your Data is Secured Now";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Hello Admin!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user() {
        return "Hello User!";
    }


    @GetMapping("/open")
    public String open() {
        return "This is an open endpoint.";
    }

}

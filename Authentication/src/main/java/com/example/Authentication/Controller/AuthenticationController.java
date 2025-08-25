package com.example.Authentication.Controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class AuthenticationController {

        @GetMapping("/public")
        public String publicEndpoint() {
            return "This is a PUBLIC endpoint. No authentication required!";
        }

        @GetMapping("/secure")
        public String secureEndpoint() {
            return "This is a SECURE endpoint. You must authenticate!";
        }
    }



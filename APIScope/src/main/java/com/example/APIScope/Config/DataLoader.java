package com.example.APIScope.Config;


import com.example.APIScope.Model.User;
import com.example.APIScope.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);

            User user = new User();
            user.setUsername("pallavi");
            user.setPassword(passwordEncoder.encode("1234"));
            user.setRole(User.Role.USER);
            userRepository.save(user);

            System.out.println("✅ Default admin and user created successfully!");
        }
    }
}

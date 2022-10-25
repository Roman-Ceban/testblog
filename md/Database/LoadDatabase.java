package com.testblog.md.Database;

import com.testblog.md.Models.User;
import com.testblog.md.Models.UserStatus;
import com.testblog.md.Repository.StatusRepository;
import com.testblog.md.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("user1", "User1 last", "user1 first", "user1@email.com", "Active")));
            log.info("Preloading " + repository.save(new User("user2", "User2 last", "user2 first", "user2@email.com", "Inactive")));
            log.info("Preloading " + repository.save(new User("user3", "User3 last", "user3 first", "user3@email.com", "Active")));
            log.info("Preloading " + repository.save(new User("user4", "User4 last", "user4 first", "user4@email.com", "Blocked")));
        };
    }

    @Bean
    CommandLineRunner initDatabase(StatusRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new UserStatus("Active")));
            log.info("Preloading " + repository.save(new UserStatus("Inactive")));
            log.info("Preloading " + repository.save(new UserStatus("Blocked")));
        };
    }
}

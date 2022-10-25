package com.testblog.md.Controllers;

import com.testblog.md.Exceptions.UserNotFoundException;
import com.testblog.md.Models.User;
import com.testblog.md.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    public User update(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(Math.toIntExact(id))
                .map(user -> {
                    user.setFirst_name(newUser.getFirst_name());
                    user.setLast_name(newUser.getLast_name());
                    user.setStatus(newUser.getStatus());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}

package com.moss.library.user.interfaces;

import com.moss.library.user.application.UserService;
import com.moss.library.user.domain.User;
import com.moss.library.user.infrastructrue.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {
    private UserService service;
    private UserRepository repository;

    public UserController(UserService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public User save(@Valid @RequestBody User user) {
        return service.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return repository.findAll();
    }

    @DeleteMapping("{userId}")
    public User delete(@Valid @PathVariable("userId") User user) {
        return service.delete(user);
    }
}

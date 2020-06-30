package homework33.src.main.java.com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/user")
    public String getUserByName(@RequestParam String name) {
        return "test" + name;
    }

    @GetMapping("/user{id}")
    public String getUserById(@RequestParam Long id) {
        return "test" + id;
    }

    @PostMapping("/user")
    public void setUser(@RequestBody UserDTO userDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        userService.saveUser(mapperFactory.getMapperFacade().map(userDTO, User.class));
    }

    @GetMapping("user/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserDTO userDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        userService.updateUser(mapperFactory.getMapperFacade().map(userDTO, User.class));
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUserById(Long id) {
        return userService.deleteUser(id);
    }

    @DeleteMapping("/user/delete_all")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }
}

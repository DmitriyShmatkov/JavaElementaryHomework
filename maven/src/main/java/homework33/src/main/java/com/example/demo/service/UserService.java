package homework33.src.main.java.com.example.demo.service;

import com.example.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteAllUsers();

    boolean deleteUser(Long id);
}

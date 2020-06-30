package homework33.src.main.java.com.example.demo.service.implementation;

import com.example.demo.Model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User userUpdate = userRepository.getOne(user.getId());

        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());

        userRepository.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public boolean deleteUser(Long id) {
        User user = userRepository.getOne(Math.toIntExact(id));
        user.setDeleted(true);
        saveUser(user);
        return true;
    }


}

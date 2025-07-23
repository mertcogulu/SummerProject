package summer_prac.edu_web.service;

import summer_prac.edu_web.dto.SignupFormDto;
import summer_prac.edu_web.entity.User;
import summer_prac.edu_web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Boolean emailExists(String email) {return userRepository.findByEmail(email).isPresent();}

    public void registerNewUser(SignupFormDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(User.Role.STUDENT);
        userRepository.save(user);
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers(){return userRepository.findAll();}

    public void save(User user){userRepository.save(user);}
}
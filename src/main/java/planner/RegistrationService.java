package planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roy_v
 */
@Service
public class RegistrationService {

    
    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistrationService() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public void Save(User user) {
        String password = user.getPassWord();
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        user.setPassWord(encryptedPassword);
        userRepository.save(user);
    }

}

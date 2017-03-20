package planner;

import security.repo.UsrRoleRepository;
import security.repo.LoginRepository;
import security.model.LoginModel;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import security.model.LoginModel;

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
    private LoginRepository userRepository;
    
    @Autowired
    private UsrRoleRepository roleRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistrationService() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public void Save(LoginModel user) {
        String password = user.getPassWord();
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        user.setPassWord(encryptedPassword);
        user.setRoles(new HashSet<>(roleRepository.findByName("USER")));
        userRepository.save(user);
    }
}

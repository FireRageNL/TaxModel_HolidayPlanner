package planner;

import security.model.CustomUserDetail;
import security.repo.LoginRepository;
import security.model.Login;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roy_v
 */
@Service("customUserDetailService")
@EnableJpaRepositories(basePackages = "security.repo")
@EntityScan(basePackages = "security.model")
public class CustomUserDetailService implements UserDetailsService {

    private final LoginRepository loginRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomUserDetailService(LoginRepository logRepo) {
        this.loginRepository = logRepo;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String string) {
        Login user = loginRepository.findByUserName(string);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        if (user.getUserName() == null) {
            throw new UsernameNotFoundException("No username found with the username: " + string);
        } else {
            return new CustomUserDetail(user);
        }
    }

}

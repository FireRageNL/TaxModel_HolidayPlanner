package HolidayPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
public class CustomUserDetailService implements UserDetailsService{
    private final LoginRepository LoginRepository;

    @Autowired
    public CustomUserDetailService(LoginRepository logRepo){
        this.LoginRepository = logRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        Login user = LoginRepository.findByUserName(string);
        if(user == null){
            throw new UsernameNotFoundException("No username found with the username: "+ string);
        }
        else{
            return new CustomUserDetail(user);
        }
    }
    
}

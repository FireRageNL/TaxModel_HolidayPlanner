package planner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roy_v
 */
@Repository
public interface LoginRepository extends CrudRepository<Login,Long> {
    public Login findByUserName(String username);
    
}

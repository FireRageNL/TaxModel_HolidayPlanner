/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import java.util.HashSet;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author roy_v
 */
public interface UsrRoleRepository extends CrudRepository<Role, Long>{
        public HashSet<Role> findByName(String name);   

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.repo;

import security.model.RoleModel;
import java.util.HashSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author roy_v
 */
@Repository
public interface UsrRoleRepository extends CrudRepository<RoleModel, Long>{
        public HashSet<RoleModel> findByName(String name);   

}

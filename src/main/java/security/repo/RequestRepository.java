/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.model.LoginModel;
import security.model.RequestModel;

/**
 *
 * @author Martijn
 */

@Repository
public interface RequestRepository extends CrudRepository<RequestModel,Long> {
    
    public ArrayList<RequestModel> findByRequestor(LoginModel requestor);
    
}

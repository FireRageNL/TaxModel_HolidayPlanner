package security.model;
/**
 *
 * @author roy_v
 */
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usrRoles")
public class Role implements Serializable {

    private Long id;
    private String name;
    private Set<Login> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    public Set<Login> getUsers() {
        return users;
    }

    public void setUsers(Set<Login> users) {
        this.users = users;
    }
}

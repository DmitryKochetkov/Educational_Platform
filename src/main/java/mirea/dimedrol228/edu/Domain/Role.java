package mirea.dimedrol228.edu.Domain;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {

    String authority;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    List<User> users;

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return authority;
    }
}

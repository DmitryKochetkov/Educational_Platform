package mirea.dimedrol228.edu.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
//    @Column(name = "roles")
    List<Role> authorities;

    String password;
    String username;
    boolean isAccountNonExpired;
    boolean isAccountNonLocked;
    boolean isCredentialsNonExpired;
    boolean isEnabled;

    @Column(name = "isOnline")
    boolean isOnline = false; //TODO: change when login/logout

    String email;
    String education;

    @Override
    public String toString() {
        return "id" + this.getId();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public List<String> getAuthoritiesStrings() {
        List<String> res = new ArrayList<>();
        for (Role role: authorities) {res.add(role.toString());}
        return res;
    }

    //TODO: articles
    //TODO: subscribers
}

package mirea.dimedrol228.edu.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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

    @Column(name = "is_online")
    boolean isOnline = false; //TODO: change when login/logout

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Article> articles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="subscribers",
            joinColumns=@JoinColumn(name="author_id"),
            inverseJoinColumns=@JoinColumn(name="subscriber_id")
    )
    private List<User> subscribers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="subscribers",
            joinColumns=@JoinColumn(name="subscriber_id"),
            inverseJoinColumns=@JoinColumn(name="author_id")
    )
    private List<User> subscribedTo;

    @OneToMany(mappedBy = "course_author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> myCourses;

    @ManyToMany
    @JoinTable(name = "studying",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> studyingCourses;

    @ManyToMany
    @JoinTable(name = "enrolled",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> graduatedCourses;

    String email;
    String education;

    @Override
    public String toString() {
        return "id" + getId();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public List<String> getAuthoritiesStrings() {
        List<String> res = new ArrayList<>();
        for (Role role : authorities) {
            res.add(role.toString());
        }
        return res;
    }


}

package mirea.dimedrol.edu.Model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class RoleDao extends BaseEntity {

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UserDao> users;
}

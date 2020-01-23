package mirea.dimedrol228.edu.Repositories;

import mirea.dimedrol228.edu.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String string);
}

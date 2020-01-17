package mirea.dimedrol.edu.Repository;

import mirea.dimedrol.edu.Model.RoleDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleDao, Long> {
    RoleDao findByName(String name);
}

package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.model.RegisterKey.RoleKey;
import pl.javastart.model.User.Role;
@Repository
public interface RoleKeyRepository extends JpaRepository<RoleKey, Integer> {
}

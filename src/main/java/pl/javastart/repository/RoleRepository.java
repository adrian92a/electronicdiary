package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.RegisterKey;
import pl.javastart.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
	@Query("select id from Role u where u.roleName = ?1")
	int findIdByRoleName(String roleName);
	@Query("select r from Role r where r.id = ?1")
	Role findRoleById(Integer roleId);
}

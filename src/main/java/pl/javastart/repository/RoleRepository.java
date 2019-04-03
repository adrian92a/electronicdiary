package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.User.Role;
import pl.javastart.model.User.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{

	@Query("select id from Role u where u.roleName = ?1")
	int findIdByRoleName(String roleName);
	@Query("select r from Role r where r.id = ?1")
	Role findRoleById(Integer roleId);

	Optional<Role> findByRoleName(String roleName);
	List<Role> findRoleByUsers(User user);
//	@Query("select r.roleName from Role r inner join UserRole ur on ur.role=r.roleName")
//	List<UserRole> findUserRole(String email);
}

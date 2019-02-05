package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Mark;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u.id from User u where u.email = ?1 and u.password=?2")
	  Integer findLoginAndPassword(String login,String password);
	
	@Query("select u from User u where u.email = ?1")
	  User getUserByLogin(String login);
	
	@Query("select u from User u where u.email = ?1 and u.password=?2")
	  User findUserWithPropertyPassword(String login,String password);;
	//  inner join RegisterKey rk on r.id=rk.role  where rk.keyRegisterValue = ?1"

@Query("select r.roleName from Role r inner join User u on r.id=u.role  where u.email = ?1")  
String findUserRole(String email);

@Query("select u.id from User u where u.email = ?1")
Integer findUserByEmail(String email);

	}
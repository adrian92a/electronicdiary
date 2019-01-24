package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.RegisterKey;
import pl.javastart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u.id from User u where u.username = ?1 and u.password=?2")
	  Integer findLoginAndPassword(String login,String password);
	
	@Query("select u from User u where u.username = ?1")
	  User getUserByLogin(String login);
	
	@Query("select u from User u where u.username = ?1 and u.password=?2")
	  User findUserWithPropertyPassword(String login,String password);;
	
}
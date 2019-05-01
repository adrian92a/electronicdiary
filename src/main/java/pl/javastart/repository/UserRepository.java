package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.User.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
	Optional <User> findAllByEmail (String email);

@Query(value = "SELECT CASE  WHEN count(u)> 0 THEN true ELSE false END FROM  User u where u.email = ?1 and u.password=?2")
Boolean checkIfUsersEmailAndPasswordExists(String email, String password);

@Query(value = "SELECT CASE  WHEN count(u)=0  THEN true ELSE false END FROM  User u where u.email = ?1")
Boolean checkIfDoesntExistByEmail(String email);

	@Query("select r.roleName from Role r")
	List<String> findUserRole(String email);



@Query("select u.id from User u where u.email = ?1")
Integer findUserByEmail(String email);

	}
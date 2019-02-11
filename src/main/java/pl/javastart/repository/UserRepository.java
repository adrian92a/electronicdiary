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

//	@Query(value = "SELECT CASE  WHEN count(u)> 0 THEN true ELSE false END FROM  User u where u.email = ?1 and u.password=?2")
//	Integer findByEmailPasswordExists(String email, String password);

@Query(value = "SELECT CASE  WHEN count(u)> 0 THEN true ELSE false END FROM  User u where u.email = ?1 and u.password=?2")
Boolean findByEmailPasswordExists(String email, String password);

@Query(value = "SELECT CASE  WHEN count(u)=0  THEN true ELSE false END FROM  User u where u.email = ?1")
Boolean checkIfDoesntExistByEmail(String email);

    @Query("select count(u) from User u where u.email = ?1")
    Long  findNumbersByEmail(String email);

	@Query("select u.id from User u where u.email = ?1")
	Integer finUserID(String email);

@Query("select u from User u where u.email = ?1")
  User getUserByLogin(String email);

@Query("select u from User u where u.email = ?1 and u.password=?2")
  User findUserWithPropertyPassword(String login,String password);;

@Query("select r.roleName from Role r inner join User u on r.id=u.role  where u.email = ?1")  
String findUserRole(String email);

@Query("select u.id from User u where u.email = ?1")
Integer findUserByEmail(String email);

	}
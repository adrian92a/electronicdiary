package pl.javastart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import pl.javastart.model.RegisterKey;




public interface RegisterKeyRepository extends JpaRepository<RegisterKey, Long>
{
	@Query("select u from RegisterKey u where u.keyRegisterValue = ?1")
	  RegisterKey findByEmailAddress(String emailAddress);
	@Query("select u.roleName from Role u inner join RegisterKey r on u.id=r.role  where r.keyRegisterValue = ?1")
	  String findRegisterKeyRoleName(String registerKet);
	
//	@Query("INSERT INTO User(login,password) VALUES( ?1 ,?2)")
//	void save(String login,String password);
}
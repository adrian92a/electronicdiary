package pl.javastart.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import pl.javastart.model.RegisterKey;
import pl.javastart.model.Role;




public interface RegisterKeyRepository extends JpaRepository<RegisterKey, Long>
{
	@Query("select u from RegisterKey u where u.keyRegisterValue = ?1")
	RegisterKey findByRegisterey(String key);
	@Query("select r from Role r inner join RegisterKey rk on r.id=rk.role  where rk.keyRegisterValue = ?1")
	Set<Role> findRegisterKeyRoleName(String registerKey);
	

}
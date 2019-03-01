package pl.javastart.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import pl.javastart.model.RegisterKey.RegisterKey;
import pl.javastart.model.RegisterKey.RoleKey;

@Repository
public interface RegisterKeyRepository extends JpaRepository<RegisterKey, Long>
{
	RegisterKey findByKeyRegisterValue(String registerKey);
	@Query("select r from RegisterKey r where r.keyRegisterValue = ?1")

	RegisterKey findByRegisterey(String key);

	@Query("select r from RoleKey r inner join RegisterKey rk " +
			"on r.keyRoleName.id=rk.id  where " +
			"rk.keyRegisterValue=?1")
	Set<RoleKey> findRegisterKeyRoleName(String registerKey);


}
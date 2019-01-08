package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.RegisterKey;



@Repository
public interface RegisterKeyRepository extends JpaRepository<RegisterKey, Long>
{
	
}


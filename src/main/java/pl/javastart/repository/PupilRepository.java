package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.User;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Long>{

	@Query("select p.id from Pupil p "
			+ "inner join User u on p.user.id=u.id where u.email= ?1")
	Integer szukajId(String email);

	
}
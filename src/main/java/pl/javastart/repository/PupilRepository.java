package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.User;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Long>{

	
	
	
}
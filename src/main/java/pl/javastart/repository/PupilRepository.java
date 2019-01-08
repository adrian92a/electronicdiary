package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import pl.javastart.model.Pupil;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Long>{
}
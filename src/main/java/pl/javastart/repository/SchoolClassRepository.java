package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Schollclass;

import java.util.Optional;

@Repository
public interface SchoolClassRepository  extends JpaRepository<Schollclass, Integer>{
	@Query("select s.id from Schollclass s where s.classNumber = ?1 and s.classLetter=?2")
	Integer findScholdClassByClassNumberAndClassLetter(Integer schollclassNumber, String schollclassLetter);

	Optional<Schollclass> findByClassNumberEqualsAndClassLetterEquals(Integer schollclassNumber, String schollclassLetter);

}

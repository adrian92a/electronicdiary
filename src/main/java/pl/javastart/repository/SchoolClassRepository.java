package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Schollclass;
import pl.javastart.model.Teacher;

@Repository
public interface SchoolClassRepository  extends JpaRepository<Schollclass, Long>{
	@Query("select s from Schollclass s where s.classNumber = ?1 and s.classLetter=?2")
	Schollclass findSchollclassByClassNumberAndClassLetter(Integer schollclassNumber, String schollclassLetter);
//	@Query("select s from Schollclass s where s.classNumber = ?1")
//	Schollclass findSchollclassByClassNumberAndClassLetter(String schollclassNumber);
	
//	@Query("select s from Schollclass s where s.classLetter=?2")
//	Schollclass findSchollclassByClassNumberAndClassLetter(String classLetter);
}

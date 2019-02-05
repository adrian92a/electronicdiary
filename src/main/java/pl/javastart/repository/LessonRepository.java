package pl.javastart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Lesson;
import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.User;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long>{
	@Query("select m.markValue, m.markPurpose, m.markWeight, p.id, l.schollclass, l.teacher,l.subjectName from Lesson l "
			+ "inner join Pupil p on p.schollclass.id=l.schollclass.id inner join Mark m on "
			+ "m.pupil.id=p.id "
			+ "where p.id =?1 and l.subjectName=?2")
	List<Object[]> findValuesToMarkTable(int id,String subjectName);
	
	@Query("select l.teacher.id from Lesson l "
			+ "inner join Pupil p on p.schollclass.id=l.schollclass.id "
			+ "where p.id =?1 and l.subjectName=?2")
	Integer findTeacher(int id, String subjectName);
	
	@Query("select s.id, s.classNumber, s.classLetter, l.id , l.schollclass from Lesson l inner join Schollclass s on s.id= l.schollclass.id "
			+ "where l.teacher.id=?1")
	List<Object[]> findTeacherClass(int id);
	
	@Query("select distinct l from Lesson l")
	List<Lesson>  findDistinctSubject();
}	 
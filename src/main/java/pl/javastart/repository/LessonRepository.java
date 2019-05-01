package pl.javastart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer>{

	@Query("select m.markValue, m.markPurpose, m.markWeight, m.markDate from Mark m where m.pupil.id=?1 and m.lesson.id=?2")
	List<Object[]> findValuesToMarkTable(int pupilId,int lessonId);

	@Query("select s.id from Schollclass s inner join Pupil p on p.schollclass.id=s.id where p.id=?1")
			Integer findSchollClassId(int pupilId);

	@Query("select l.id from Lesson l inner join Schollclass s on s.id=l.schollclass.id  where s.id=?1 and l.subjectName=?2")
	Integer findLessonId(int schollclassId,String subjectName);

	@Query("select l.teacher.id from Lesson l "
			+ "inner join Pupil p on p.schollclass.id=l.schollclass.id "
			+ "where p.id =?1 and l.subjectName=?2")
	Integer findTeacher(int id, String subjectName);
	
	@Query("select s.id, s.classNumber, s.classLetter, l.subjectName, l.id , l.schollclass from Lesson l inner join Schollclass s on s.id= l.schollclass.id "
			+ "where l.teacher.id=?1")
	List<Object[]> findTeacherClass(int id);
	
	@Query("select l.subjectName from Lesson l where l.id=?1")
	String lessonName(Integer lessonId);

	List<Lesson> findAllBySchollclass_Id(Integer schoolClassId);



}	 
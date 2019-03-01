package pl.javastart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Pupil;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Integer>{

	@Query("select p.id from Pupil p "
			+ "inner join User u on p.user.id=u.id where u.email= ?1")
	Integer szukajId(String email);

	@Query("select p.id, p.firstName, p.lastName from Pupil p "
			+ "inner join Schollclass s on p.schollclass.id=s.id where s.id= ?1")
	List<Object[]>  findPupilListFromClass(Integer id);
	
	
	@Query("select p.id, p.firstName, p.lastName from Pupil p "
			+ "inner join Schollclass s on p.schollclass.id=s.id inner join Lesson l on l.schollclass.id =s.id where l.id =?1")
	List<Object[]>  findPupilListFromLessonId(Integer lessonId);

	@Query("select p.schollclass.id from Pupil p inner join Schollclass s on p.schollclass.id=s.id where p.id=?1 ")
	Integer pupilSchoolclassId(Integer pupilId);
}
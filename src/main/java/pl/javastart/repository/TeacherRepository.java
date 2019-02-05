package pl.javastart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Pupil;
import pl.javastart.model.Teacher;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	@Query("select t.firstName from Teacher t where t.id= ?1")
	String findFirstNameTeacher(Integer id);
	
	@Query("select  t.lastName from Teacher t where t.id= ?1")
	String findLastNameTeacher(Integer id);
	
	@Query("select t.id from Teacher t "
			+ "inner join User u on t.user.id=u.id where u.id= ?1")
	Integer findTeacherID(Integer  id);
	
	@Query("select t.id from Teacher t "
			+ "inner join User u on t.user.id=u.id where u.email= ?1")
	Integer findTeacherIdByEmail(String  email);
}
package pl.javastart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Lesson;
import pl.javastart.model.Mark;
import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.User;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long>{

	@Query("select id from Role u where u.roleName = ?1")
	int findIdByRoleName(String roleName);
	
//	@Query("select l from Lesson l")
//	List<Object[]> findSubject();
//	
//	@Query("select m from Mark m")
//	List<Object[]> findMark();
//	
//	@Query("SELECT l FROM Lesson l JOIN FETCH l.marks")
//	List<Object[]> find();
//	
//	@Query("select m.markValue, u.email from Mark m "
//			+ "inner join Pupil p on p.user.id=m.pupil.id "
//			+ "inner join User u on  u.id=p.user.id "
//			+ "where u.email=?1")
//	List<Object[]> findMark(String name);
	
//	@Query("Select m.markValue from Mark "
//			+ "inner join Lesson l on l.id=m.lesson")
//List<Object[]> findMark();
	
//	@Query("select m from Mark m")
//	List<Mark> findMark();
//	List<Mark>  findByPupil_PupilId(Integer id);
	
}
//@Query("select r from Role r inner join RegisterKey rk on r.id=rk.role  where rk.keyRegisterValue = ?1")
package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Mark;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer>{

	@Query("select id from Role u where u.roleName = ?1")
	int findIdByRoleName(String roleName);

	@Query("select m from Mark m where m.id = ?1")
	Mark findMarkById(Integer markId);


	List<Mark> findAllByPupil_Id(Integer id);
}

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
}

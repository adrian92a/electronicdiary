package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Pupil;
import pl.javastart.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
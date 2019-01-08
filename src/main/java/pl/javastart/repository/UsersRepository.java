package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import pl.javastart.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
}
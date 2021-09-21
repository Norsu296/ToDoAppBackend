package pl.jb.todoapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jb.todoapp.Entity.User;

public interface UserRepository extends JpaRepository <User, Long> {



}

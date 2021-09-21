package pl.jb.todoapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jb.todoapp.Entity.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {


}

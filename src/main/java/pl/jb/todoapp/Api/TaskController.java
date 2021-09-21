package pl.jb.todoapp.Api;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jb.todoapp.Entity.Task;
import pl.jb.todoapp.Repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Task> findById(@PathVariable Long id){
        return taskRepository.findById(id);
    }
    @PostMapping("/add")
    public List<Task> create(@RequestBody Task task){
        taskRepository.save(task);
        return taskRepository.findAll();
    }
    @PutMapping("/edit")
    public void edit(@RequestBody Task task){
        if(taskRepository.existsById(task.getId())){
            taskRepository.save(task);
        }
    }
    @PutMapping("/finish/{id}")
    public void finish(@PathVariable Long id){
        if(taskRepository.existsById(id)){
            Task task = taskRepository.getById(id);
            task.setFinished(true);
            taskRepository.save(task);
        }
    }
    @PutMapping("/restore/{id}")
    public void restore(@PathVariable Long id){
        if(taskRepository.existsById(id)){
            Task task = taskRepository.getById(id);
            task.setFinished(false);
            taskRepository.save(task);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }

    }



}

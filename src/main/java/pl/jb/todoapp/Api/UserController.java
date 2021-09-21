package pl.jb.todoapp.Api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jb.todoapp.Entity.User;
import pl.jb.todoapp.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
       return userRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return userRepository.findById(id);
    }
    @PostMapping("/add")
    public void create(@RequestBody User user){
        userRepository.save(user);
    }
    @PutMapping("/{id}/{name}")
    public void edit(@PathVariable Long id, @PathVariable String name){
        if(userRepository.existsById(id)){
            User user = userRepository.getById(id);
            user.setName(name);
            userRepository.save(user);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }
    @GetMapping("/test")
    public void add(){
        User user = new User(1L, "aaa");
        userRepository.save(user);
    }


}

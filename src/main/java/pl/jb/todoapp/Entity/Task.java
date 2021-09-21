package pl.jb.todoapp.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3)
    private String name;
    @Column(name = "is_important")
    private boolean important;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "planned_end_date")
    @Future
    private LocalDate plannedEndDate;
    @Column(name = "is_finished", columnDefinition = "boolean default false")
    private boolean finished;
    @ManyToOne
    private User user;

    @PrePersist
    public void prePersist(){
        startDate = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate(){
        endDate = LocalDate.now();
    }


}

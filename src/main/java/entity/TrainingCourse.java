package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "training_course")
@Data
public class TrainingCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "trainingCourse", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<StudentResult> studentResults;
}

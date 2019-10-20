package entity;

import entity.compositepk.StudentResultPK;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_result")
@IdClass(StudentResultPK.class)
@Data
public class StudentResult {

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "note", length = 50)
    private String note;

    @Column(name = "result", nullable = false)
    private Integer result;

    @ManyToOne
    @Id
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @Id
    @JoinColumn(name = "training_course_id", nullable = false)
    private TrainingCourse trainingCourse;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = true)
    private Exam exam;
}



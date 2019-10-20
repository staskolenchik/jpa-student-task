package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "exam_result")
@Data
public class ExamResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer result;

    @Column(length = 50)
    private String note;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
}


package entity.compositepk;

import entity.Student;
import entity.TrainingCourse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class StudentResultPK implements Serializable {

    private Student student;

    private TrainingCourse trainingCourse;

}

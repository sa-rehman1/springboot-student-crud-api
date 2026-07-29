package in.nextrack.Crudarmy.service;


import in.nextrack.Crudarmy.entity.Student;
import in.nextrack.Crudarmy.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    // Dependency Injection no need of Autowired as it is constructor
    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student studentReq) {
        // While creating a student by default it should be not deleted
        studentReq.setDeleted(false);
        return studentRepository.save(studentReq);
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        return studentResp.orElse(null);

    }

    public List<Student> getAll() {
        return studentRepository.findByDeletedFalse();
    }

    public Student updateStudent(Long id, Student studentReq) {

        Student student = studentRepository.findByIdAndDeletedIsFalse(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        student.setRollNo(studentReq.getRollNo());
        student.setSubject(studentReq.getSubject());

        return studentRepository.save(student);
    }

    // This is Hard Delete my idea was to delete it completely from the DB irrespective of whether  it was soft deleted already.
    public Boolean deleteStudent(Long id) {
        boolean isStudent = studentRepository.existsById(id);

        if (!isStudent)
            return false;

        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> exisitingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if (exisitingStudent.isEmpty()){
            return false;
        }

       Student  studentToSave = exisitingStudent.get();

        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);

        return true;
    }
}

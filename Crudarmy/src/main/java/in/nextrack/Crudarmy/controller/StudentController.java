package in.nextrack.Crudarmy.controller;

import in.nextrack.Crudarmy.entity.Student;
import in.nextrack.Crudarmy.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // It is using controller annotation which is using Component
@RequestMapping("/api/students")
public class StudentController {

    // We have to send the request to Service layer which handles the business logic through dependency injection ( Constructor recommended)
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //Create Student --> POST
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){ // Here we are telling java that the Student object will be received in form of JSON in request body just accept it and map it properly
            Student createdStudent = studentService.createStudent(student);
            return ResponseEntity.
                    status(HttpStatus.CREATED).
                    body(createdStudent);
    }

    // Read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        Student studentResp = studentService.getStudent(id);

        if (studentResp == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp); // Why are writing like this?
    }


    // Read all Students
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentList = studentService.getAll();

        if (studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
    //update student

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id , @RequestBody Student studentReq){
        Student resp = studentService.updateStudent(id , studentReq);

        if (resp == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resp);
    }


    //delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if (!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(true);
    }

    // Soft Delete
    @PatchMapping("/delete-soft/{id}")
    public  ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id)
    {
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Deleted");
    }
}

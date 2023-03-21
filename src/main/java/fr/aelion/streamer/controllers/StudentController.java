package fr.aelion.streamer.controllers;

import fr.aelion.streamer.dto.AddStudentDto;
import fr.aelion.streamer.dto.SimpleStudentDto;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")// http://127.0.0.1:5000/api/v1/students permet de le récuperer sur l'url
public class StudentController {
    @Autowired
    private StudentService studentService;
    //its controller
    @GetMapping
    @CrossOrigin
    public List<Student> findAll(){

        return  studentService.findAll();
    }

    @GetMapping("simple")
    @CrossOrigin
    public List<SimpleStudentDto> findAllSimple() {
        return studentService.findSimpleStudents();
    }
    /**
     * post a nex student
     * uri  : post http://127.0.0.1:5000/apip /v1/students
     * @param student
     * @return
     */
    @PostMapping
    @CrossOrigin

    public ResponseEntity<?> add(@Valid @RequestBody AddStudentDto student) {
        try {

            return ResponseEntity.created( null).body(studentService.add(student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}

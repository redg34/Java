package fr.aelion.streamer.controllers;

import fr.aelion.streamer.dto.AddStudentDto;
import fr.aelion.streamer.dto.SimpleStudentDto;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.StudentService;
import fr.aelion.streamer.services.exceptions.EmailAlreadyExistsException;
import fr.aelion.streamer.services.exceptions.LoginAlreadyExistsException;
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

    public List<Student> findAll(){

        return  studentService.findAll();
    }
    @GetMapping("{id}")// get http://127.0.0.1:5000/api/v1/students/1
    public  ResponseEntity<?> findOne(@PathVariable int id){
        return  ResponseEntity.ok("Have to find a Student  with id: " +id);
    }

    @GetMapping("simple")

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
    public ResponseEntity<?> add(@Valid @RequestBody AddStudentDto student) {
        try {
            Student newStudent = studentService.add(student);
            return ResponseEntity.created(null).body(newStudent);
        } catch(EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.reject());
        } catch (LoginAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body((e.reject()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

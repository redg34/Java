package fr.aelion.streamer.services;

import fr.aelion.streamer.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private JpaRepository repository;
    public List<Student> findAll(){
        //la méthode est find all est appelé avec le repository
        return repository.findAll();

    }
    public  Student  add(Student student){

      student = (Student) repository.save(student);
      return student;

    }
}

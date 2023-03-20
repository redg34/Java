package fr.aelion.streamer.services;

import fr.aelion.streamer.dto.AddStudentDto;
import fr.aelion.streamer.dto.ModuleDto;
import fr.aelion.streamer.dto.SimpleStudentDto;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.repositories.StudentRepository;
import fr.aelion.streamer.services.exceptions.EmailAlreadyExistsException;
import fr.aelion.streamer.services.exceptions.LoginAlreadyExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentService {
    @Autowired
    private StudentRepository repository;
    private Student student;

    @Autowired
    private ModelMapper modelMapper;

    public List<Student> findAll(){
        //la méthode est find all est appelé avec le repository
        return repository.findAll();

    }
    public List <SimpleStudentDto> findSimpleStudents() {
        return this.findAll()
                .stream()
                .map(s -> {
                    var simpleStudent = new SimpleStudentDto();
                    simpleStudent.setId(s.getId());
                    simpleStudent.setLastName((s.getLastName()));
                    simpleStudent.setFirstName(s.getFirstName());
                    simpleStudent.setEmail(s.getEmail());
                    return simpleStudent;
                }).collect(Collectors.toList());
    }

    public Student add(AddStudentDto student) throws Exception {

        Student anyStudent = repository.findByEmail(student.getEmail());
        if (anyStudent != null) {
            throw new EmailAlreadyExistsException("Email " + student.getEmail() + " already exists");
        }
        anyStudent = repository.findByLogin(student.getLogin());
        if (anyStudent != null) {
            throw new LoginAlreadyExistsException("Login " + student.getLogin() + " already exists");
        }
        Student newStudent = modelMapper.map(student, Student.class);
        newStudent = (Student) repository.save(newStudent);

        return newStudent;
    }

}

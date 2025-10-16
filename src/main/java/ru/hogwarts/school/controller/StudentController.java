package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Long createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
    @DeleteMapping("{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @GetMapping("/filter")
    public List<Student> filterStudentsByAge(@RequestParam int age) {
        return studentService.findStudentByAge(age);
    }
}

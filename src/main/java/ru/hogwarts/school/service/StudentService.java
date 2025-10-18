package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /*public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }*/

    public Student createStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentRepository.findAll());
    }
    public Student updateStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    public List<Student> findStudentByAge(int age) {
        if (age > 0) {
            return studentRepository.findAll().stream()
                    .filter(student -> student.getAge() == age)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}

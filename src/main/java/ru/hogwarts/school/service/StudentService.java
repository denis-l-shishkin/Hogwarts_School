package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private Long studentId = 0L;

    public Long createStudent(Student student) {
        student.setId(++studentId);
        students.put(student.getId(), student);
        return student.getId();
    }
    public Student getStudent(Long id) {
        return students.get(id);
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    public Student updateStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }
    public void deleteStudent(Long id) {
        students.remove(id);
    }
    public List<Student> findStudentByAge(int age) {
        if (age > 0) {
            return students.values().stream()
                    .filter(student -> student.getAge() == age)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}

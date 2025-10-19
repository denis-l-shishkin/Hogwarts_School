package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    public List<Faculty> getAllFaculties() {
        return new ArrayList<>(facultyRepository.findAll());
    }
    public Faculty updateFaculty(Faculty faculty) {
        Long facultyId = faculty.getId();
        if (!facultyRepository.existsById(facultyId)) {
            throw new FacultyNotFoundException(facultyId);
        }
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
    public List<Faculty> getFacultiesByColor(String color) {
        return facultyRepository.findAllByName(color);
    }
}

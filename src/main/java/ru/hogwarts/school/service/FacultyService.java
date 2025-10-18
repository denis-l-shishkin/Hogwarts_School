package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    /*public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }*/
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
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
    public List<Faculty> getFacultiesByColor(String color) {
        if (color != null && !color.isBlank()) {
            return facultyRepository.findAll().stream()
                    .filter(faculty -> faculty.getColor().equals(color))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}

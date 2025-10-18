package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private static Long facultyId = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++facultyId);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }
    public Faculty getFaculty(Long id) {
        return faculties.get(id);
    }
    public List<Faculty> getAllFaculties() {
        return new ArrayList<>(faculties.values());
    }
    public Faculty updateFaculty(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }
    public void deleteFaculty(Long id) {

        faculties.remove(id);
    }
    public List<Faculty> getFacultiesByColor(String color) {
        if (color != null && !color.isBlank()) {
            return faculties.values().stream()
                    .filter(faculty -> faculty.getColor().equals(color))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}

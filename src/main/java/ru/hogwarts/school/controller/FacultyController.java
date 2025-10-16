package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }
    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculties();
    }
    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }
    @GetMapping("{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFaculty(id);
    }
    @DeleteMapping("{id}")
    public void deleteFacultyById(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }
    @GetMapping ("/filter")
    public List<Faculty> filterFacultyByColor(@RequestParam String color) {
        return facultyService.getFacultiesByColor(color);
    }
}

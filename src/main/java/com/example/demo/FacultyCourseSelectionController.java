package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin("*")
public class FacultyCourseSelectionController {

    @Autowired
    private FacultyCourseSelectionService service;

    // SAVE SELECTIONS
    @PostMapping("/submit")
    public List<FacultyCourseSelection> submitSelection(
            @RequestBody FacultySelectionRequest request) {

        return service.saveSelections(
                request.getEmployeeId(),
                request.getName(),  // Changed from getFacultyName() to getName()
                request.getCohort(),
                request.getDepartment(),
                request.getSelectedCourses()
        );
    }

    // GET SELECTIONS BY EMPLOYEE ID
    @GetMapping("/{employeeId}")
    public List<FacultyCourseSelection> getByEmployeeId(
            @PathVariable String employeeId) {
        return service.getByEmployeeId(employeeId);
    }
    
    // CHECK IF EMPLOYEE HAS ALREADY SUBMITTED
    @GetMapping("/check/{employeeId}")
    public boolean hasSubmitted(@PathVariable String employeeId) {
        List<FacultyCourseSelection> existing = service.getByEmployeeId(employeeId);
        return !existing.isEmpty();
    }
    
    // UPDATE A SINGLE COURSE SELECTION BY ID
    @PutMapping("/update/{id}")
    public FacultyCourseSelection updateSelection(
            @PathVariable Long id,
            @RequestBody FacultyCourseSelection updatedSelection) {
        return service.updateSelection(id, updatedSelection);
    }
    
    // DELETE A SINGLE COURSE SELECTION BY ID
    @DeleteMapping("/delete/{id}")
    public void deleteSelection(@PathVariable Long id) {
        service.deleteSelection(id);
    }
    
    // DELETE ALL SELECTIONS BY EMPLOYEE ID
    @DeleteMapping("/delete-all/{employeeId}")
    public void deleteAllByEmployeeId(@PathVariable String employeeId) {
        service.deleteAllByEmployeeId(employeeId);
    }
}

/* ---------- DTO ---------- */
class FacultySelectionRequest {

    private String employeeId;
    private String name;  // Changed from facultyName to name
    private String cohort;
    private String department;
    private List<FacultyCourseSelection> selectedCourses;

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCohort() { return cohort; }
    public void setCohort(String cohort) { this.cohort = cohort; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<FacultyCourseSelection> getSelectedCourses() {
        return selectedCourses;
    }
    public void setSelectedCourses(List<FacultyCourseSelection> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }
}


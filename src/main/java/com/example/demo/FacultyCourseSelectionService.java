package com.example.demo;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacultyCourseSelectionService {

    @Autowired
    private FacultyCourseSelectionRepository repository;

    // SAVE MULTIPLE COURSE SELECTIONS
    public List<FacultyCourseSelection> saveSelections(
            String employeeId,
            String facultyName,
            String cohort,
            String department,
            List<FacultyCourseSelection> courses) {

        List<FacultyCourseSelection> savedList = new ArrayList<>();

        for (FacultyCourseSelection course : courses) {
            course.setEmployeeId(employeeId);
            course.setFacultyName(facultyName);
            course.setCohort(cohort);
            course.setDepartment(department);

            savedList.add(repository.save(course));
        }

        return savedList;
    }

    // GET BY EMPLOYEE ID
    public List<FacultyCourseSelection> getByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
    
    // UPDATE A SINGLE COURSE SELECTION
    public FacultyCourseSelection updateSelection(Long id, FacultyCourseSelection updatedSelection) {
        FacultyCourseSelection existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Selection not found with id: " + id));
        
        existing.setCourseCode(updatedSelection.getCourseCode());
        existing.setCourseName(updatedSelection.getCourseName());
        existing.setCategory(updatedSelection.getCategory());
        existing.setSemester(updatedSelection.getSemester());
        existing.setPriority(updatedSelection.getPriority());
        
        return repository.save(existing);
    }
    
    // DELETE A SINGLE COURSE SELECTION
    public void deleteSelection(Long id) {
        repository.deleteById(id);
    }
    
    // DELETE ALL SELECTIONS BY EMPLOYEE ID
    public void deleteAllByEmployeeId(String employeeId) {
        List<FacultyCourseSelection> selections = repository.findByEmployeeId(employeeId);
        repository.deleteAll(selections);
    }
    
    // GET ALL SELECTIONS
    public List<FacultyCourseSelection> getAllSelections() {
        return repository.findAll();
    }
}

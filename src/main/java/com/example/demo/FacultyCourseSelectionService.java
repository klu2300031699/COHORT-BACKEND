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
}

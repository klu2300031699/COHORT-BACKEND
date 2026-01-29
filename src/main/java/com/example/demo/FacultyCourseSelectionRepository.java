package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyCourseSelectionRepository
        extends JpaRepository<FacultyCourseSelection, Long> {

    List<FacultyCourseSelection> findByEmployeeId(String employeeId);
}

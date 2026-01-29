package com.example.demo;
import jakarta.persistence.*;

@Entity
@Table(name = "faculty_course_selection")
public class FacultyCourseSelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private String employeeId;
    
    @Column(name = "faculty_name")
    private String facultyName;
    
    @Column(name = "cohort")
    private String cohort;
    
    @Column(name = "department")
    private String department;

    @Column(name = "course_code")
    private String courseCode;
    
    @Column(name = "course_name")
    private String courseName;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "semester")
    private String semester;
    
    @Column(name = "priority")
    private String priority;

    public FacultyCourseSelection() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFacultyName() { return facultyName; }
    public void setFacultyName(String facultyName) { this.facultyName = facultyName; }

    public String getCohort() { return cohort; }
    public void setCohort(String cohort) { this.cohort = cohort; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}


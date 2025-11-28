package org.bits.model;

// Course.java - Embedded Document Representing a Course
import jakarta.validation.constraints.NotBlank;

public class Course {
    @NotBlank(message = "Course ID cannot be blank")
    private String courseId;

    @NotBlank(message = "Course Name cannot be blank")
    private String courseName;

    public Course() {}

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters and Setters
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public String toString() {
        return "Course{courseId='" + courseId + "', courseName='" + courseName + "'}";
    }
}


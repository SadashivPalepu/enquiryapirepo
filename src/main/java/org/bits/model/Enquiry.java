package org.bits.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.Valid;
import java.util.List;
import java.util.ArrayList;

@Document(collection = "enquiries")
public class Enquiry {
    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    private String phoneNo;

    @NotEmpty(message = "At least one course is required")
    @Valid
    private List<Course> courses = new ArrayList<>();

    public Enquiry() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    @Override
    public String toString() {
        return "Enquiry{id='" + id + "', name='" + name + "', phoneNo='" + phoneNo + "', courses=" + courses + "}";
    }
}

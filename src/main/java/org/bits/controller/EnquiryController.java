package org.bits.controller;

// EnquiryController.java - REST Controller Handling CRUD and Queries


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.bits.model.Enquiry;
import org.bits.repository.EnquiryRepository;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "*")
public class EnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @PostMapping
    public ResponseEntity<Enquiry> createEnquiry(@Valid @RequestBody Enquiry enquiry) {
        Enquiry saved = enquiryRepository.save(enquiry);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enquiry> getEnquiryById(@PathVariable String id) {
        Optional<Enquiry> enquiry = enquiryRepository.findById(id);
        return enquiry.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enquiry> updateEnquiry(@PathVariable String id, @Valid @RequestBody Enquiry enquiryDetails) {
        Optional<Enquiry> enquiryOptional = enquiryRepository.findById(id);
        if (enquiryOptional.isPresent()) {
            Enquiry enquiry = enquiryOptional.get();
            enquiry.setName(enquiryDetails.getName());
            enquiry.setPhoneNo(enquiryDetails.getPhoneNo());
            enquiry.setCourses(enquiryDetails.getCourses());
            Enquiry updated = enquiryRepository.save(enquiry);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnquiry(@PathVariable String id) {
        if (enquiryRepository.existsById(id)) {
            enquiryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/phoneNo/{phoneNo}")
    public List<Enquiry> getEnquiriesByPhoneNo(@PathVariable String phoneNo) {
        return enquiryRepository.findByPhoneNo(phoneNo);
    }

    @GetMapping("/courseId/{courseId}")
    public List<Enquiry> getEnquiriesByCourseId(@PathVariable String courseId) {
        return enquiryRepository.findByCoursesCourseId(courseId);
    }

    @GetMapping("/courseName/{courseName}")
    public List<Enquiry> getEnquiriesByCourseName(@PathVariable String courseName) {
        return enquiryRepository.findByCoursesCourseName(courseName);
    }
}
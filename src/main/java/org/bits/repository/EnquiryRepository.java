package org.bits.repository;

// EnquiryRepository.java - Repository Interface with Custom Queries


import org.bits.model.Enquiry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnquiryRepository extends MongoRepository<Enquiry, String> {
    List<Enquiry> findByPhoneNo(String phoneNo);
    List<Enquiry> findByCoursesCourseId(String courseId);
    List<Enquiry> findByCoursesCourseName(String courseName);
}


package com.adreams.abroad_dreams_back;

import com.adreams.abroad_dreams_back.entity.Instructor;
import com.adreams.abroad_dreams_back.repo.InstructorRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InstructorRepoTest {

    @Autowired
    private InstructorRepo instructorRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save() {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        instructor.setName("Sushmita"); // Assuming tour with ID 1 exists
        instructor.setAddress("Kathmandu"); // Assuming user with ID 1 exists
        instructor.setMobileNo("9813234234"); // Optional, set as needed
        instructor.setQualifications("BSc Hons"); // Assuming 2 persons
        instructor.setUploadFile("CV.pdf"); // Assuming total amount
        instructor = instructorRepo.save(instructor);
        Assertions.assertThat(instructor.getInstructorId()).isGreaterThan(0);
    }
}
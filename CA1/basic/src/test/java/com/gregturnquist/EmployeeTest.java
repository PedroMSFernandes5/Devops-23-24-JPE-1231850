package com.gregturnquist;

import com.greglturnquist.payroll.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testEmployee() {
        // Arrange
        String firstName = "Frodo";
        String lastName = "Baggins";
        String description = "ring bearer";
        int jobYears = 10;
        String email = "frodo.baggins@shire.com";

        // Act
        Employee employee = new Employee(firstName, lastName, description, jobYears, email);

        // Assert

        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(description, employee.getDescription());
        assertEquals(jobYears, employee.getJobYears());
        assertEquals(email, employee.getEmail());
    }
}
package com.jannkasper.baeldung.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employees")
@Data
@Accessors(chain = true)
@AttributeOverride(name = "id", column = @Column(name = "EmployeeID"))
public class Employee extends AbstractEntity {

    @Column(name = "LastName")
    private String lastName;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "BirthDate")
    private Date birthDate;
    @Column(name = "Photo")
    private String photo;
    @Column(name = "Notes")
    private String notes;
    
}

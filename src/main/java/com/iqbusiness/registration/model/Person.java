package com.iqbusiness.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Pattern(regexp = "\\d{13}")
    @NotBlank(message = "ID Number is mandatory")
    private String idNumber;

    @NotBlank(message = "Full Name is mandatory")
    private String fullName;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

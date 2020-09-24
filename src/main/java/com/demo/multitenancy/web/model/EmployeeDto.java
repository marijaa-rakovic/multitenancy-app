package com.demo.multitenancy.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public EmployeeDto(@JsonProperty("id") Long id,
                       @JsonProperty("firstName") String firstName,
                       @JsonProperty("lastName") String lastName,
                       @JsonProperty("email") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
}

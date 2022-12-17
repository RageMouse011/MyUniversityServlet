package com.project.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    @Override
    public String toString() {
        return "Employee [firstName=" + firstName +
                ", lastName=" + lastName + "]";
    }
}

package com.project.web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee extends Person {
    private double experience;

    public Employee(String firstName,
                    String lastName,
                    double experience) {
        super(firstName, lastName);
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", experience=" + experience + "]";
    }
}

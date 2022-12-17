package com.project.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    private double salary;

    @Override
    public String toString() {
        return "Salary [salary=" + salary + "]";
    }
}

package com.project.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Career {
    private String name;

    @Override
    public String toString() {
        return "Career [name=" + name + "]";
    }
}

package com.orange.assignment4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachDTO {

    private String name;
    private int age;
    private Long teamId;
}
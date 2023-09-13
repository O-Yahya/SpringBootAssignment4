package com.orange.assignment4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private String name;
    private int shirtNumber;
    private int age;
    private Long teamId;
}

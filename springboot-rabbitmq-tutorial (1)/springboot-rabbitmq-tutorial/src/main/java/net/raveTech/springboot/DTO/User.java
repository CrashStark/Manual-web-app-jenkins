package net.raveTech.springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int Id;
    private String firstName;
    private String Lastname;
}

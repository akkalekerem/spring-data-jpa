package com.keremakkale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { //IU = Insert Update demek. //İnsert ve Updateler için burası kullanılacak.

    private String firstName;

    private String lastName;

    private Date birthDate;

}

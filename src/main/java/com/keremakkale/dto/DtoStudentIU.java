package com.keremakkale.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { //IU = Insert Update demek. //İnsert ve Updateler için burası kullanılacak.

    @NotEmpty(message = "FirstName alanı boş bırakılamaz.")
    private String firstName;
    @Size(min = 3, max = 30)
    private String lastName;

    private Date birthDate;

    @Email(message = "Email formatı uygun değil.")
    private String email;

    @Size(min = 11, max = 11, message = "TCKN 11 karakter olmalıdır.")
    @NotEmpty(message = "TCKN alanı boş bırakılamaz.")
    private String tckn;

}

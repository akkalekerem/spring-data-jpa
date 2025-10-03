package com.keremakkale.exception;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiError<T> {  //Generic yapıyı öğrenmeye çalışıyorum.

    private String id;

    private Date errorTime;

    private T errors;
}

//<T> harfi, bu sınıfın herhangi bir veri tipini tutabilen esnek bir yapıya sahip olduğunu gösterir.

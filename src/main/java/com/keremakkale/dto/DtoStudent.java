package com.keremakkale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {  //GET işlemi yaparken burayı kullanacağız. //Yani sadece isim ve soyisim alacağız. //Doğum tarihi almayacağız.

    private String firstName;

    private String lastName;

    //Doğum tarihi almadım sadece isim ve soyisim aldım.
}

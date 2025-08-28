package com.keremakkale.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice   //Exception handler sınıfı olduğunu belirtiyoruz.
public class GlobalExceptionHandler { //Global seviyedeki bütün exceptionları burada yakalayacağız.
    //Spring validation'dan fırlatılan hataları alıp yönetmek ve response dönmek.

    private List<String> addMapValue(List<String> list, String newValue){
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(newValue);
        return list;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, List<String>> errorsMap = new HashMap<>();

       for (ObjectError error : ex.getBindingResult().getAllErrors()) {
           String fieldName = ((FieldError) error).getField();
           if(errorsMap.containsKey(fieldName)){
               errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), error.getDefaultMessage()));
           }else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), error.getDefaultMessage()));

           }
       }
       return ResponseEntity.badRequest().body(createApiError(errorsMap));  //Bad request 400 hatası döndürüyoruz.
    }

    private <T> ApiError<T> createApiError(T errors){  //Birinci <T> generic tip olduğunu belirtiyor. İkinci <T> ise metodun dönüş tipi.
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);
        return apiError;
    }
}

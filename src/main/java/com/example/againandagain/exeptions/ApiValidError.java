package com.example.againandagain.exeptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiValidError {
    private String path;
    private  String message;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;

}

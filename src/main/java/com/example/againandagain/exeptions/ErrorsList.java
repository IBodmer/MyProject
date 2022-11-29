package com.example.againandagain.exeptions;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.List;
@Getter
@RequiredArgsConstructor
public class ErrorsList {
    private final List<ErrorMessages> violations;

}
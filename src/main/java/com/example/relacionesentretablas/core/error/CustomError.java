package com.example.relacionesentretablas.core.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomError {
    Date timeStamp;
    int HttpCode;
    String mensaje;


}


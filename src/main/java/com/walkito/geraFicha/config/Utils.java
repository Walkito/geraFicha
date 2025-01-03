package com.walkito.geraFicha.config;

import com.walkito.geraFicha.model.ApiResponse;
import org.springframework.http.HttpStatus;

public class Utils {

    public static ApiResponse getDefaultInternalError(Exception e){
        return new ApiResponse(
                "Erro interno do sistema.",
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }
}

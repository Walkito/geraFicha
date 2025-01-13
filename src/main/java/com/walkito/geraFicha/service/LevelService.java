package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Level.Level;
import com.walkito.geraFicha.model.Level.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LevelService {
    @Autowired
    LevelRepository levelRepository;

    public ApiResponse createLevel(Level level){
        try{
            return new ApiResponse(
                    "Level criado com sucesso",
                    levelRepository.save(level),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

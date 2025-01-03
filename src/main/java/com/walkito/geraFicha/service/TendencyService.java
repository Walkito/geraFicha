package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Tendency.Tendency;
import com.walkito.geraFicha.model.Tendency.TendencyRepository;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TendencyService {
    @Autowired
    TendencyRepository tendencyRepository;

    public  ApiResponse getTendencyById(int id){
        try{
            Optional<Tendency> tendency = tendencyRepository.findById(id);

            return tendency.map(value -> new ApiResponse(
                    "Tendência retornada com sucesso",
                    value,
                    HttpStatus.OK.value()
            )).orElseGet(() -> new ApiResponse(
                    "Tendência inexistente",
                    null,
                    HttpStatus.NOT_FOUND.value()
            ));
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse getAllTendency(){
        try{
            List<Tendency> tendencys = tendencyRepository.findAll();

            return new ApiResponse(
                    "Tendências encontradas",
                    tendencys,
                    HttpStatus.OK.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }


    public ApiResponse createTendency(Tendency tendency) {

        try{
            return new ApiResponse(
                   "Tendência criada com sucesso!",
                   tendencyRepository.save(tendency),
                   HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

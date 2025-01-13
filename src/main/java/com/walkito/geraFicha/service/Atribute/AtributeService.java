package com.walkito.geraFicha.service.Atribute;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Atribute.Atribute;
import com.walkito.geraFicha.model.Atribute.AtributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AtributeService {
    @Autowired
    private AtributeRepository atributeRepository;

    public ApiResponse createAtribute(Atribute atribute){
        try{
            return new ApiResponse(
                    "Atributo criado com sucesso.",
                    atributeRepository.save(atribute),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

}

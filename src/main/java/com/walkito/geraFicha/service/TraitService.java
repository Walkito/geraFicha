package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Race.Trait.Trait;
import com.walkito.geraFicha.model.Race.Trait.TraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TraitService {
    @Autowired
    TraitRepository traitRepository;

    public ApiResponse createTrait(Trait trait){
        try{
            return new ApiResponse(
                    "Traço criado com sucesso!",
                    traitRepository.save(trait),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

}

package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import com.walkito.geraFicha.model.Proficiency.ProficiencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProficiencyService {
    @Autowired
    private ProficiencyRepository proficiencyRepository;

    public ApiResponse createProficiency(Proficiency proficiency){
        try{
            return new ApiResponse(
                    "Proficiencia criada com sucesso",
                    proficiencyRepository.save(proficiency),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultLinkResponse();
        }
    }
}

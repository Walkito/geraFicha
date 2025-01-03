package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Language.Language;
import com.walkito.geraFicha.model.Language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public ApiResponse createLanguage(Language language){
        try{
            return new ApiResponse(
                    "Novo idioma criado",
                    languageRepository.save(language),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkLanguageAndRace(int idLanguage, int idRace){
        try{


            return new ApiResponse(
                    "Vínculo realizado",
                    null,
                    HttpStatus.OK.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

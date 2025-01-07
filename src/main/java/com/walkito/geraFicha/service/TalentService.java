package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Talent.Talent;
import com.walkito.geraFicha.model.Talent.TalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TalentService {
    @Autowired
    TalentRepository talentRepository;

    public ApiResponse getAllTalents() {
        try {
            return new ApiResponse(
                    "Talentos encontrados.",
                    talentRepository.findAll(),
                    HttpStatus.OK.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse createTalent(Talent talent) {
        try {
            return new ApiResponse(
                    "Talento criado com sucesso!",
                    talentRepository.save(talent),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }
}

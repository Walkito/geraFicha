package com.walkito.geraFicha.service.Atribute.Skill;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Atribute.Skill.Skill;
import com.walkito.geraFicha.model.Atribute.Skill.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public ApiResponse createSkill(Skill skill){
        try{
            return new ApiResponse(
                    "Skill criada com sucesso!",
                    skillRepository.save(skill),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

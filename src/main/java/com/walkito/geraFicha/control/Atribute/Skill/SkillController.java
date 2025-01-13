package com.walkito.geraFicha.control.Atribute.Skill;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Atribute.Skill.Skill;
import com.walkito.geraFicha.service.Atribute.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping
    public ApiResponse createSkill(@RequestBody Skill skill){
        return skillService.createSkill(skill);
    }
}

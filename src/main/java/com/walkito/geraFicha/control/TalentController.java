package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Talent.Talent;
import com.walkito.geraFicha.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/talent")
public class TalentController {
    @Autowired
    TalentService talentService;

    @GetMapping
    public ApiResponse getAllTalents(){
        return this.talentService.getAllTalents();
    }
    
}

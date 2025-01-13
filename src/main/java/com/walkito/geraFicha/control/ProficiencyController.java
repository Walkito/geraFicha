package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import com.walkito.geraFicha.service.ProficiencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/proficiency")
public class ProficiencyController {
    @Autowired
    private ProficiencyService proficiencyService;

    @PostMapping
    public ApiResponse createProficiency(@RequestBody Proficiency proficiency){
        return  proficiencyService.createProficiency(proficiency);
    }
}

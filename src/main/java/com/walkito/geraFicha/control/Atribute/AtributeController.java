package com.walkito.geraFicha.control.Atribute;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Atribute.Atribute;
import com.walkito.geraFicha.service.Atribute.AtributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/atribute")
public class AtributeController {
    @Autowired
    private AtributeService atributeService;

    @PostMapping
    public ApiResponse createAtribute(@RequestBody Atribute atribute){
        return atributeService.createAtribute(atribute);
    }
}

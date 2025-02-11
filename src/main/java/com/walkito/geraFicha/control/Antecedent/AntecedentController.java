package com.walkito.geraFicha.control.Antecedent;

import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.service.Antecedent.AntecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/antecedent")
public class AntecedentController {
    @Autowired
    private AntecedentService antecedentService;

    @GetMapping
    public ApiResponse getAllAntecedents(){
        return antecedentService.getAllAntecedents();
    }
}

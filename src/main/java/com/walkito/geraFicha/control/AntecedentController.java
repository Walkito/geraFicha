package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.service.AntecedentService;
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

    @PostMapping
    public ApiResponse createAntecedent(@RequestBody Antecedent antecedent){
        return antecedentService.createAntecedent(antecedent);
    }

    @PostMapping(path = "/linkLanguage")
    public ApiResponse linkAntecedentAndLanguage(@RequestParam(name = "idAntecedent") int idAntecedent,
                                                 @RequestParam(name = "idLanguage") int idLanguage){
        return antecedentService.linkAntecedentAndLanguage(idAntecedent, idLanguage);
    }

    @PostMapping(path = "/linkItem")
    public ApiResponse linkAntecedentAndItem(@RequestParam(name = "idAntecedent") int idAntecedent,
                                             @RequestParam(name = "idItem") int idItem){
        return antecedentService.linkAntecedentAndItem(idAntecedent, idItem);
    }
}

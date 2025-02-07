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

    @PostMapping(path = "/linkProficiency")
    public ApiResponse linkAntecedentAndProficiency(@RequestParam(name = "idAntecedent") int idAntecedent,
                                                    @RequestParam(name = "idProficiency") int idProficiency){
        return antecedentService.linkAntecedentAndProficiency(idAntecedent, idProficiency);
    }

    @PostMapping(path = "/linkAntecedentCharacteristic")
    public ApiResponse linkAntecedentAndAntecedentCharacteristic(@RequestParam(name = "idAntecedent") int idAntecedent,
                                                    @RequestParam(name = "idAntecedentCharacteristic") int idAntecedentCharacteristic){
        return antecedentService.linkAntecedentAndAntecedentCharacteristic(idAntecedent, idAntecedentCharacteristic);
    }
}

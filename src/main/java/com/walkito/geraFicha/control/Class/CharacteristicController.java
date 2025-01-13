package com.walkito.geraFicha.control.Class;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.Characteristic.Characteristic;
import com.walkito.geraFicha.service.Class.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/characteristic")
public class CharacteristicController {
    @Autowired
    private CharacteristicService characteristicService;

    @PostMapping
    public ApiResponse createCharacteristic(@RequestBody Characteristic  characteristic){
        return characteristicService.createCharacteristic(characteristic);
    }

    @PostMapping(path = "/linkProficiency")
    public ApiResponse linkCharacteristicAndProficiency(@RequestParam(name = "idCharacteristic") int idCharacteristic,
                                                      @RequestParam(name = "idProficiency") int idProficiency){
        return characteristicService.linkCharacteristicAndProficiency(idCharacteristic, idProficiency);
    }

    @PostMapping(path = "/linkLevel")
    public ApiResponse linkCharacteriscticAndLevel(@RequestParam(name = "idCharacteristic") int idCharacteristic,
                                                   @RequestParam(name = "idLevel") int idLevel){
        return characteristicService.linkCharacteristicAndLevel(idCharacteristic, idLevel);
    }
}

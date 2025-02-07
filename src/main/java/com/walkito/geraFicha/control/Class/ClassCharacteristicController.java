package com.walkito.geraFicha.control.Class;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristic;
import com.walkito.geraFicha.service.Class.ClassCharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/characteristic")
public class ClassCharacteristicController {
    @Autowired
    private ClassCharacteristicService classCharacteristicService;

    @PostMapping
    public ApiResponse createCharacteristic(@RequestBody ClassCharacteristic classCharacteristic){
        return classCharacteristicService.createCharacteristic(classCharacteristic);
    }

    @PostMapping(path = "/linkProficiency")
    public ApiResponse linkCharacteristicAndProficiency(@RequestParam(name = "idCharacteristic") int idCharacteristic,
                                                      @RequestParam(name = "idProficiency") int idProficiency){
        return classCharacteristicService.linkCharacteristicAndProficiency(idCharacteristic, idProficiency);
    }

    @PostMapping(path = "/linkLevel")
    public ApiResponse linkCharacteriscticAndLevel(@RequestParam(name = "idCharacteristic") int idCharacteristic,
                                                   @RequestParam(name = "idLevel") int idLevel){
        return classCharacteristicService.linkCharacteristicAndLevel(idCharacteristic, idLevel);
    }
}

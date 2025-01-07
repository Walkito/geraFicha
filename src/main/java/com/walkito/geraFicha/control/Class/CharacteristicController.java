package com.walkito.geraFicha.control.Class;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.Characteristic.Characteristic;
import com.walkito.geraFicha.service.Class.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/characteristic")
public class CharacteristicController {
    @Autowired
    private CharacteristicService characteristicService;

    @PostMapping
    public ApiResponse createCharacteristic(@RequestBody Characteristic  characteristic){
        return characteristicService.createCharacteristic(characteristic);
    }


}

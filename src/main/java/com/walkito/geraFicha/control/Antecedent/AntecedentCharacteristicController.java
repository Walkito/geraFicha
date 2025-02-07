package com.walkito.geraFicha.control.Antecedent;

import com.walkito.geraFicha.model.Antecedent.AntecedentCharacteristic.AntecedentCharacteristic;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.service.Antecedent.AntecedentCharacteristicService;
import com.walkito.geraFicha.service.Antecedent.AntecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/antecedentCharacteristic")
public class AntecedentCharacteristicController {
    @Autowired
    private AntecedentCharacteristicService antecedentCharacteristicService;

    @PostMapping
    public ApiResponse createAntecedent(@RequestBody AntecedentCharacteristic antecedentCharacteristic){
        return antecedentCharacteristicService.createAntecedentCharacteristic(antecedentCharacteristic);
    }
}

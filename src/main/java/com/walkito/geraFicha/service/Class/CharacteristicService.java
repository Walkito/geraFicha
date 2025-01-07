package com.walkito.geraFicha.service.Class;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.Characteristic.Characteristic;
import com.walkito.geraFicha.model.Class.Characteristic.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicService {
    @Autowired
    private CharacteristicRepository characteristicRepository;

    public ApiResponse createCharacteristic(Characteristic characteristic){
        try{
            return new ApiResponse(
                    "Característica criada com sucesso",
                    characteristicRepository.save(characteristic),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

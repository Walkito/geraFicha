package com.walkito.geraFicha.service.Antecedent;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.Antecedent.AntecedentCharacteristic.AntecedentCharacteristic;
import com.walkito.geraFicha.model.Antecedent.AntecedentCharacteristic.AntecedentCharacteristicRepository;
import com.walkito.geraFicha.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AntecedentCharacteristicService {
    @Autowired
    private AntecedentCharacteristicRepository antecedentCharacteristicRepository;

    public ApiResponse createAntecedentCharacteristic(AntecedentCharacteristic antecedentCharacteristic) {
        try {
            return new ApiResponse(
                    "Caracteristica criada com sucesso",
                    antecedentCharacteristicRepository.save(antecedentCharacteristic),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }

}

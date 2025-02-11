package com.walkito.geraFicha.service.Antecedent;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.Antecedent.AntecedentCharacteristic.AntecedentCharacteristic;
import com.walkito.geraFicha.model.Antecedent.AntecedentCharacteristic.AntecedentCharacteristicRepository;
import com.walkito.geraFicha.model.Antecedent.AntecedentRepository;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Item.Item;
import com.walkito.geraFicha.model.Item.ItemRepository;
import com.walkito.geraFicha.model.Language.Language;
import com.walkito.geraFicha.model.Language.LanguageRepository;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import com.walkito.geraFicha.model.Proficiency.ProficiencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class    AntecedentService {

    @Autowired
    private AntecedentRepository antecedentRepository;

    public ApiResponse getAllAntecedents(){
        try{
            return new ApiResponse(
                    "Antecedentes encontrados",
                    antecedentRepository.findAll(),
                    HttpStatus.OK.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

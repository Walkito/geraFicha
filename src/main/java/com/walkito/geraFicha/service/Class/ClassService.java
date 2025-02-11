package com.walkito.geraFicha.service.Class;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristic;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristicRepository;
import com.walkito.geraFicha.model.Class.Class;
import com.walkito.geraFicha.model.Class.ClassRepository;
import com.walkito.geraFicha.model.Class.SubClass.SubClass;
import com.walkito.geraFicha.model.Class.SubClass.SubClassRepository;
import com.walkito.geraFicha.model.Item.Item;
import com.walkito.geraFicha.model.Item.ItemRepository;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import com.walkito.geraFicha.model.Proficiency.ProficiencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public ApiResponse getAllClasses(){
        try{
            return new ApiResponse(
                    "Classes encontradas:",
                    classRepository.findAll(),
                    HttpStatus.OK.value()
            );
        } catch(Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

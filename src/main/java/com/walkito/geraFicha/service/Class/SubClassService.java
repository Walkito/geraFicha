package com.walkito.geraFicha.service.Class;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristic;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristicRepository;
import com.walkito.geraFicha.model.Class.SubClass.SubClass;
import com.walkito.geraFicha.model.Class.SubClass.SubClassRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SubClassService {
    @Autowired
    SubClassRepository subClassRepository;

    @Autowired
    ClassCharacteristicRepository classCharacteristicRepository;

    public ApiResponse createSubClass(SubClass subClass){
        try{
            return new ApiResponse(
                    "Sub Classe criada com sucesso.",
                    subClassRepository.save(subClass),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkSubClassAndCharacteristic(int idSubClass, int idCharacteristic){
        try {
            SubClass subClass = subClassRepository.findById(idSubClass).orElseThrow(() -> new EntityNotFoundException("Sub Classe não achada"));
            ClassCharacteristic classCharacteristic = classCharacteristicRepository.findById(idCharacteristic).orElseThrow(() -> new EntityNotFoundException("Caracteristica não encontrada"));

            subClass.getCharacteristics().add(classCharacteristic);
            classCharacteristic.getSubClasses().add(subClass);

            subClassRepository.save(subClass);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

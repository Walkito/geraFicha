package com.walkito.geraFicha.service.Class;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.Characteristic.Characteristic;
import com.walkito.geraFicha.model.Class.Characteristic.CharacteristicRepository;
import com.walkito.geraFicha.model.Class.Class;
import com.walkito.geraFicha.model.Class.ClassRepository;
import com.walkito.geraFicha.model.Class.SubClass.SubClass;
import com.walkito.geraFicha.model.Class.SubClass.SubClassRepository;
import com.walkito.geraFicha.model.Item.Item;
import com.walkito.geraFicha.model.Item.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubClassRepository subClassRepository;

    @Autowired
    private CharacteristicRepository characteristicRepository;

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

    public ApiResponse createClass(Class _class){
        try{
            return new ApiResponse(
                    "Classe criada com sucesso",
                    classRepository.save(_class),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkClassAndItem(int idClass, int idItem){
        try {
            Class _class = classRepository.findById(idClass).orElseThrow(() -> new EntityNotFoundException("Classe não encontrada"));
            Item item = itemRepository.findById(idItem).orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));

            _class.getItens().add(item);
            item.getClasses().add(_class);

            classRepository.save(_class);

            return Utils.getDefaultLinkResponse();
        } catch(Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkClassAndSubClass(int idClass, int idSubClass){
        try {
            Class _class = classRepository.findById(idClass).orElseThrow(() -> new EntityNotFoundException("Classe não encontrada"));
            SubClass subClass = subClassRepository.findById(idSubClass).orElseThrow(() -> new EntityNotFoundException("Sub Classe não encontrada"));

            _class.getSubClasses().add(subClass);
            subClass.getClasses().add(_class);

            classRepository.save(_class);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkClassAndCharacteristic(int idClass, int idCharacteristic){
        try{
            Class _class = classRepository.findById(idClass).orElseThrow(() -> new EntityNotFoundException("Classe não encontrada"));
            Characteristic characteristic = characteristicRepository.findById(idCharacteristic).orElseThrow(() -> new EntityNotFoundException("Caracteristica não encontrada"));

            _class.getCharacteristics().add(characteristic);
            characteristic.getClasses().add(_class);

            classRepository.save(_class);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

package com.walkito.geraFicha.service.Class;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristic;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristicRepository;
import com.walkito.geraFicha.model.Level.Level;
import com.walkito.geraFicha.model.Level.LevelRepository;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import com.walkito.geraFicha.model.Proficiency.ProficiencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClassCharacteristicService {
    @Autowired
    private ClassCharacteristicRepository classCharacteristicRepository;

    @Autowired
    private ProficiencyRepository proficiencyRepository;

    @Autowired
    private LevelRepository levelRepository;

    public ApiResponse createCharacteristic(ClassCharacteristic classCharacteristic){
        try{
            return new ApiResponse(
                    "Característica criada com sucesso",
                    classCharacteristicRepository.save(classCharacteristic),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkCharacteristicAndProficiency(int idCharacteristic, int idProficiency){
        try{
            ClassCharacteristic classCharacteristic = classCharacteristicRepository.findById(idCharacteristic).orElseThrow(() -> new EntityNotFoundException("Característica não encontrada"));
            Proficiency proficiency = proficiencyRepository.findById(idProficiency).orElseThrow(() -> new EntityNotFoundException("Proficiencia não encontrada"));

            classCharacteristic.getProficiencies().add(proficiency);
            proficiency.getCharacteristics().add(classCharacteristic);

            classCharacteristicRepository.save(classCharacteristic);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkCharacteristicAndLevel(int idCharacteristic, int idLevel){
        try{
            ClassCharacteristic classCharacteristic = classCharacteristicRepository.findById(idCharacteristic).orElseThrow(() -> new EntityNotFoundException("Característica não encontrada"));
            Level level = levelRepository.findById(idLevel).orElseThrow(() -> new EntityNotFoundException("Level não encontrado"));

            classCharacteristic.getLevels().add(level);
            level.getCharacteristics().add(classCharacteristic);

            classCharacteristicRepository.save(classCharacteristic);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

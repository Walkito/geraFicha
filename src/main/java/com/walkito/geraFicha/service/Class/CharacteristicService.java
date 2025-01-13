package com.walkito.geraFicha.service.Class;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.Characteristic.Characteristic;
import com.walkito.geraFicha.model.Class.Characteristic.CharacteristicRepository;
import com.walkito.geraFicha.model.Level.Level;
import com.walkito.geraFicha.model.Level.LevelRepository;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import com.walkito.geraFicha.model.Proficiency.ProficiencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicService {
    @Autowired
    private CharacteristicRepository characteristicRepository;

    @Autowired
    private ProficiencyRepository proficiencyRepository;

    @Autowired
    private LevelRepository levelRepository;

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

    public ApiResponse linkCharacteristicAndProficiency(int idCharacteristic, int idProficiency){
        try{
            Characteristic characteristic = characteristicRepository.findById(idCharacteristic).orElseThrow(() -> new EntityNotFoundException("Característica não encontrada"));
            Proficiency proficiency = proficiencyRepository.findById(idProficiency).orElseThrow(() -> new EntityNotFoundException("Proficiencia não encontrada"));

            characteristic.getProficiencies().add(proficiency);
            proficiency.getCharacteristics().add(characteristic);

            characteristicRepository.save(characteristic);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkCharacteristicAndLevel(int idCharacteristic, int idLevel){
        try{
            Characteristic characteristic = characteristicRepository.findById(idCharacteristic).orElseThrow(() -> new EntityNotFoundException("Característica não encontrada"));
            Level level = levelRepository.findById(idLevel).orElseThrow(() -> new EntityNotFoundException("Level não encontrado"));

            characteristic.getLevels().add(level);
            level.getCharacteristics().add(characteristic);

            characteristicRepository.save(characteristic);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

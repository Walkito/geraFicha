package com.walkito.geraFicha.service.Race;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Language.Language;
import com.walkito.geraFicha.model.Language.LanguageRepository;
import com.walkito.geraFicha.model.Race.Race;
import com.walkito.geraFicha.model.Race.RaceRepository;
import com.walkito.geraFicha.model.Race.Trait.Trait;
import com.walkito.geraFicha.model.Race.Trait.TraitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    public ApiResponse getAllRaces() {
        try {
            List<Race> races = raceRepository.findAll();

            return new ApiResponse(
                    "Raças encontradas com sucesso!",
                    races,
                    HttpStatus.OK.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse getRaceById(int id) {
        try {
            Optional<Race> race = raceRepository.findById(id);

            return race.map(value -> new ApiResponse(
                    "Raça encontrada",
                    value,
                    HttpStatus.OK.value()
            )).orElseGet(() -> new ApiResponse(
                    "Raça não encontrada",
                    null,
                    HttpStatus.NOT_FOUND.value()
            ));
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }
}

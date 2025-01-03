package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
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

    @Autowired
    private TraitRepository traitRepository;

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

    public ApiResponse createRace(Race race) {
        try {

            return new ApiResponse(
                    "Raça criada com sucesso",
                    raceRepository.save(race),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkRaceAndTrait(int idRace, int idTrait) {
        try {
            Race race = raceRepository.findById(idRace).orElseThrow(() -> new EntityNotFoundException("Nenhuma raça encontrada com este ID: " + idRace));
            Trait trait = traitRepository.findById(idTrait).orElseThrow(() -> new EntityNotFoundException("Nenhum traço encontrado com este ID: " + idTrait));

            race.getTraits().add(trait);
            trait.getRaces().add(race);

            raceRepository.save(race);

            return new ApiResponse(
                    "Vínculo realizado com sucesso.",
                    null,
                    HttpStatus.OK.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }
}

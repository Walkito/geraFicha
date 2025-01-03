package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Race.Race;
import com.walkito.geraFicha.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/race")
public class RaceController {
    @Autowired
    RaceService raceService;

    @GetMapping(path = "/")
    public ApiResponse getRaceById(@RequestParam(name = "id") int id){
        return raceService.getRaceById(id);
    }

    @GetMapping
    public ApiResponse getAllRaces(){
        return raceService.getAllRaces();
    }

    @PostMapping
    public ApiResponse createRace(@RequestBody Race race){
        return raceService.createRace(race);
    }

    @PostMapping(path = "/link")
    public ApiResponse linkRaceAndTrait(@RequestParam(name = "idRace") int idRace,
                                        @RequestParam(name = "idTrait") int idTrait){
        return raceService.linkRaceAndTrait(idRace, idTrait);
    }
}

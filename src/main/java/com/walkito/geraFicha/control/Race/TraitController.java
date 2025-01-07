package com.walkito.geraFicha.control.Race;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Race.Trait.Trait;
import com.walkito.geraFicha.service.Race.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/trait")
public class TraitController {
    @Autowired
    private TraitService traitService;

    @PostMapping
    public ApiResponse createTrait(@RequestBody Trait trait){
        return traitService.createTrait(trait);
    }


}

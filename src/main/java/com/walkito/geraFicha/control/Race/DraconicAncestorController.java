package com.walkito.geraFicha.control.Race;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Race.Trait.DraconicAncestor.DraconicAncestor;
import com.walkito.geraFicha.service.Race.DraconicAncestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/draconicAncestor")
public class DraconicAncestorController {
    @Autowired
    private DraconicAncestorService draconicAncestorService;

    @PostMapping
    public ApiResponse createDraconicAncestor(@RequestBody DraconicAncestor draconicAncestor){
        return draconicAncestorService.createDraconicAncestor(draconicAncestor);
    }
}

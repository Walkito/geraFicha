package com.walkito.geraFicha.control.Class;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.SubClass.SubClass;
import com.walkito.geraFicha.service.Class.SubClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subClass")
public class SubClassController {
    @Autowired
    private SubClassService subClassService;

    @PostMapping
    public ApiResponse createSubClass(@RequestBody SubClass subClass){
        return subClassService.createSubClass(subClass);
    }

    @PostMapping(path = "/linkCharacteristic")
    public ApiResponse linkSubClassAndCharacteristic(@RequestParam(name = "idSubClass") int idSubClass,
                                                     @RequestParam(name = "idCharacteristic") int idCharacteristic){
        return subClassService.linkSubClassAndCharacteristic(idSubClass, idCharacteristic);
    }
}

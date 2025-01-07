package com.walkito.geraFicha.control.Class;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.Class;
import com.walkito.geraFicha.service.Class.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public ApiResponse getAllClasses(){
        return classService.getAllClasses();
    }

    @PostMapping
    public ApiResponse createClass(@RequestBody Class _class){
        return classService.createClass(_class);
    }

    @PostMapping(path = "/linkItem")
    public ApiResponse linkClassAndItem(@RequestParam(name = "idClass") int idClass,
                                        @RequestParam(name = "idItem") int idItem){
        return classService.linkClassAndItem(idClass, idItem);
    }

    @PostMapping(path = "/linkSubClass")
    public ApiResponse linkClassAndSubClass(@RequestParam(name = "idClass") int idClass,
                                            @RequestParam(name = "idSubClass") int idSubClass){
        return classService.linkClassAndSubClass(idClass, idSubClass);
    }

    @PostMapping(path = "/linkCharacteristic")
    public ApiResponse linkClassAndCharacteristic(@RequestParam(name = "idClass") int idClass,
                                                  @RequestParam(name = "idCharacteristic") int idCharacteristic){
        return classService.linkClassAndCharacteristic(idClass, idCharacteristic);
    }
}

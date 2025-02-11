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
}

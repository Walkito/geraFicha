package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Magic.Magic;
import com.walkito.geraFicha.service.MagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/magic")
public class MagicController {
    @Autowired
    private MagicService magicService;

    @PostMapping
    public ApiResponse createMagic(@RequestBody Magic magic){
        return magicService.createMagic(magic);
    }

    @PostMapping(path = "/linkClass")
    public ApiResponse linkMagicAndClass(@RequestParam(name = "idMagic") int idMagic,
                                         @RequestParam(name = "idClass") int idClass){
        return magicService.linkMagicAndClass(idMagic, idClass);
    }
}

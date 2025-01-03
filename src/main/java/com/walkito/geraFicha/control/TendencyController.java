package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Tendency.Tendency;
import com.walkito.geraFicha.service.TendencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tendency")
public class TendencyController {
    @Autowired
    TendencyService tendencyService;

    @GetMapping(path = "/")
    public ApiResponse getOneTendency(@RequestParam(name = "id") int id){
        return tendencyService.getTendencyById(id);
    }

    @GetMapping
    public ApiResponse getTendencys(){
        return tendencyService.getAllTendency();
    }

    @PostMapping
    public ApiResponse createTendency(@RequestBody Tendency tendency){
        return tendencyService.createTendency(tendency);
    }
}

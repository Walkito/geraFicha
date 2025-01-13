package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Level.Level;
import com.walkito.geraFicha.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @PostMapping
    public ApiResponse createLevel(@RequestBody Level level){
        return levelService.createLevel(level);
    }
}

package com.walkito.geraFicha.control;

import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Language.Language;
import com.walkito.geraFicha.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @PostMapping
    public ApiResponse createLanguage(@RequestBody Language language){
        return languageService.createLanguage(language);
    }
}

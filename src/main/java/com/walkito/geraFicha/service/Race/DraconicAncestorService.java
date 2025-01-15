package com.walkito.geraFicha.service.Race;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Race.Trait.DraconicAncestor.DraconicAncestor;
import com.walkito.geraFicha.model.Race.Trait.DraconicAncestor.DraconicAncestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DraconicAncestorService {
    @Autowired
    DraconicAncestorRepository draconicAncestorRepository;

    public ApiResponse createDraconicAncestor(DraconicAncestor draconicAncestor){
        try{
            return new ApiResponse(
                    "Ancestral Dracônico criado com sucesso",
                    draconicAncestorRepository.save(draconicAncestor),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }
}

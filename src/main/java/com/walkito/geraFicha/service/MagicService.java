package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Class.Class;
import com.walkito.geraFicha.model.Class.ClassRepository;
import com.walkito.geraFicha.model.Magic.Magic;
import com.walkito.geraFicha.model.Magic.MagicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagicService {
    @Autowired
    private MagicRepository magicRepository;

    @Autowired
    private ClassRepository classRepository;

    public ApiResponse createMagic(List<Magic> magics) {
        try {
            return new ApiResponse(
                    "Magia criada com sucesso.",
                    magicRepository.saveAll(magics),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkMagicAndClass(int idMagic, int idClass){
        try{
            Magic magic = magicRepository.findById(idMagic).orElseThrow(() -> new EntityNotFoundException("Magia não encontrada"));
            Class _class = classRepository.findById(idClass).orElseThrow(() -> new EntityNotFoundException("Classe não encontrada"));

            magic.getClasses().add(_class);
            _class.getMagics().add(magic);

            magicRepository.save(magic);

            return Utils.getDefaultLinkResponse();
        }catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

}

package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.Antecedent.AntecedentRepository;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Item.Item;
import com.walkito.geraFicha.model.Item.ItemRepository;
import com.walkito.geraFicha.model.Language.Language;
import com.walkito.geraFicha.model.Language.LanguageRepository;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import com.walkito.geraFicha.model.Proficiency.ProficiencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class    AntecedentService {

    @Autowired
    private AntecedentRepository antecedentRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProficiencyRepository proficiencyRepository;

    public ApiResponse getAllAntecedents(){
        try{
            return new ApiResponse(
                    "Antecedentes encontrados",
                    antecedentRepository.findAll(),
                    HttpStatus.OK.value()
            );
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse createAntecedent(Antecedent antecedent) {
        try {
            return new ApiResponse(
                    "Antecedente criado com sucesso",
                    antecedentRepository.save(antecedent),
                    HttpStatus.CREATED.value()
            );
        } catch (Exception e) {
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkAntecedentAndLanguage(int idAntecedent, int idLanguage){
        try{
            Antecedent antecedent = antecedentRepository.findById(idAntecedent).orElseThrow(() -> new EntityNotFoundException("Antecedente não encontrado"));
            Language language = languageRepository.findById(idLanguage).orElseThrow(() -> new EntityNotFoundException("Idioam não encontrado"));

            antecedent.getLanguages().add(language);
            language.getAntecedents().add(antecedent);

            antecedentRepository.save(antecedent);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkAntecedentAndItem(int idAntecedent, int idItem){
        try{
            Antecedent antecedent = antecedentRepository.findById(idAntecedent).orElseThrow(() -> new EntityNotFoundException("Antecedente não encontrado"));
            Item item = itemRepository.findById(idItem).orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));

            antecedent.getItens().add(item);
            item.getAntecedents().add(antecedent);

            antecedentRepository.save(antecedent);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

    public ApiResponse linkAntecedentAndProficiency(int idAntecedent, int idProficiency){
        try{
            Antecedent antecedent = antecedentRepository.findById(idAntecedent).orElseThrow(() -> new EntityNotFoundException("Antecedente não encontrado"));
            Proficiency proficiency = proficiencyRepository.findById(idProficiency).orElseThrow(() -> new EntityNotFoundException("Proficiencia não encontrada"));

            antecedent.getProficiencies().add(proficiency);
            proficiency.getAntecedents().add(antecedent);

            antecedentRepository.save(antecedent);

            return Utils.getDefaultLinkResponse();
        } catch (Exception e){
            return Utils.getDefaultLinkResponse();
        }
    }
}

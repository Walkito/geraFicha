package com.walkito.geraFicha.service;

import com.walkito.geraFicha.config.Utils;
import com.walkito.geraFicha.model.ApiResponse;
import com.walkito.geraFicha.model.Item.Item;
import com.walkito.geraFicha.model.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public ApiResponse createItem(Item item){
        try{
            return new ApiResponse(
                    "Item criado com sucesso",
                    itemRepository.save(item),
                    HttpStatus.CREATED.value()
            );

        } catch (Exception e){
            return Utils.getDefaultInternalError(e);
        }
    }

}

package com.stencil.markups.Services;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Repositories.ItemRepository;
import com.stencil.markups.Services.Interfaces.SpreadsheetServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpreadsheetService implements SpreadsheetServiceIF {

    @Autowired
    private ItemRepository itemRepository;

    //TODO: Honestly not even sure if this logic works or is how i should be doing but YOLO

    //populate spreadsheet
    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    //updates
    public void updateName(int id, String name) throws ResourceNotFoundException {
        //TODO: create new exception
        Item uItem = itemRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        uItem.setName(name);
        itemRepository.save(uItem);
    }

    public void updateWidth(int id, int val) throws ResourceNotFoundException {
        Item uItem = itemRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        uItem.setWidth(val);
        uItem.setArea(uItem.getHeight()*uItem.getWidth());
        itemRepository.save(uItem);
    }

    public void updateHeight(int id, int val) throws ResourceNotFoundException {
        Item uItem = itemRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        uItem.setHeight(val);
        uItem.setArea(uItem.getHeight()*uItem.getWidth());

        itemRepository.save(uItem);
    }

    public void updateNos(int id, int val) throws ResourceNotFoundException {
        Item uItem = itemRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        uItem.setNos(val);

        itemRepository.save(uItem);
    }

}

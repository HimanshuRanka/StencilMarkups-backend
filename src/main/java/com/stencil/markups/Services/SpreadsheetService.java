package com.stencil.markups.Services;

import com.stencil.markups.Models.Item;
import com.stencil.markups.Repositories.ItemRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpreadsheetService implements SpreadsheetServiceIF{

    @Autowired
    private ItemRepository itemRepository;

    //TODO: Honestly not even sure if this logic works or is how i should be doing but YOLO
    public void addNewRow(){
        Item newItem = new Item();
        itemRepository.save(newItem);
    }

    public void updateName(int id, String name){
        Item uItem = itemRepository.findById(id).get();
        uItem.setName(name);
    }

    public void updateWidth(int id, int val){
        Item uItem = itemRepository.findById(id).get();
        uItem.setWidth(val);
        uItem.setArea(uItem.getHeight()*uItem.getWidth());
    }

    public void updateHeight(int id, int val) {
        Item uItem = itemRepository.findById(id).get();
        uItem.setHeight(val);
        uItem.setArea(uItem.getHeight()*uItem.getWidth());
    }

    public void updateNos(int id, int val) {
        Item uItem = itemRepository.findById(id).get();
        uItem.setNos(val);
    }

}

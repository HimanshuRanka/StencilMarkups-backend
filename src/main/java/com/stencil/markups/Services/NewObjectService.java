package com.stencil.markups.Services;

import com.stencil.markups.Models.House;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Models.Room;
import com.stencil.markups.Repositories.HouseRepository;
import com.stencil.markups.Repositories.ItemRepository;
import com.stencil.markups.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewObjectService implements NewObjectServiceIF {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public void addNewRow(int roomID) {
        Item item = new Item();
        itemRepository.save(item);
        roomRepository.findById(roomID).get().addItem(item);
    }

    @Override
    public void addNewRoom(int houseID) {
        Room room = new Room();
        roomRepository.save(room);
        houseRepository.findById(houseID).get().addRoom(room);
    }

    @Override
    public void addNewHouse() {
        houseRepository.save(new House());
    }
}

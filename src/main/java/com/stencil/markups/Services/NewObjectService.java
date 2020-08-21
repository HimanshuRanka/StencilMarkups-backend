package com.stencil.markups.Services;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.House;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Models.Room;
import com.stencil.markups.Repositories.HouseRepository;
import com.stencil.markups.Repositories.ItemRepository;
import com.stencil.markups.Repositories.RoomRepository;
import com.stencil.markups.Services.Interfaces.NewObjectServiceIF;
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
    public void addNewRow(int roomID) throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomID)
                .orElseThrow(ResourceNotFoundException::new);

        Item item = new Item();
        item.setRoom(room);
        room.getItems().add(item);

        itemRepository.save(item);
        roomRepository.save(room);
    }

    @Override
    public void addNewRoom(int houseID) throws ResourceNotFoundException {
        House house = houseRepository.findById(houseID)
                .orElseThrow(ResourceNotFoundException::new);

        Room room = new Room();
        room.setHouse(house);
        house.getRooms().add(room);

        roomRepository.save(room);
        houseRepository.save(house);
    }

    @Override
    public void addNewHouse() {
        houseRepository.save(new House());
    }
}

package com.stencil.markups.Services;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.House;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Models.Room;
import com.stencil.markups.Repositories.HouseRepository;
import com.stencil.markups.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SetAccessService implements com.stencil.markups.Services.Interfaces.SetAccessServiceIF {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HouseRepository houseRepository;

    //populate spreadsheet
    @Override
    public List<Item> getItems(@RequestBody int room_id) throws ResourceNotFoundException {
        Room room = roomRepository.findById(room_id).
                orElseThrow(ResourceNotFoundException::new);
        return room.getItems();
    }

    @Override
    public List<Room> getRooms(@RequestBody int house_id) throws ResourceNotFoundException {
        House house = houseRepository.findById(house_id).
                orElseThrow(ResourceNotFoundException::new);
        return house.getRooms();
    }

    @Override
    public List<House> getHouses(){
        return houseRepository.findAll();
    }


}

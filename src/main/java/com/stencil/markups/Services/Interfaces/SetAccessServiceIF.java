package com.stencil.markups.Services.Interfaces;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.House;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Models.Room;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SetAccessServiceIF {
    //populate spreadsheet
    List<Item> getItems(@RequestBody int room_id) throws ResourceNotFoundException;

    List<Room> getRooms(@RequestBody int house_id) throws ResourceNotFoundException;

    List<House> getHouses();
}

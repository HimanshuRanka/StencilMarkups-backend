package com.stencil.markups.Controllers;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Models.Room;
import com.stencil.markups.Services.NewObjectService;
import com.stencil.markups.Services.SetAccessService;
import com.stencil.markups.Services.SpreadsheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private NewObjectService objects;

    @Autowired
    private SetAccessService lists;

    @GetMapping(value = "/{house_id}/rooms")
    public List<Room> SetOfRooms(@PathVariable int house_id) throws ResourceNotFoundException {
        return lists.getRooms(house_id);
    }

    //addRoom
    @PostMapping(value = "/{house_id}/addroom")
    public ResponseEntity<String> addRoom(@PathVariable int house_id){
        //TODO: must change this to env variable conf
        try{
            objects.addNewRoom(house_id);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

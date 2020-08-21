package com.stencil.markups.Controllers;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.House;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Services.NewObjectService;
import com.stencil.markups.Services.SetAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouseController {

    @Autowired
    private NewObjectService objects;

    @Autowired
    private SetAccessService lists;

    @GetMapping(value = "/houses")
    public List<House> populateSpreadsheet() throws ResourceNotFoundException {
        return lists.getHouses();
    }

    //addRoom
    @PostMapping(value = "/addhouse")
    public ResponseEntity<String> addHouse(){
        //TODO: must change this to env variable conf
        try{
            objects.addNewHouse();
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

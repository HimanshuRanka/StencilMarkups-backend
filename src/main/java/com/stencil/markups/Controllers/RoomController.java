package com.stencil.markups.Controllers;

import com.stencil.markups.Services.NewObjectService;
import com.stencil.markups.Services.SpreadsheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private NewObjectService objects;

    //addRoom
    @PostMapping(value = "/addroom")
    public ResponseEntity<String> addRoom(){
        //TODO: must change this to env variable conf
        try{
            objects.addNewRoom(1);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

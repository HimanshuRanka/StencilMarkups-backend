package com.stencil.markups.Controllers;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.Item;
import com.stencil.markups.Services.NewObjectService;
import com.stencil.markups.Services.SetAccessService;
import com.stencil.markups.Services.SpreadsheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpreadsheetController {

    @Autowired
    private SpreadsheetService spreadsheet;

    @Autowired
    private NewObjectService objects;

    @Autowired
    private SetAccessService lists;

    @GetMapping(value = "/{room_id}/items")
    public List<Item> populateSpreadsheet(@PathVariable int room_id) throws ResourceNotFoundException {
        return lists.getItems(room_id);
    }

    @PostMapping(value = "/{room_id}/addrow")
    public ResponseEntity<String> newRow(@PathVariable int room_id){
        try{
            //TODO: change the sent var to the room from the session env which i sti have to figure out how to set
            //It is potentially done in the frontend and then sent to the backend possibly using the request body
            objects.addNewRow(room_id);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/updateName/{id}/{name}")
    public ResponseEntity<String> updateName(@PathVariable(value = "id") int id, @PathVariable(value = "name") String name){
        try{
            spreadsheet.updateName(id, name);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/updateWidth/{id}/{width}")
    public ResponseEntity<String> updateWidth(@PathVariable(value = "width") int width, @PathVariable(value = "id") int id){
        try{
            spreadsheet.updateWidth(id, width);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/updateHeight/{id}/{height}")
    public ResponseEntity<String> updateHeight(@PathVariable(value = "height") int height, @PathVariable(value = "id") int id){
        try{
            spreadsheet.updateHeight(id, height);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/updateNos/{id}/{nos}")
    public ResponseEntity<String> updateNos(@PathVariable(value = "nos") int nos, @PathVariable(value = "id") int id){
        try{
            spreadsheet.updateNos(id, nos);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

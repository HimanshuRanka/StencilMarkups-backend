package com.stencil.markups.Controllers;

import com.stencil.markups.Services.SpreadsheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpreadsheetController {

    @Autowired
    private SpreadsheetService spreadsheet;

    @PostMapping(value = "/addrow")
    public ResponseEntity<String> newRow(){
        try{
            spreadsheet.addNewRow();
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateName/{id}/{name}")
    public ResponseEntity<String> updateName(@PathVariable String name, @PathVariable int id){
        try{
            spreadsheet.updateName(id, name);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateWidth/{id}/{width}")
    public ResponseEntity<String> updateWidth(@PathVariable int width, @PathVariable int id){
        try{
            spreadsheet.updateField(id, "width", width);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateHeight/{id}/{height}")
    public ResponseEntity<String> updateHeight(@PathVariable int height, @PathVariable int id){
        try{
            spreadsheet.updateField(id, "height", height);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateNos/{id}/{nos}")
    public ResponseEntity<String> updateNos(@PathVariable int nos, @PathVariable int id){
        try{
            spreadsheet.updateField(id, "nos", nos);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

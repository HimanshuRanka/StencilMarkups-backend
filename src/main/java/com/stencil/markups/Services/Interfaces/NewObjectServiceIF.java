package com.stencil.markups.Services.Interfaces;

import com.stencil.markups.Exceptions.ResourceNotFoundException;
import com.stencil.markups.Models.House;
import com.stencil.markups.Models.Room;

public interface NewObjectServiceIF {

    public void addNewRow(int roomID) throws ResourceNotFoundException;

    public void addNewRoom(int houseID) throws ResourceNotFoundException;

    public void addNewHouse();

}

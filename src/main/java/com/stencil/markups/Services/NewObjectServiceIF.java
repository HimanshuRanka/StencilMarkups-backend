package com.stencil.markups.Services;

import com.stencil.markups.Models.House;
import com.stencil.markups.Models.Room;

public interface NewObjectServiceIF {

    public void addNewRow(int roomID);

    public void addNewRoom(int houseID);

    public void addNewHouse();

}

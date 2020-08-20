package com.stencil.markups.Services.Interfaces;

import com.stencil.markups.Exceptions.ResourceNotFoundException;

public interface SpreadsheetServiceIF {
    public void updateName(int id, String name) throws ResourceNotFoundException;

    public void updateWidth(int id, int val) throws ResourceNotFoundException;

    public void updateHeight(int id, int val) throws ResourceNotFoundException;

    public void updateNos(int id, int val) throws ResourceNotFoundException;

}
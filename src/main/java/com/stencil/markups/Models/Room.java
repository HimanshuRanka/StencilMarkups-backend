package com.stencil.markups.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Room {

    @Id
    @Column(name = "room_index")
    private int room;

    @Column(name = "room_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "House_id")
    private House house;

    @OneToMany(mappedBy = "room")
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public Room(){}

    public Room(String name) {
        this.name = name;
    }
}

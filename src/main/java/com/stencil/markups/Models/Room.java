package com.stencil.markups.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_index")
    private int room;

    @Column(name = "room_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "House")
    private House house;

    @OneToMany(mappedBy = "room")
    private List<Item> items = new ArrayList<>();

    public Room(){}

    public Room(String name) {
        this.name = name;
    }
}
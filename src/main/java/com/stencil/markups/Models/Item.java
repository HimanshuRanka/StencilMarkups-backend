package com.stencil.markups.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_index")
    private int item;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "req_width")
    private int width;

    @Column(name = "req_height")
    private int height;

    @Column(name = "quantity")
    private int nos;

    @Transient
    private int area;

    @ManyToOne
    @JoinColumn(name = "room")
    private Room room;

    public Item(){}

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Integer width, Integer height, Integer nos) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.nos = nos;
    }

    @JsonIgnore
    public Room getRoom() {
        return room;
    }

    @JsonIgnore
    public void setRoom(Room room) {
        this.room = room;
    }
}

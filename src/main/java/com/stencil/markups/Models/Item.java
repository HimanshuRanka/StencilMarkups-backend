package com.stencil.markups.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @Id
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
    @JoinColumn(name = "room_id")
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
}

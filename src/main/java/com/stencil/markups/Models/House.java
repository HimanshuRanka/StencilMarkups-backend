package com.stencil.markups.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "houses")
public @Data class House {
    //TODO: for all models, change primary key to an autogenerated id, and also choose type of generation after research
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "house_index")
    private int house;

    @Column(name = "house_name")
    private String name;

    @OneToMany(mappedBy = "house")
    private List<Room> rooms = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "users")
    private User user;

    public House(){}

    public House(String name) {
        this.name = name;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }
}
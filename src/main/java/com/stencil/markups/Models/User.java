package com.stencil.markups.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "userID")
    @GeneratedValue
    private int userId;

    @OneToMany(mappedBy = "user")
    private List<House> houses = new ArrayList<>();

    public User() {}
}

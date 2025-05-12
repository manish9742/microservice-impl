package com.eapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    private String about;

    @Transient
    private List<Ratings> ratings=new ArrayList<>();

}

package com.blt.manager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group")
public class Group implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGoup;

    @Column(name = "name")
    private String name;

}

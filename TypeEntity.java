package com.redwoodgroup.petstore.dbmodel;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "type")
public class TypeEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_id_seq")
    @SequenceGenerator(name = "type_id_seq", sequenceName = "type_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "type")
    private List<PetEntity> pet;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PetEntity> getPet() {
        return pet;
    }

    public void setPet(List<PetEntity> pet) {
        this.pet = pet;
    }
}

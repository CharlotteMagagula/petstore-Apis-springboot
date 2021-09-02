package com.redwoodgroup.petstore.dbmodel;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "visit")
public class VisitEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visit_id_seq")
    @SequenceGenerator(name = "visit_id_seq", sequenceName = "visit_id_seq", allocationSize = 1)
    @Id

    private Integer id;

    private String description;
    private Timestamp visit_date;

    @OneToMany(mappedBy = "visit")
    private List<PetEntity> pet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Timestamp visit_date) {
        this.visit_date = visit_date;
    }

    public List<PetEntity> getPet() {
        return pet;
    }

    public void setPet(List<PetEntity> pet) {
        this.pet = pet;
    }
}

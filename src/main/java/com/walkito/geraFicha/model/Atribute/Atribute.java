package com.walkito.geraFicha.model.Atribute;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Atribute.Skill.Skill;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atributes")
public class Atribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 18)
    private String txName;

    @OneToMany(mappedBy = "atribute")
    @JsonIgnore
    private List<Skill> skills = new ArrayList<>();

    public Atribute() {
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxName() {
        return txName;
    }

    public void setTxName(String txName) {
        this.txName = txName;
    }
}

package com.walkito.geraFicha.model.Class;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Class.Characteristic.Characteristic;
import com.walkito.geraFicha.model.Class.SubClass.SubClass;
import com.walkito.geraFicha.model.Item.Item;
import com.walkito.geraFicha.model.Magic.Magic;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 35)
    private String txName;

    @ManyToMany
    @JoinTable
    private List<Item> itens = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<SubClass> subClasses = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<Characteristic> characteristics = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<Proficiency> proficiencies = new ArrayList<>();

    @ManyToMany(mappedBy = "classes")
    @JsonIgnore
    private List<Magic> magics = new ArrayList<>();

    public Class() {
    }

    public List<Magic> getMagics() {
        return magics;
    }

    public void setMagics(List<Magic> magics) {
        this.magics = magics;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public List<SubClass> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<SubClass> subClasses) {
        this.subClasses = subClasses;
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

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}

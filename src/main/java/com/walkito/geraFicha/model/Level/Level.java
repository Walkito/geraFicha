package com.walkito.geraFicha.model.Level;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Class.Characteristic.Characteristic;
import com.walkito.geraFicha.model.Magic.Magic;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private int nuXp;

    @Column(length = 2)
    private int nuProficiency;

    @ManyToMany(mappedBy = "levels")
    @JsonIgnore
    private List<Characteristic> characteristics = new ArrayList<>();

    @OneToMany(mappedBy = "level")
    @JsonIgnore
    private List<Magic> magics = new ArrayList<>();

    public Level() {
    }

    public List<Magic> getMagics() {
        return magics;
    }

    public void setMagics(List<Magic> magics) {
        this.magics = magics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public int getNuProficiency() {
        return nuProficiency;
    }

    public void setNuProficiency(int nuProficiency) {
        this.nuProficiency = nuProficiency;
    }

    public int getNuXp() {
        return nuXp;
    }

    public void setNuXp(int nuXp) {
        this.nuXp = nuXp;
    }
}

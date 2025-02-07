package com.walkito.geraFicha.model.Class.ClassCharacteristic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Class.Class;
import com.walkito.geraFicha.model.Class.SubClass.SubClass;
import com.walkito.geraFicha.model.Level.Level;
import com.walkito.geraFicha.model.Proficiency.Proficiency;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class_characteristics")
public class ClassCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40)
    private String txName;

    @Column(columnDefinition = "TEXT")
    private String txDescription;

    @ManyToMany(mappedBy = "classCharacteristics")
    @JsonIgnore
    private List<SubClass> subClasses = new ArrayList<>();

    @ManyToMany(mappedBy = "classCharacteristics")
    @JsonIgnore
    private List<Class> classes = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<Proficiency> proficiencies = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<Level> levels = new ArrayList<>();

    public ClassCharacteristic() {
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
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

    public String getTxDescription() {
        return txDescription;
    }

    public void setTxDescription(String txDescription) {
        this.txDescription = txDescription;
    }

    public List<SubClass> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<SubClass> subClasses) {
        this.subClasses = subClasses;
    }
}

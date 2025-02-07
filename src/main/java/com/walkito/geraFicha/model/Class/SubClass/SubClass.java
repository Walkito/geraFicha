package com.walkito.geraFicha.model.Class.SubClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristic;
import com.walkito.geraFicha.model.Class.Class;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sub_classes")
public class SubClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 35)
    private String txName;

    @ManyToMany(mappedBy = "subClasses")
    @JsonIgnore
    private List<Class> classes = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<ClassCharacteristic> classCharacteristics = new ArrayList<>();

    public SubClass() {
    }

    public List<ClassCharacteristic> getCharacteristics() {
        return classCharacteristics;
    }

    public void setCharacteristics(List<ClassCharacteristic> classCharacteristics) {
        this.classCharacteristics = classCharacteristics;
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

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}

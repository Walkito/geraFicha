package com.walkito.geraFicha.model.Class.Characteristic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Class.Class;
import com.walkito.geraFicha.model.Class.SubClass.SubClass;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characteristics")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40)
    private String txName;

    @Column(columnDefinition = "TEXT")
    private String txDescription;

    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    private List<SubClass> subClasses = new ArrayList<>();

    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    private List<Class> classes = new ArrayList<>();

    public Characteristic() {
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

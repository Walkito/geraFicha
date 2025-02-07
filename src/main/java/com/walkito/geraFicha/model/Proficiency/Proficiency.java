package com.walkito.geraFicha.model.Proficiency;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.Class.ClassCharacteristic.ClassCharacteristic;
import com.walkito.geraFicha.model.Class.Class;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proficiencies")
public class Proficiency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String txName;

    @Column(length = 2)
    private String tpProficiency;

    @ManyToMany(mappedBy = "proficiencies")
    @JsonIgnore
    private List<Antecedent> antecedents = new ArrayList<>();

    @ManyToMany(mappedBy = "proficiencies")
    @JsonIgnore
    private List<Class> classes = new ArrayList<>();

    @ManyToMany(mappedBy = "proficiencies")
    @JsonIgnore
    private List<ClassCharacteristic> classCharacteristics = new ArrayList<>();

    public Proficiency() {
    }

    public List<ClassCharacteristic> getCharacteristics() {
        return classCharacteristics;
    }

    public void setCharacteristics(List<ClassCharacteristic> classCharacteristics) {
        this.classCharacteristics = classCharacteristics;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Antecedent> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(List<Antecedent> antecedents) {
        this.antecedents = antecedents;
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

    public String getTpProficiency() {
        return tpProficiency;
    }

    public void setTpProficiency(String tpProficiency) {
        this.tpProficiency = tpProficiency;
    }
}

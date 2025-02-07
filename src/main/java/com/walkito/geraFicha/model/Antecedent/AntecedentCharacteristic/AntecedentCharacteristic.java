package com.walkito.geraFicha.model.Antecedent.AntecedentCharacteristic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Antecedent.Antecedent;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "antecedent_characteristics")
public class AntecedentCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40)
    private String txName;

    @Column(columnDefinition = "TEXT")
    private String txDescription;

    @ManyToMany(mappedBy = "antecedentCharacteristics")
    @JsonIgnore
    private List<Antecedent> antecedents = new ArrayList<>();

    public AntecedentCharacteristic() {
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

    public String getTxDescription() {
        return txDescription;
    }

    public void setTxDescription(String txDescription) {
        this.txDescription = txDescription;
    }
}

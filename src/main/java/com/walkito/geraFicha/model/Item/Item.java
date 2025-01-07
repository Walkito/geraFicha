package com.walkito.geraFicha.model.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.Class.Class;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String txName;

    @Column(length = 2)
    private String tpItem;

    @Column(columnDefinition = "TEXT")
    private String txDescription;

    @ManyToMany(mappedBy = "itens")
    @JsonIgnore
    private List<Antecedent> antecedents = new ArrayList<>();

    @ManyToMany(mappedBy = "itens")
    @JsonIgnore
    private List<Class> classes = new ArrayList<>();

    public Item() {
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

    public String getTpItem() {
        return tpItem;
    }

    public void setTpItem(String tpItem) {
        this.tpItem = tpItem;
    }

    public String getTxDescription() {
        return txDescription;
    }

    public void setTxDescription(String txDescription) {
        this.txDescription = txDescription;
    }
}

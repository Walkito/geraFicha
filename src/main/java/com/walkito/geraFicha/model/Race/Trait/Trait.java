package com.walkito.geraFicha.model.Race.Trait;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Race.Race;
import com.walkito.geraFicha.model.Race.Trait.DraconicAncestor.DraconicAncestor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "traits")
public class Trait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40)
    private String txName;

    @Column(columnDefinition = "TEXT")
    private String txDescription;

    @ManyToMany(mappedBy = "traits")
    @JsonIgnore
    private List<Race> races = new ArrayList<>();

    @OneToMany(mappedBy = "trait")
    @JsonIgnore
    private List<DraconicAncestor> draconicAncestors = new ArrayList<>();

    public Trait() {
    }

    public List<DraconicAncestor> getDraconicAncestors() {
        return draconicAncestors;
    }

    public void setDraconicAncestors(List<DraconicAncestor> draconicAncestors) {
        this.draconicAncestors = draconicAncestors;
    }

    public String getTxDescription() {
        return txDescription;
    }

    public void setTxDescription(String txDescription) {
        this.txDescription = txDescription;
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

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}

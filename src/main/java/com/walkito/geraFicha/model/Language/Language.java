package com.walkito.geraFicha.model.Language;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Antecedent.Antecedent;
import com.walkito.geraFicha.model.Race.Race;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String txName;

    @ManyToMany(mappedBy = "languages")
    @JsonIgnore
    private List<Race> races = new ArrayList<>();

    @ManyToMany(mappedBy = "languages")
    @JsonIgnore
    private List<Antecedent> antecedents = new ArrayList<>();

    public Language() {
    }

    public List<Antecedent> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(List<Antecedent> antecedents) {
        this.antecedents = antecedents;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
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

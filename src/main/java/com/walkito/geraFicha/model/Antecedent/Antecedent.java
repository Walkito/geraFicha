package com.walkito.geraFicha.model.Antecedent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Item.Item;
import com.walkito.geraFicha.model.Language.Language;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "antecedents")
public class Antecedent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String txName;

    @ManyToMany
    @JoinTable
    private List<Language> languages = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<Item> itens = new ArrayList<>();

    public Antecedent() {
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getTxName() {
        return txName;
    }

    public void setTxName(String txName) {
        this.txName = txName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

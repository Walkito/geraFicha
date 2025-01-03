package com.walkito.geraFicha.model.Tendency;

import jakarta.persistence.*;


@Entity
@Table(name = "tendencys")
public class Tendency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String txName;

    public Tendency() {
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

package com.walkito.geraFicha.model.Atribute.Skill;

import com.walkito.geraFicha.model.Atribute.Atribute;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String txName;

    @ManyToOne
    private Atribute atribute;

    public Skill() {
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

    public Atribute getAtribute() {
        return atribute;
    }

    public void setAtribute(Atribute atribute) {
        this.atribute = atribute;
    }
}

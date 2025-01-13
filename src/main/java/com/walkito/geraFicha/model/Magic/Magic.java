package com.walkito.geraFicha.model.Magic;

import com.walkito.geraFicha.model.Class.Class;
import com.walkito.geraFicha.model.Level.Level;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "magics")
public class Magic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String txName;

    @ManyToOne
    private Level level;

    @ManyToMany
    @JoinTable
    private List<Class> classes = new ArrayList<>();

    public Magic() {
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}

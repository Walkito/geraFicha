package com.walkito.geraFicha.model.Race.Trait.DraconicAncestor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkito.geraFicha.model.Race.Trait.Trait;
import jakarta.persistence.*;

@Entity
@Table(name = "draonic_ancestors")
public class DraconicAncestor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String txName;

    @Column(length = 20)
    private String txDamageType;

    @Column(length = 60)
    private String txBlowGun;

    @ManyToOne
    @JoinColumn
    private Trait trait;

    public DraconicAncestor() {
    }

    public Trait getTrait() {
        return trait;
    }

    public void setTrait(Trait trait) {
        this.trait = trait;
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

    public String getTxDamageType() {
        return txDamageType;
    }

    public void setTxDamageType(String txDamageType) {
        this.txDamageType = txDamageType;
    }

    public String getTxBlowGun() {
        return txBlowGun;
    }

    public void setTxBlowGun(String txBlowGun) {
        this.txBlowGun = txBlowGun;
    }
}

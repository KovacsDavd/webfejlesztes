package hu.unideb.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car extends CoreEntity {

    @Column(name = "marka", nullable = false)
    private String marka;
    @Column(name = "szin", nullable = false)
    private String szin;

    @Column(name = "rendszam", nullable = false)
    private String rendszam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }
}

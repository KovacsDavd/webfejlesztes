package hu.unideb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner extends CoreEntity {

    @Column(name = "keresztnev")
    private String keresztnev;

    @Column(name = "vezeteknev")
    private String vezeteknev;

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    @Override
    public String toString() {
        return vezeteknev + " " + keresztnev;
    }
}

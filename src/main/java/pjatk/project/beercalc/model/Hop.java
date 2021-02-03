package pjatk.project.beercalc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hop {
    @Id
    @GeneratedValue
    private String name;
    private double alphaAcids;
    private double amount;
    private int id;

    public Hop(String name, double alphaAcids, double amount, int id) {
        this.name = name;
        this.alphaAcids = alphaAcids;
        this.amount = amount;
        this.id = id;
    }

    public Hop(String name, double alphaAcids, double amount) {
        this.name = name;
        this.alphaAcids = alphaAcids;
        this.amount = amount;
    }

    public Hop() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlphaAcids() {
        return alphaAcids;
    }

    public void setAlphaAcids(double alphaAcids) {
        this.alphaAcids = alphaAcids;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

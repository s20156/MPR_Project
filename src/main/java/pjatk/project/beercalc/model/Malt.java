package pjatk.project.beercalc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Malt {
    @Id
    @GeneratedValue
    private String name;
    private int id;
    private int color;
    private int extract;
    private double amount;

    public Malt(String name, int id, int color, int extract, double amount) {
        this.name = name;
        this.id = id;
        this.color = color;
        this.extract = extract;
        this.amount = amount;
    }

    public Malt() {
    }

    public Malt(String name, int color, int extract, double amount) {
        this.name = name;
        this.color = color;
        this.extract = extract;
        this.amount = amount;
    }
}

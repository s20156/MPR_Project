package pjatk.project.beercalc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private String name;
    private double extract;
    private int IBU;
    private int id;
//    private List<Malt> malts;
//    private List<Hop> hops;

    public Recipe(String name, double extract, int IBU, int id) {
        this.name = name;
        this.extract = extract;
        this.IBU = IBU;
        this.id = id;
    }

    public Recipe() {
    }

    public Recipe(String name, double extract, int IBU) {
        this.name = name;
        this.extract = extract;
        this.IBU = IBU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExtract() {
        return extract;
    }

    public void setExtract(double extract) {
        this.extract = extract;
    }

    public int getIBU() {
        return IBU;
    }

    public void setIBU(int IBU) {
        this.IBU = IBU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package pjatk.project.beercalc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double extract;
    private int IBU;
    private double maltAmount;
    private double targetVolume;
    private double hopAmount;
    private double hopAlfaAcids;
    private double color;

    public Recipe(String name, double extract, int IBU, double maltAmount, double targetVolume, double hopAmount, double hopAlfaAcids, double color) {
        this.name = name;
        this.extract = extract;
        this.IBU = IBU;
        this.maltAmount = maltAmount;
        this.targetVolume = targetVolume;
        this.hopAmount = hopAmount;
        this.hopAlfaAcids = hopAlfaAcids;
        this.color = color;
    }

    public Recipe() {
    }

    public Recipe(Long id, String name, double extract, int IBU, double maltAmount, double targetVolume, double hopAmount, double color) {
        this.id = id;
        this.name = name;
        this.extract = extract;
        this.IBU = IBU;
        this.maltAmount = maltAmount;
        this.targetVolume = targetVolume;
        this.hopAmount = hopAmount;
        this.color = color;
    }

    public Recipe(String name, double maltAmount, double hopAmount, double color) {
        this.name = name;
        this.maltAmount = maltAmount;
        this.hopAmount = hopAmount;
        this.color = color;
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

    public double getMaltAmount() {
        return maltAmount;
    }

    public void setMaltAmount(double maltAmount) {
        this.maltAmount = maltAmount;
    }

    public double getTargetVolume() {
        return targetVolume;
    }

    public void setTargetVolume(double targetVolume) {
        this.targetVolume = targetVolume;
    }

    public double getHopAmount() {
        return hopAmount;
    }

    public void setHopAmount(double hopAmount) {
        this.hopAmount = hopAmount;
    }

    public double getHopAlfaAcids() {
        return hopAlfaAcids;
    }

    public void setHopAlfaAcids(double hopAlfaAcids) {
        this.hopAlfaAcids = hopAlfaAcids;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }

    public int getIBU() {
        return IBU;
    }

    public void setIBU(int IBU) {
        this.IBU = IBU;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package fr.univlille1.hembertgiraudet.legendarycraft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int force, intelligence, endurance, agilite, defense, critique;

    public Stats() {
    }

    public Stats(int force, int intelligence, int endurance, int agilite, int defense, int critique) {
        this.force = force;
        this.intelligence = intelligence;
        this.endurance = endurance;
        this.agilite = agilite;
        this.defense = defense;
        this.critique = critique;
    }

    public Stats modify(Stats stats) {
        return new Stats(this.force+stats.force,
                this.intelligence+stats.intelligence,
                this.endurance +stats.endurance,
                this.agilite+stats.agilite,
                this.defense+stats.defense,
                this.critique+stats.critique);
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCritique() {
        return critique;
    }

    public void setCritique(int critique) {
        this.critique = critique;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", force=" + force +
                ", intelligence=" + intelligence +
                ", endurance=" + endurance +
                ", agilite=" + agilite +
                ", defense=" + defense +
                ", critique=" + critique +
                '}';
    }
}

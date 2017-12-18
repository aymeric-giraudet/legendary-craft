package fr.univlille1.hembertgiraudet.legendarycraft.model;

import javax.persistence.*;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Account account;
    private String name;
    private int level;

    public Character() {
    }

    public Character(Account account, String name, int level) {
        this.account = account;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", account=" + account +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}

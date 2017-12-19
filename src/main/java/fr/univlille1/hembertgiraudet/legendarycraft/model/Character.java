package fr.univlille1.hembertgiraudet.legendarycraft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.persistence.*;
import java.util.List;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Account account;
    private String name;
    private int level;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Item> stuff;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Stats stats;

    public Character() {
    }

    public Character(Account account, String name, int level, Stats stats) {
        this.account = account;
        this.name = name;
        this.level = level;
        this.stats = stats;
    }

    @JsonIgnore
    public Stats getStuffStats() {
        Stats newStats = stats;
        for(Item item : stuff) {
            newStats = newStats.modify(item.getStats());
        }
        return newStats;
    }

    public List<Item> getStuff() {
        return stuff;
    }

    public void setStuff(List<Item> stuff) {
        this.stuff = stuff;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
                ", stuff=" + stuff +
                ", stats=" + stats +
                '}';
    }
}

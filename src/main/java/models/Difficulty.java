package models;

import jakarta.persistence.*;

@Entity
@Table(name="difficulty")
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_difficulty;
    private String name;

    public Difficulty(int id_difficulty, String name) {
        this.id_difficulty = id_difficulty;
        this.name = name;
    }

    public Difficulty() {

    }


    public int getId_difficulty() {
        return id_difficulty;
    }

    public void setId_difficulty(int id_difficulty) {
        this.id_difficulty = id_difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Difficulty{" +
                "id_difficulty=" + id_difficulty +
                ", name='" + name + '\'' +
                '}';
    }
}

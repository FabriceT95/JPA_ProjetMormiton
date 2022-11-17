package models;

import jakarta.persistence.*;

@Entity
@Table(name="difficulty")
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Difficulty(Long id_difficulty, String name) {
        this.id = id_difficulty;
        this.name = name;
    }

    public Difficulty(String name) {
        this.name = name;
    }

    public Difficulty() {

    }


    public Long getId_difficulty() {
        return id;
    }

    public void setId_difficulty(Long id_difficulty) {
        this.id = id_difficulty;
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
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

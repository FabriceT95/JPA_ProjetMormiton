package models;


import jakarta.persistence.*;

@Entity
@Table(name = "cooking")
public class Cooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Cooking(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cooking(String name) {
        this.name = name;
    }

    public Cooking() {

    }

    public Long getId_cooking() {
        return id;
    }

    public void setId_cooking(Long id_cooking) {
        this.id = id_cooking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cooking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

}


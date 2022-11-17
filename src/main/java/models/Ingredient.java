package models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long id;

    private String name;


    public Ingredient(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

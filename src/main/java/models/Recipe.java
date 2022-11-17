package models;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_recipe")
    private Long id;
    private boolean isPrivate;
    private String title;
    private String steps;
    private int servings;
    private int preDuration ;
    private int bakingTime;
    private int restTime;
    private float cost;
    private LocalDate createdAt;
    private String noteOfTheAuthor;

    @ManyToOne
    private Difficulty difficulty;

    @ManyToOne
    private Cooking cooking;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "id_recipe"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient")
    )
    private Set<Ingredient> ingredientList = new HashSet<>();

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Cooking getCooking() {
        return cooking;
    }

    public void setCooking(Cooking cooking) {
        this.cooking = cooking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe(Long id_recipe, boolean isPrivate, String title, String steps, int servings, int preDuration, int bakingTime, int restTime, float cost, LocalDate createdAt, String noteOfTheAuthor, Difficulty difficulty, Cooking cooking, User user) {
        this.id = id_recipe;
        this.isPrivate = isPrivate;
        this.title = title;
        this.steps = steps;
        this.servings = servings;
        this.preDuration = preDuration;
        this.bakingTime = bakingTime;
        this.restTime = restTime;
        this.cost = cost;
        this.createdAt = createdAt;
        this.noteOfTheAuthor = noteOfTheAuthor;
        this.difficulty = difficulty;
        this.cooking = cooking;
        this.user = user;
    }

    public Recipe(boolean isPrivate, String title, String steps, int servings, int preDuration, int bakingTime, int restTime, float cost, LocalDate createdAt, String noteOfTheAuthor, Difficulty difficulty, Cooking cooking, User user) {
        this.isPrivate = isPrivate;
        this.title = title;
        this.steps = steps;
        this.servings = servings;
        this.preDuration = preDuration;
        this.bakingTime = bakingTime;
        this.restTime = restTime;
        this.cost = cost;
        this.createdAt = createdAt;
        this.noteOfTheAuthor = noteOfTheAuthor;
        this.difficulty = difficulty;
        this.cooking = cooking;
        this.user = user;
    }

    public Recipe() {

    }


    public Long getId_recipe() {
        return id;
    }

    public void setId_recipe(Long id_recipe) {
        this.id = id_recipe;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getPreDuration() {
        return preDuration;
    }

    public void setPreDuration(int preDuration) {
        this.preDuration = preDuration;
    }

    public int getBakingTime() {
        return bakingTime;
    }

    public void setBakingTime(int bakingTime) {
        this.bakingTime = bakingTime;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getNoteOfTheAuthor() {
        return noteOfTheAuthor;
    }

    public void setNoteOfTheAuthor(String noteOfTheAuthor) {
        this.noteOfTheAuthor = noteOfTheAuthor;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id_recipe=" + id +
                ", isPrivate=" + isPrivate +
                ", title='" + title + '\'' +
                ", ingredientList='" + ingredientList + '\'' +
                ", steps='" + steps + '\'' +
                ", servings=" + servings +
                ", preDuration=" + preDuration +
                ", bakingTime=" + bakingTime +
                ", restTime=" + restTime +
                ", cost=" + cost +
                ", createdAt=" + createdAt +
                ", noteOfTheAuthor='" + noteOfTheAuthor + '\'' +
                ", difficulty=" + difficulty +
                ", cooking=" + cooking +
                ", user=" + user +
                '}';
    }

    public Set<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(Set<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}

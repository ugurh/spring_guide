package io.ugurh.spring_guide.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PLAYER")
@NamedQuery(name = "get_all_players", query = "select p from Player p")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nationality;
    private Date birthDate;
    private int title;

    public Player() {
    }

    public Player(int id, String name, String nationality, Date birthDate, int title) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.title = title;
    }

    public Player(String name, String nationality, Date birthDate, int title) {
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", title=" + title +
                '}';
    }
}

package pet.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="place")
public class FoodPlace implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="place_id")
    private int id;

    @Column(name="title")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="notes")
    private String notes;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private LocalDate dateTime;

    @Column(name = "feedback")
    private int feedback;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "person_to_place",
            joinColumns = { @JoinColumn(name = "place_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_id") }
    )
    private List<Person> persons = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    @JsonIgnore
    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }
}

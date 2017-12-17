package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String surname;
    private List<Integer> history;

    public User(String name, String surname) {
        this.id = getNewId();
        this.name = name;
        this.surname = surname;
        this.history = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void updateHistory(int collectibleId) {
        this.history.add(collectibleId);
    }

    public List<Integer> getHistory() {
        return this.history;
    }

    public boolean hasInHistory(int collectibleId) {
        return this.history.stream().anyMatch(id -> id == collectibleId);
    }

    public static int getNewId() {
        return ++idCounter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ");
        builder.append(this.id);
        builder.append("; Name: ");
        builder.append(this.name);
        builder.append("; Surname: ");
        builder.append(this.surname);

        return builder.toString();
    }
}

package entities;

import java.util.Objects;

public abstract class Collectible {
    private static int idCounter = 0;
    private int id;
    private Integer ownerId;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public static int getNewId() {
        return ++idCounter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ");
        builder.append(this.id);
        builder.append("; Rent to: ");
        builder.append(this.ownerId == null ? "none" : this.ownerId);
        builder.append("; ");

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Collectible){
            Collectible c = (Collectible) obj;
            return c.id == this.id && Objects.equals(this.ownerId, c.ownerId);
        } else {
            return false;
        }
    }
}

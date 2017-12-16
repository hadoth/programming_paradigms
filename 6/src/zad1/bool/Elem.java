package zad1.bool;

public class Elem {
    private boolean value;

    protected Elem() {};

    public Elem(boolean value) {
        this.value = value;
    }

    public boolean evaluate() {
        return this.value;
    }

    protected void setValue(boolean value) {
        this.value = value;
    }
}

package zad1.bool;

public class Not extends Elem implements Unary {

    public void setValue(boolean value) {
        super.setValue(!value);
    }
}

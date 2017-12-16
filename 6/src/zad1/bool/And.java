package zad1.bool;

public class And extends Elem implements Binary {
    public void setValues(boolean left, boolean right) {
        super.setValue(left && right);
    }
}

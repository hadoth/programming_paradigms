package zad1;

import zad1.bool.*;

import java.util.LinkedList;

public class Evaluator {

    public static void main(String[] args) {
        Elem[] test1 = {new Elem(true), new Elem(false), new And(), new Not()};
        Elem[] test2 = {new Elem(true), new Elem(false), new And(), new And()};
        System.out.println(evaluate(test1));
        System.out.println(evaluate(test2));
    }

    public static boolean evaluate(Elem[] list) {
        LinkedList<Elem> stack = new LinkedList<>();
        int index = 0;
        while (index < list.length) {
            Elem current = list[index];
            if (current instanceof Unary) {
                ((Not) current).setValue(stack.removeFirst().evaluate());
            }
            if (current instanceof Binary) {
                ((Binary) current).setValues(stack.removeFirst().evaluate(), stack.removeFirst().evaluate());
            }
            stack.addFirst(current);
            index++;
        }
        return stack.removeFirst().evaluate();
    }
}

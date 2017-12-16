package zad2;

import java.util.Arrays;

public class Replicate {
    public static void main(String[] args){
        int[] input = {1,2,3};
        int[] output = replicate(input);
        System.out.println(Arrays.toString(input));
        System.out.println("to");
        System.out.println(Arrays.toString(output));
    }

    private static int newLen(int[] list) {
        int result = 0;

        for (int i = 0; i < list.length; i++) {
            result += list[i];
        }

        return result;
    }

    private static int[] replicate(int[] list) {
        int[] result = new int[newLen(list)];
        int inputIndex = 0;
        int counter = 0;
        int index = 0;
        while (inputIndex < list.length) {
            while (counter < list[inputIndex]) {
                result[index] = list[inputIndex];
                index++;
                counter++;
            }
            inputIndex++;
            counter = 0;
        }
        return result;
    }
}

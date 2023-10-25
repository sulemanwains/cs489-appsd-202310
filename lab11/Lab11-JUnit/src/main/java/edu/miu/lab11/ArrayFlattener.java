package edu.miu.lab11;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {

    public int[] flattenArray(int[][] inputArray) {
        List<Integer> flattenedList = new ArrayList<>();

        if(inputArray == null){
            return null;
        }

        for (int[] row : inputArray) {
            for (int value : row) {
                flattenedList.add(value);
            }
        }

        // Convert the List<Integer> to int[].
        int[] flattenedArray = new int[flattenedList.size()];
        for (int i = 0; i < flattenedList.size(); i++) {
            flattenedArray[i] = flattenedList.get(i);
        }

        return flattenedArray;
    }
}

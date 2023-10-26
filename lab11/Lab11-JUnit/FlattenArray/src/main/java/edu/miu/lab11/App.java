package edu.miu.lab11;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};

        ArrayFlattener arrayFlattener = new ArrayFlattener();

        System.out.println("Flatten Array: " + Arrays.toString(arrayFlattener.flattenArray(inputArray)));
    }
}

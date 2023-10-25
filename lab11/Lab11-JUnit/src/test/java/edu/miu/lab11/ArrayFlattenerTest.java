package edu.miu.lab11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener;

    @Before
    public void setUp() throws Exception {
        this.arrayFlattener = new ArrayFlattener();
    }

    @After
    public void tearDown() throws Exception {
        this.arrayFlattener = null;
    }

    @Test
    public void testFlattenArray() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] actual = arrayFlattener.flattenArray(inputArray);
        int[] expected = {1,3,0,4,5,9};
        assertArrayEquals("Error: flattenArray() method test fails", expected, actual);
    }

    @Test
    public void testFlattenerArrayForNullInput(){
        int[][] inputArray = null;
        int[] actual = arrayFlattener.flattenArray(inputArray);
        int[] expected = null;
        assertArrayEquals("Error: flattenArray() method test fails", expected, actual);
    }
}
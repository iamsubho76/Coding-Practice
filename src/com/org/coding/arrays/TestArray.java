package com.org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestArray {
	public static void main(String[] args) {
		try {
			TestArray.biggestNumberFromArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void biggestNumberFromArray() throws IOException{

		System.out.println("Please entered the numbers separated by space ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String [] values = br.readLine().split(" ");
        int size = values.length;
        ArrayNumber[] array= new ArrayNumber[size];
        for(int i=0; i<size;i++){
            array[i] = new ArrayNumber(values[i]);
        }
        Arrays.sort(array);
        for(int i=0;i<size;i++){
            System.out.print(array[i].str);
        }
    }
}


class ArrayNumber implements Comparable<ArrayNumber>{
    String  str;
    ArrayNumber(String str){
        this.str = str;
    }
    @Override
    public int compareTo(ArrayNumber obj) {
        Integer num1 = Integer.parseInt(this.str + (String) obj.str);
        Integer num2 = Integer.parseInt((String )obj.str + this.str);
        return num2 - num1;
    }
}
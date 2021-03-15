package com.company;

public class Main {

    public static void main(String[] args) {
	    Test1();
    }

    public static void Test1(){
        Polynomial polynomial = Polynomial.create();
        System.out.println(Polynomial.toString(polynomial));
    }
}

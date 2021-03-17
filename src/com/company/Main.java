package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
//     Test1();
//        Test2();
//        Test3();
        Test4();
    }

    public static void Test4() throws CloneNotSupportedException {
        Polynomial a = Polynomial.create();
        Polynomial b = Polynomial.create();
        Polynomial c = Polynomial.multiplyPolynomialPolynomial(a, b);
        System.out.println(Polynomial.toString(c));
    }

    public static void Test3(){
        Scanner in = new Scanner(System.in);
        Polynomial a = Polynomial.create();
        System.out.print("Coefficient and power of the monomial: ");
        Monomial b = new Monomial(in.nextDouble(), in.nextInt());
        Polynomial c = Polynomial.multiplyPolynomialMonomial(a, b);
        System.out.println(Polynomial.toString(c));
    }

    public static void Test2() throws CloneNotSupportedException {
        Polynomial a = Polynomial.create();
        Polynomial b = Polynomial.create();
        Polynomial c = Polynomial.add(a, b);
        System.out.println(Polynomial.toString(c));
    }

    public static void Test1(){
        Polynomial polynomial = Polynomial.create();
        System.out.println(Polynomial.toString(polynomial));
    }
}

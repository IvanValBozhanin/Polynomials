package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Polynomial implements Cloneable{
    LinkedList<Monomial> l = new LinkedList<>();

    public static Polynomial create(){
        Polynomial list = new Polynomial();
        Scanner in = new Scanner(System.in);
        System.out.print("Number of meaningful powers: ");
        int n = in.nextInt();
        for(int i=0, c, p;i<n;++i){
            System.out.printf("Number %d coefficient and power: ", i+1);
            c = in.nextInt();
            p = in.nextInt();
            list.l.add(new Monomial(c, p));
        }
        list.l.sort(Collections.reverseOrder());
        return list;
    }


    public static String toString(Polynomial list){
        Iterator it = list.l.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while(it.hasNext()){
            stringBuilder.append(it.next()).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

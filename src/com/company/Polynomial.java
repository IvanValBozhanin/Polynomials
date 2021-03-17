package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Polynomial implements Cloneable{
    LinkedList<Monomial> l = new LinkedList<>();

    public Polynomial() {
    }

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

    public static Polynomial add(Polynomial a, Polynomial b) throws CloneNotSupportedException {
        Polynomial c = new Polynomial();
        Polynomial a1 = (Polynomial) a.clone();
        Polynomial b1 = (Polynomial) b.clone();
        a1.l.add(new Monomial(-1, -1));
        b1.l.add(new Monomial(-1, -1));
        Iterator ita = a1.l.iterator();
        Iterator itb = b1.l.iterator();
        Monomial curra = (Monomial) ita.next();
        Monomial currb = (Monomial) itb.next();
        while (ita.hasNext() || itb.hasNext()) {
            if(currb == null || currb.getPower() == -1){
                c.l.add(curra);
                curra = (Monomial) ita.next();
            }
            else if(curra == null || curra.getPower() == -1){
                c.l.add(currb);
                currb = (Monomial) itb.next();
            }
            else if (curra.compareTo(currb) > 0) {
                c.l.add(curra);
                curra = (Monomial) ita.next();
            }
            else if (currb.compareTo(curra) > 0) {
                c.l.add(currb);
                currb = (Monomial) itb.next();
            }
            else {
                c.l.add(new Monomial(curra.getCoefficient() + currb.getCoefficient(), curra.getPower()));
                curra = (Monomial) ita.next();
                currb = (Monomial) itb.next();
            }
        }
        return c;
    }

    public static Polynomial multiplyPolynomialMonomial(Polynomial a, Monomial b){
        Polynomial c = new Polynomial();
        for (Monomial m :
                a.l) {
            c.l.add(new Monomial(m.getCoefficient() * b.getCoefficient(), m.getPower() + b.getPower()));
        }
        return c;
    }

    public static Polynomial multiplyPolynomialPolynomial(Polynomial a, Polynomial b) throws CloneNotSupportedException {
        Polynomial c = new Polynomial();
        //c.l.add(new Monomial(0, 0));
        for (Monomial m :
                a.l) {
            c = Polynomial.add(c, Polynomial.multiplyPolynomialMonomial(b, m));
        }
        return c;
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

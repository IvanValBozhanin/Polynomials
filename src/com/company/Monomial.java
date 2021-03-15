package com.company;

public class Monomial implements Comparable<Monomial> {
    private double coefficient;
    private int power;

    public Monomial() {
    }

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString(){
        return String.format("%c %.2fx^%d", (coefficient>0 ? '+' : '-'), Math.abs(coefficient), power);
    }

    @Override
    public int compareTo(Monomial o) {
        return Double.compare(power, o.power);
    }
}

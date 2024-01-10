/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;
import java.util.*;

import javax.annotation.processing.SupportedAnnotationTypes;

public class ComplexNumber {

    private double re;
    private double im;


    ComplexNumber(double a, double b) {
        this.re = a;
        this.im = b;
    }

    public double realPart() {
        return this.re;
    }

    public double imaginaryPart() {

        return this.im;
    }

    public ComplexNumber add(ComplexNumber c) {

        return new ComplexNumber(this.re + c.realPart(), this.im + c.imaginaryPart());

    }

    public ComplexNumber subtract(ComplexNumber c) {
        return new ComplexNumber(this.re - c.realPart(), this.im - c.imaginaryPart());
    }

    public ComplexNumber multiply(ComplexNumber c) {

        this.re = (this.re * c.re) - (this.im * c.im);
        this.im = (this.im * c.re) + (this.re * c.im);
        return this;
    }

    public ComplexNumber division(ComplexNumber c) {

        throw new UnsupportedOperationException("Not supported yet."); // muy largo

    }

    public ComplexNumber conjugate() {
        this.im *= -1;
        return this;

    }

    public double module() {

        return Math.sqrt(Math.pow(this.re,2) + Math.pow(this.im,2));

    }
}

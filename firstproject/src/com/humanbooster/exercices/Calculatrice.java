package com.humanbooster.exercices;

public class Calculatrice {
    public static double additionner(double a, double b, int p){
        // Précision Set
        if (p > 0){
            String[] r = Double.toString(a + b).replace(".", ",").split("\\,");
            // In case Precision is Greater than number of decimals
            return (p < r[1].length()) ? Double.parseDouble(((r[0] + "." + r[1].substring(0, p)))) : Double.parseDouble(((r[0] + "." + r[1])));
        }
        return a + b;
    }

    public static double soustraire(double a, double b, int p){
        if (p > 0){
            String[] r = Double.toString(a - b).replace(".", ",").split("\\,");
            return (p < r[1].length()) ? Double.parseDouble(((r[0] + "." + r[1].substring(0, p)))) : Double.parseDouble(((r[0] + "." + r[1])));
        }
        return a - b;
    }

    public static double multiplier(double a, double b, int p){
        if (p > 0){
            String[] r = Double.toString(a * b).replace(".", ",").split("\\,");
            return (p < r[1].length()) ? Double.parseDouble(((r[0] + "." + r[1].substring(0, p)))) : Double.parseDouble(((r[0] + "." + r[1])));
        }
        return a * b;
    }

    public static double diviser(double a, double b, int p) throws ArithmeticException{
        if (b == 0) throw new ArithmeticException("Division par Zero");
        if (p > 0){
            String[] r = Double.toString(a / b).replace(".", ",").split("\\,");
            return (p < r[1].length()) ? Double.parseDouble(((r[0] + "." + r[1].substring(0, p)))) : Double.parseDouble(((r[0] + "." + r[1])));
        }
        return a / b;
    }

    public static double pow(double a, double b, int p) throws Exception{
        int i = 1;
        while (i < b) {
            a *= a;
            if (Double.isInfinite(a)) throw new Exception("Double Overflow");
            i++;
        }
        if (p > 0){
            String[] r = Double.toString(a).replace(".", ",").split("\\.");
            return (p < r[1].length()) ? Double.parseDouble(((r[0] + "." + r[1].substring(0, p)))) : Double.parseDouble(((r[0] + "." + r[1])));
        }
        return a;
    }
}

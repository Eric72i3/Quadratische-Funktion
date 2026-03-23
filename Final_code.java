import java.util.Scanner;
public class Final_code {
    public static class Werte {//final
        private final Double a;
        private final Double b;
        private final Double c;
        public Werte(Double a, Double b, Double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public Double a() {
            return a;}
        public Double b() {
            return b;}
        public Double c() {
            return c;}
    }//final

    public static Werte input(Scanner sc) {//final
        System.out.println("Funktionsgleichung: f(x) = ax^2 + bx + c");
        System.out.println("Bitte die Steigung a eingeben:");
        double a = sc.nextDouble();
        System.out.println("Bitte den Wert b eingeben:");
        double b = sc.nextDouble();
        System.out.println("Bitte den Wert c eingeben:");
        double c = sc.nextDouble();
        return new Werte(a, b, c);
    }//final

    public static Double fx(Double x, Double a, Double b, Double c) {
        return a*Math.pow(x, 2)+b*x+c;
    }

    public static Double bildeAbleitung(Double a, Double b, Double c, Double x) {//final
        return 2*a*x+b;
    }//final

    public static void lokal_steigung(Double a, Double b, Double c, Scanner sc) {
        System.out.println("Lokal Steigung: bitte den zu berechnenden x-Wert eingeben:");
        Double xls = sc.nextDouble();
        System.out.println("m = " + bildeAbleitung(a, b, c, xls ));
    }



    public static double[] bildeErsteAbleitung(double a, double b) {
        double ableitungA = 2 * a;
        double ableitungB = b;
        return new double[]{ableitungA, ableitungB};
    }

    public static double bildeZweiteAbleitung(double a) {
        return 2 * a;
    }


        public static void variablen(double a, double b, double c) {
        if (a == 0) {
            System.out.println("a darf nicht 0 sein, da dies keine quadratische Funktion ist.");
            return;
        }

        System.out.println("Gegeben: f(x) = " + a + "x² + " + b + "x + " + c);

        nullstelle(a, b, c);
        dfwf(a, b, c);
    }

    public static void nullstelle(double a, double b, double c) {
        double d = b * b - 4 * a * c;

        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Nullstellen: x1 = " + x1 + ", x2 = " + x2);
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("Eine doppelte Nullstelle: x = " + x);
        } else {
            System.out.println("Keine reellen Nullstellen");
        }
    }

    public static void dfwf(double a, double b, double c) {
        System.out.println("Definitionsmenge: D = ℝ");

        double xv = -b / (2 * a);
        double yv = a * xv * xv + b * xv + c;

        if (a > 0) {
            System.out.println("Wertemenge: W = [" + yv + ", ∞)");
        } else {
            System.out.println("Wertemenge: W = (-∞, " + yv + "]");
        }
    }





    public static void trennung(){//final
        System.out.println("================================");
    }//final

    public static void main(String[] args) {
        trennung();//final
        Scanner sc = new Scanner(System.in);
        Werte w = input(sc);
        Double a = w.a();
        Double b = w.b();
        Double c = w.c();
        trennung();
        System.out.println("Y - Achsenabschnitt:");
        System.out.println(fx(0.0, a, b, c));
        trennung();
        lokal_steigung(a, b, c, sc);
        trennung();
        
        //final

        double[] ableitung = bildeErsteAbleitung(a, b);
        double ableitungA = ableitung[0];
        double ableitungB = ableitung[1];
        System.out.println("Erste Ableitung: f'(x) = " + ableitungA + "x + " + ableitungB);
        double zweiteAbleitung = bildeZweiteAbleitung(a);
        System.out.println("Zweite Ableitung: f''(x) = " + zweiteAbleitung);
        trennung();

        //Final

        variablen(a, b, c);
        trennung();

        //Final
    
}}


import java.util.Scanner;
public class Final_code {

    public static double[] input(Scanner sc) {//final
        System.out.println("Funktionsgleichung: f(x) = ax^2 + bx + c");
        System.out.println("Bitte die Steigung a eingeben:");
        double a = sc.nextDouble();
        System.out.println("Bitte den Wert b eingeben:");
        double b = sc.nextDouble();
        System.out.println("Bitte den Wert c eingeben:");
        double c = sc.nextDouble();
        return new double[]{a, b, c};
    }//final

    public static double fx(double x, double a, double b, double c) {
        return a*Math.pow(x, 2)+b*x+c;
    }

    public static double bildeAbleitung(double a, double b, double c, double x) {//final
        return 2*a*x+b;
    }//final

    public static void lokal_steigung(double a, double b, double c, Scanner sc) {
        System.out.println("Lokal Steigung: bitte den zu berechnenden x-Wert eingeben:");
        double xls = sc.nextDouble();
        System.out.println("m (" + xls + "/" + fx(xls, a, b, c) + ") = " + bildeAbleitung(a, b, c, xls));
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


    public static void extrema(double a, double b, double k, double c, double g, double y) {
        if (k != 0) {  
            System.out.println("Notwendige Bedingung erfüllt für " + k);
            
            if (g != 0) {
                if (g > 0) {
                    System.out.println("Die Funktion hat einen Tiefpunkt am Punkt " + k+"/"+ y);
                }
                else if (g < 0) {
                    System.out.println("Die Funktion hat einen Hochpunkt am Punkt " + k+"/"+ y );
                }
            }
        }
        else {
            System.out.println("Keine Extremstellen");
        }
    }



    public static void bestimmemonotonie(double g) {
        if (g != 0) {
            if (g > 0) {
                System.out.println("Zuerst streng monoton fallend, dann Streng monoton steigend");
            }
            else if (g < 0) {
                System.out.println("Zuerst streng monoton steigend, dann Streng monoton fallend");
            }
        }
    }


    public static void trennung(){//final
        System.out.println("");
        System.out.println("================================");
        System.out.println("");

    }//final


    public static void main(String[] args) {
        trennung();//final
        Scanner sc = new Scanner(System.in);
        double[] coeff = input(sc);
        double a = coeff[0];
        double b = coeff[1];
        double c = coeff[2];

        trennung();

        System.out.println("Y - Achsenabschnitt:");
        System.out.println(fx(0.0, a, b, c));

        trennung();

        lokal_steigung(a, b, c, sc);
        
        trennung();

        double[] ableitung = bildeErsteAbleitung(a, b);
        double ableitungA = ableitung[0];
        double ableitungB = ableitung[1];
        System.out.println("Erste Ableitung: f'(x) = " + ableitungA + "x + " + ableitungB);
        double zweiteAbleitung = bildeZweiteAbleitung(a);
        System.out.println("Zweite Ableitung: f''(x) = " + zweiteAbleitung);

        trennung();

        variablen(a, b, c);

        trennung();

        double k = -b / (2 * a);
        double g = 2 * a;
        double y = a * k * k + b * k + c;
        extrema(a, b, k, c, g, y);

        trennung();

        bestimmemonotonie(g);

        trennung();

        sc.close();
    
}}


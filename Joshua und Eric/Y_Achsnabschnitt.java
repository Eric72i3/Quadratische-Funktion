import java.util.Scanner;
public class Y_Achsnabschnitt {
    public static class Werte {
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
    }

    public static Werte input(Scanner sc) {
        System.out.println("Funktionsgleichung: f(x) = ax^2 + bx + c");
        System.out.println("Bitte die Steigung a eingeben:");
        double a = sc.nextDouble();
        System.out.println("Bitte den Wert b eingeben:");
        double b = sc.nextDouble();
        System.out.println("Bitte den Wert c eingeben:");
        double c = sc.nextDouble();
        return new Werte(a, b, c);
    }
    public static Double fx(Double x, Double a, Double b, Double c) {
        return a*Math.pow(x, 2)+b*x+c;
    }
    public static Double bildeAbleitung(Double a, Double b, Double c, Double x) {
        return 2*a*x+b;
    }
    public static void lokal_steigung(Double a, Double b, Double c, Scanner sc) {
        System.out.println("Ableitung: 2a*x+b");
        System.out.println("Lokal Steigung: bitte den zu berechnenden x-Wert eingeben:");
        Double xls = sc.nextDouble();
        System.out.println("m = " + bildeAbleitung(a, b, c, xls ));
    }
    public static void trennung(){
        System.out.println("================================");
    }

    public static void main(String[] args) {
        trennung();
        Scanner sc = new Scanner(System.in);
        Werte w = input(sc);
        Double a = w.a();
        Double b = w.b();
        Double c = w.c();

        trennung();

        System.out.println("Y - Achsenabschnitt:");
        System.out.println(fx(0.0, a, b, c));
        
        trennung();

        while (true) {
        lokal_steigung(a, b, c, sc);
        trennung();
        }
    
}}

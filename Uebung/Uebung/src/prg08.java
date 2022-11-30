public class prg08 {
  public static void main(String[] args) {
    System.out.print("Wie viel Kapital in € wurde investiert? ");
    double invested = new java.util.Scanner(System.in).nextDouble();
    System.out.print("Wie hoch ist der Zinssatz in %? ");
    double percentage = new java.util.Scanner(System.in).nextDouble();
    System.out.print("Bei welcher Laufzeit? ");
    int years = new java.util.Scanner(System.in).nextInt();

    double calculatedgain = 1 + percentage / 100;
    double gain = invested * Math.pow(calculatedgain, years);
    double gained = gain - invested;
    System.out.println("Der Gewinn durch Zinsen beträgt " + gained + "€");
    System.out.println("Nach " + years + " Jahren beträgt das angesparte Kapital " + gain + "€" );
  }
}

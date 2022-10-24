public class prg9 {
  public static void main(String[] args){
    System.out.println("Bitte gebe x ein! ");
    double x = new java.util.Scanner(System.in).nextDouble();
    double y = 3 * Math.pow(x, 2) - 8 * x + 4;
    System.out.println("Bei x = " + x + " ergibt die Gleichung den Wert " + y);
  }
}

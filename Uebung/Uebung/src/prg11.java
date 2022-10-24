public class prg11 {
  public static void main(String[] args){
    System.out.println("Bitte gebe eine Zahl ein! ");
    double x = new java.util.Scanner(System.in).nextDouble();
    modulo(x);

  }
  private static void modulo(double x){
    int full = (int) x;
    double broken = x - full;
    /*double broken = (x % 1);
    double full = x - full;*/

    System.out.println("Der Ganzzahllige Teil beträgt " + full);
    System.out.println("Der Gebrochene Teil beträgt " + broken);
  }
}

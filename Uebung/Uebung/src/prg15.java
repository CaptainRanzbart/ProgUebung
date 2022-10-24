public class prg15 {
  public static void main(String[] args){
    System.out.println("Schalter 1 ist an?");
    boolean a = new java.util.Scanner(System.in).nextBoolean();

    System.out.println("Schalter 2 ist an?");
    boolean b = new java.util.Scanner(System.in).nextBoolean();

    boolean c = a ^ b;
    System.out.println("Das Licht ist an? --> " + c);
  }
}

public class prg16 {
  public static void main(String[] args){
    System.out.println("Notschalter 1 ist an?");
    boolean a = new java.util.Scanner(System.in).nextBoolean();

    System.out.println("Notschalter 2 ist an?");
    boolean b = new java.util.Scanner(System.in).nextBoolean();

    boolean c = !(a || b);
    System.out.println("Die Heizung läuft? --> " + c);
  }
}

package prg42to45;

public class konto2Main {

  static Konto konto1 = new Konto("DE123123", 3200.43);
  public static void main(String[] args){
    System.out.println(konto1.getKontostand());
    System.out.println(konto1.toString());
  }

}

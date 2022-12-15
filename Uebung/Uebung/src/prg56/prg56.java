package prg56;

public class prg56 {
  public static void main(String[] args) {
    Abo normalAbo = new Abo();
    Abo superAbo = new SuperAbo();
    Abo premiumAbo = new PremiumAbo();
    System.out.println("Das normale Abo kostet pro Jahr: " + normalAbo.getPreisProJahr());
    System.out.println("Das Super Abo kostet pro Jahr: " + superAbo.getPreisProJahr());
    System.out.println("Das Premium Abo kostet pro Jahr: " + premiumAbo.getPreisProJahr());
  }
}
class Abo{
  double getPreisProJahr(){
    return 24.0;
  }
}
class SuperAbo extends Abo{
  @Override
  double getPreisProJahr(){
    return 48.0;
  }
}
class PremiumAbo extends SuperAbo{
  @Override
  double getPreisProJahr(){
    return 96.0;
  }
}
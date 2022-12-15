package prg58;

public class prg58 {
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
  private Abonnent abbonent;
  double getPreisProJahr(){
    return 24.0;
  }
  Abonnent getAbbonent(){
    return abbonent;
  }
}
class SuperAbo extends Abo {
  @Override
  double getPreisProJahr(){
    return 48.0;
  }
}
class PremiumAbo extends SuperAbo {
  @Override
  double getPreisProJahr(){
    return 96.0;
  }
}
class Abonnent{
  private int alter;
  int getAlter(){
    return alter;
  }
}
class AboRechner{
  double getAboPreis(Abo abo){
    double out;
    if(abo.getAbbonent().getAlter() < 18){
      switch ((int) abo.getPreisProJahr()){
        case 48: out = abo.getPreisProJahr() * 0.75;
          break;
        case 96: out = abo.getPreisProJahr() * 0.5;
          break;
        default: out = abo.getPreisProJahr();
          break;
      };
    }else{
      out = abo.getPreisProJahr();
    }
    return out;
  }
}
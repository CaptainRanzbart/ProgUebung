package prg42to45;

public class Konto {
  private String kontoNr;
  private double kontostand;

  public Konto(String _kontonr, double _kontostand){
    kontostand = _kontostand;
    kontoNr = _kontonr;
  }
  public String toString(){
    StringBuilder stb = new StringBuilder();
    stb.append("Kontonummer:");
    stb.append(kontoNr);
    stb.append("/Kontostand");
    stb.append(kontostand);
    String output = stb.toString();
    return output;
  }
  public String getKontoNr() {
    return kontoNr;
  }

  public double getKontostand() {
    return kontostand;
  }

  public void setKontoNr(String kontoNr) {
    this.kontoNr = kontoNr;
  }

  public void setKontostand(double kontostand) {
    this.kontostand = kontostand;
  }
  void einzahlen(double betrag){
    setKontostand(getKontostand() + betrag);
  }
  double auszahlen(double betrag){
    if(getKontostand() > betrag) {
      setKontostand(getKontostand()-betrag);
      System.out.println("Ihr aktualisierter Kontostand beträgt " + getKontostand() + "€");
      return betrag;
    }else {
      System.out.println("Ihr Kontostand ist nicht ausreichen! Ihr Aktueller Kontostand beträgt " + getKontostand()
          + "€ Sie können deshalb nicht " + betrag + "€ abheben!");
      return 0;
    }
  }


}

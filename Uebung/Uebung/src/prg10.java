public class prg10 {
  public static void main(String[] args){
    System.out.println("Bitte gebe einen Bruttopreis an! ");
    double brutto = new java.util.Scanner(System.in).nextDouble();
    double netto = brutto - brutto * 19 / (119);
    System.out.print("Bei einem Steuersatz von 19% und einem Bruttobetrag von " + brutto
                      + "€ beträgt der Nettobetrag " + netto + "€!");
  }
}

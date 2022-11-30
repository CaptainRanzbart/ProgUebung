package prg33to37;

public class Fraction3Main {
  public static void main(String[] args) {
    Fraction3 myFraction1 = new Fraction3();
    myFraction1.numerator = 2;
    myFraction1.denominator = 5;
    Fraction3 myFraction2 = new Fraction3();
    myFraction2.numerator = 3;
    myFraction2.denominator = 8;
    myFraction1.add(myFraction2);
//    myFraction1.sub(myFraction2);
//    myFraction1.mul(myFraction2);
//    myFraction1.div(myFraction2);
    System.out.println("Ergebnis: "
        + myFraction1.numerator + " / "
        + myFraction1.denominator);
  }
}

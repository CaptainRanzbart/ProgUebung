package prg41;

public class Fraction5 {

  public Fraction5(){
    System.out.println("\nKonstruktor: Fraction5():\n--------------------------------------");
  }
  public Fraction5(int n, int d){
    System.out.println("\nKonstruktor: Fraction5(int, int):\n--------------------------------------");
  }
  public Fraction5(int n){
    System.out.println("\nKonstruktor: Fraction5(int):\n--------------------------------------");
  }
  int numerator;
  int denominator;
  void add(Fraction5 op) {
    numerator = (numerator * op.denominator) +
        (op.numerator * denominator);
    denominator = denominator * op.denominator;
  }
  void sub(Fraction5 op){
    op.numerator = -numerator;
    add(op);
  }
  void mul(Fraction5 op) {
    numerator = numerator * op.numerator;
    denominator = denominator * op.denominator;
  }
  void div(Fraction5 op){
    Fraction5 temp = new Fraction5();
    temp.numerator = op.denominator;
    temp.denominator = op.numerator;
    mul(temp);
  }
  double toDouble() {
    return numerator / (double) denominator;
  }
  void reduce(){
    int c = gcd(numerator, denominator);
    numerator = numerator / c;
    denominator = denominator /c;
  }
  int gcd(int a, int b){
    if(a == 0){
      return b;
    }else{
      while(b != 0){
        if(a > b){
          a = a - b;
        }else{
          b = b - a;
        }
      }
      return a;
    }
  }
}

package prg33to37;

public class Fraction3 {
  int numerator;
  int denominator;
  void add(Fraction3 op) {
    numerator = (numerator * op.denominator) +
    (op.numerator * denominator);
    denominator = denominator * op.denominator;
  }
  void sub(Fraction3 op){
    op.numerator = -numerator;
    add(op);
  }
  void mul(Fraction3 op) {
    numerator = numerator * op.numerator;
    denominator = denominator * op.denominator;
  }
  void div(Fraction3 op){
    Fraction3 temp = new Fraction3();
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

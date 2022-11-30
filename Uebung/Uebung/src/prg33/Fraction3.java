package prg33;

public class Fraction3 {
  int numerator;
  int denominator;
  void add(Fraction3 op) {
    numerator = (numerator * op.denominator) +
    (op.numerator * denominator);
    denominator = denominator * op.denominator;
  }
  void sub(Fraction3 op){
    numerator = (numerator * op.denominator) -
        (op.numerator * denominator);
    denominator = denominator * op.denominator;
  }
  void mul(Fraction3 op) {
    numerator = numerator * op.numerator;
    denominator = denominator * op.denominator;
  }
  void div(Fraction3 op){
    numerator = numerator * op.denominator;
    denominator = denominator * op.numerator;
  }
  double toDouble() {
    return numerator / (double) denominator;
  }
  void reduce(){
    int a = numerator;
    int b = denominator;
    if(a == 0){
      denominator = denominator / b;
    }else{
      while(b != 0){
        if(a > b){
          a = a - b;
        }else{
          b = b - a;
        }
      }
      numerator = numerator / a;
      denominator = denominator / a;
    }
  }
}

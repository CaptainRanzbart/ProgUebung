import java.util.Objects;

import static java.lang.System.exit;

public class prg21 {
  public static void main(String[] args){
    System.out.println("Geben sie den Ersten Operanden ein!");
    double a = new java.util.Scanner(System.in).nextDouble();
    System.out.println("Geben sie den Operator ein!");
    String operator = new java.util.Scanner(System.in).nextLine();
    System.out.println("Geben sie den Zweiten Operanden ein!");
    double b = new java.util.Scanner(System.in).nextDouble();

    double out = 0;
    /*if(Objects.equals(operator, "+")){
      out = a + b;
    }else{
      if(Objects.equals(operator, "-")){
        out = a - b;
      }else{
        if(Objects.equals(operator, "*")){
          out = a * b;
        }else{
          System.out.println("Bitte geben sie einen der folgenden Operatoren ein: - , + , *");
          exit(0);
        }
      }
    }*/
    switch(operator){
      case "+": out = a + b;
      break;
      case "-": out = a - b;
      break;
      case "*": out = a * b;
      break;
      default:
        System.out.println("Bitte geben sie einen der folgenden Operatoren ein: - , + , *");
        exit(0);
        break;
    }
    System.out.println(out);
  }
}

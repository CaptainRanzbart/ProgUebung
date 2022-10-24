import java.text.DecimalFormat;

import static java.lang.System.exit;

public class prg17 {
  public static void main(String[] args){
    DecimalFormat oneDecimal = new DecimalFormat("#0.0");
    DecimalFormat  twoDecimals = new DecimalFormat("#0.00");

    double gasPerHundredKilometer = 4.7;
    double oilPerHundredKilometer = 0.4;

    System.out.println("Wie viele Kilometer werden gefahren?");
    double km = validateDoubleInput(new java.util.Scanner(System.in).nextDouble());

    System.out.println("Wie viel Kostet der Liter Benzin?");
    double price = validateDoubleInput(new java.util.Scanner(System.in).nextDouble());

    System.out.println("Möchten sie einen Spritverbrauch angeben?");
    boolean customGasUsage = new java.util.Scanner(System.in).nextBoolean();
    if(customGasUsage){
      System.out.println("Wie hoch ist der Spritverbauch?");
      gasPerHundredKilometer = validateDoubleInput(new java.util.Scanner(System.in).nextDouble());
    };
    System.out.println("Möchten sie einen Ölverbrauch angeben?");
    boolean customOilUsage = new java.util.Scanner(System.in).nextBoolean();
    if(customOilUsage){
      System.out.println("Wie hoch ist der Ölverbauch?");
      oilPerHundredKilometer = validateDoubleInput(new java.util.Scanner(System.in).nextDouble());
    };

    double gas = km / 100 * gasPerHundredKilometer;
    double oil = km / 100 * oilPerHundredKilometer;
    double budget = gas * price;

    System.out.println("Bei einer Strecke von " + km + "km werden " + oneDecimal.format(gas) +
        " Liter Benzin und " + oneDecimal.format(oil) + " Liter Öl gebraucht.");
    System.out.println("Es werden " + twoDecimals.format(budget) + "€ benötigt.");
  }
  public static double validateDoubleInput(double input) {
    double output = 0;
    if (input > 0) {
      output = input;
    }else{
      System.out.println("Der angegebene Wert war nicht gültig!");
      exit(0);
    }
    return output;
  }
}

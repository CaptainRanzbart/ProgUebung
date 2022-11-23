public class prg32 {
  public static void main(String[] args){
    System.out.println("Wie viele Wiederholungen möchten sie in ihrer Funktion beinhalten!");
    int input = new java.util.Scanner(System.in).nextInt();
    double value = calculate(input);
    System.out.println("Der ermittelte Wert für Pi ist "+ value);
  }
  public static double calculate(int itterations){
    System.out.println("Calculating ...");
    double output = 0;
    for(int i = 0;i<itterations; i++){
    double current = (Math.pow(-1,i)/(2*i + 1))*4;
    output += current;
    }

    System.out.println("Done calculating!");
    return output;
  }
}

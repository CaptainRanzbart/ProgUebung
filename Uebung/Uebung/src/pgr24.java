import java.util.Random;

public class pgr24 {
  public static void main(String[] args){
    Random rn = new Random();
    int random = rn.nextInt(10) + 1;

    System.out.println("Rate doch mal welche Zahl ich mir ausgedacht habe!");
    do{
      int guess = new java.util.Scanner(System.in).nextInt();
      if(guess == random){
        System.out.println("Richtig die ausgedachte Zahl war " + random);
        break;
      }else {
        System.out.println("Falsch! Probiers doch nochmal!");
      }
    }while(true);
  }
}

import java.util.Random;

public class prg23 {
  public static void main(String[] args){
    Random random1 = new Random();
    int random = random1.nextInt(10) + 1;
    int guess = 99;
    int count = 0;

    System.out.println("Rate doch mal welche Zahl ich mir ausgedacht habe!");
    while(true){
      count += 1;
      guess = new java.util.Scanner(System.in).nextInt();
      if(guess == random){
        System.out.println("Richtig die ausgedachte Zahl war " + random);
       break;
      }else {
        if(count < 3){
          System.out.println("Falsch! Probiers doch nochmal!");
        }else{
          System.out.println("Du hast mehr als drei Versuche gebraucht und verloren!");
          break;
        }
      }
    }





  }
}

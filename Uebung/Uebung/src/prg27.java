import java.util.Random;

public class prg27 {
  public static void main(String[] args){
    boolean playAgain = true;
    do{


    Random rn = new Random();
    int random = rn.nextInt(10) + 1;
    int score = 5;

    System.out.println("Rate doch mal welche Zahl ich mir ausgedacht habe!");
    while(score > 0){
      int guess = new java.util.Scanner(System.in).nextInt();
      if(guess == random){
        break;
      }else {
        score--;
        System.out.println("Falsch! Probiers doch nochmal!");
        if(random > guess){
          System.out.println("Die ausgedahte Zahl ist übrigens größer als deine Zahl!");
        }else{
          System.out.println("Die ausgedahte Zahl ist übrigens kleiner als deine Zahl!");
        }
      }
    }
    if(score == 0){
      System.out.println("Sie haben verloren!");
    }else{
      System.out.println("Richtig die ausgedachte Zahl war " + random + "! Sie haben eine Punktzahl von " + score + " erreicht!");
    }
      System.out.println("Möchten sie erneut spielen? (j / n)");
    String input = new java.util.Scanner(System.in).nextLine();
    switch(input){
      case "J":
      case "j":
        playAgain = true;
        break;
      default:
        playAgain = false;
        break;
    }
    }while(playAgain);
  }
}

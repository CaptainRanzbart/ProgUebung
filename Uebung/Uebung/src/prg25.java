import java.util.Random;

public class prg25 { public static void main(String[] args){
  Random rn = new Random();
  int random = rn.nextInt(10) + 1;

  System.out.println("Rate doch mal welche Zahl ich mir ausgedacht habe!");
  while(true){
    int guess = new java.util.Scanner(System.in).nextInt();
    if(guess == random){
      System.out.println("Richtig die ausgedachte Zahl war " + random);
      break;
    }else {
      System.out.println("Falsch! Probiers doch nochmal!");
      if(random > guess){
        System.out.println("Die ausgedahte Zahl ist übrigens größer als deine Zahl!");
      }else{
        System.out.println("Die ausgedahte Zahl ist übrigens kleiner als deine Zahl!");
      }
    }
  }
}
}

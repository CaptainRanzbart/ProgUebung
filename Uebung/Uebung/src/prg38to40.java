public class prg38to40 {
  public static void main(String[] args){
    int n;
    int counter = 0;
    int max = 0;
    do {
      System.out.print("Bitte geben sie eine Zahl ein: ");
      n = new java.util.Scanner(System.in).nextInt();
    }while(n == 0);
    System.out.println("Calculating...");

    while(n > 1) {
      counter++;
      if ((n % 2) == 0) {
        n = n / 2;
      } else {
        n = n * 3 + 1;
      }
      if(n > max){
        max = n;
      }
      System.out.println("Current Value for output: " + n);
    }

    /*for(int i = n; i > 0;){
      counter++;
      if((i % 2) == 0){
        i = i / 2;
      }else{
        i = i * 3 + 1;
      }
      if(i > max){
        max = i;
      }
      if(i == 1){
        break;
      }
      System.out.println("Current Value for output: " + i);
    }*/

    System.out.println("Der maximal erreichte Wert betrag: " + max);
    System.out.println("Die Anzahl der Durchläufe beträgt: " + counter);
  }
}

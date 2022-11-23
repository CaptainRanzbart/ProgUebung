public class prg32_2 {
  public static void main(String[] args){
    double value = calculate();
    System.out.println("Der ermittelte Wert für Pi ist "+ value);
  }
  public static double calculate(){

    double output = 0;
      int i = 0;
      double shortdouble = 0;
      do{
      double current = (Math.pow(-1,i)/(2*i + 1))*4;
      output += current;
      i++;
      int temp = (int)(output*10000);
      shortdouble = ((double)temp)/10000;
      }while(shortdouble != 3.1415);
    System.out.println("Calculating took " + i + " Itterations");
    return output;
  }
}

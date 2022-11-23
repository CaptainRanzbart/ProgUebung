public class prg28 {
  public static void main(String[] args){
    for(int j = 0; j<5; j++){
    for(int i = 0; i<5; i++) {
      if(i <= j){
        System.out.print("#");
      }else{
      System.out.print(".");
      }
    }
    System.out.println();
    }
  }
}

public class prg46 {

  public static void main(String[] args){

    String test = "Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu";

    /*String analyse1 = test.replaceAll("(?i)[bcdfghjklmnpqrstvwxyz]", "-" );
    String analyse = analyse1.replaceAll( "(?i)[aeiou]", "x" );*/

    char[] arr = test.toCharArray();
    char[] output =  new char[arr.length];
    for(int i = 0; i < arr.length; i++){
      if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
        output[i] = 'x';
      }else{
        output[i] = '-';
      }
    }
    StringBuilder stb = new StringBuilder();
    stb.append(output);
    String analyse = stb.toString();


    System.out.println(test);
    System.out.println(analyse);

  }
}

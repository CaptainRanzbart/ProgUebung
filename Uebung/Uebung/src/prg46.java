public class prg46 {

  public static void main(String[] args){
    String test = "Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu";
    String analyse = test;
    analyse.replaceAll( "[aeiou]", "x" );
    System.out.println(test);
    System.out.println(analyse);
  }
}

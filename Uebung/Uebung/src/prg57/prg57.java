package prg57;

public class prg57 {
  public static void main(String[] args){
    Object person = new Person();
    Object blume = new Blume();
    if(blume instanceof Blume) {
      blume = (Blume) person;
    }
  }
}
class Person{}
class Blume{}

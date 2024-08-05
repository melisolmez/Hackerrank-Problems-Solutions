import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/*
  -Hackerrank pattern syntax checker algoritma sorusunun cevabı
  -Bu sorudaki amaç bir stringin regex deseni olup olmadığını kontrol etmektir
  -https://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html#compile%28java.lang.String%29

 */
public class Main {
    public static void main(String[] args) {

      isValid("[AZ[a-z](a-z)");
      isValid("[AAAAAAAAAAAAAAAAAAAAAAAA]*");
      isValid("@1xUlE*2v+w8fDfsUv(J+GzxeYJjq{h0zajS~GfSJCaWJ1LOp");
       isValid("sanjay");

    }
    public static void isValid(String pattern){
        try{
            Pattern.compile(pattern); // Bir regex desenini derler ve geçerliyse bir Pattern nesnesi döner.
            System.out.println("Valid");
        }catch (PatternSyntaxException e) {
            System.out.println("InValid");
        }
    }
}
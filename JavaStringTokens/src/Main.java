import java.sql.Array;
import java.util.Arrays;
import java.util.Spliterator;

/*
   * Hackerrank java string tokens sorusunun çözümüdür
 */
public class Main {
    public static void main(String[] args) {
        splitTokens(" ");
        splitTokens("He is a very very good boy, isn't he?");
        splitTokens("Hello, thanks for attempting this problem! Hope it will help you to learn java! Good luck and have a nice day!");
        splitTokens("Its always better if you find edge cases by yourself rather than buying test cases with valuable hackos!!   May be this case won't help you to find the   buuuuuug   ");
        splitTokens("    a    ");
    }

    public static void splitTokens(String token){

            token = token.trim();           // trim() metodu ile stringin başındaki ve sonundaki boşluklar silindi
            if(!token.isEmpty()) {          // boşlukları silinen stringin boş olup olmadığı kontrol edildi
                String[] words = token.split("[\\p{Punct}\\s]+");   // boş değilse string \p{Punct} kullanılarak noktalama işaretlerine göre,\s kullanılarak boşluklarına göre bölündü.
                System.out.println(words.length);     // bölünen stringin uzunluğu alındı

                for (String word : words) {  // foreach döngüsü ile stringin bölünen parçaları alındı
                    if (!word.isEmpty()) {   // boş değilse yazdırıldı
                        System.out.println(word);
                    }
                }
            }else{
                System.out.println("0"); // stringin null olması durumunda ekrana sıfır yazdırıldı
            }
    }
}
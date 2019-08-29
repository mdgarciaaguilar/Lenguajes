
import Scanner.Scanner;
import Scanner.Token;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        String string;
        Scanner scanner;
        scanner = new Scanner();
        List<Token> tokens;

        string = "()+123 $a4 ";

        System.out.println(string);
        tokens = scanner.scan(string);
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

}

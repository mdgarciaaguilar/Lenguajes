
import Scanner.Scanner;
import Scanner.Token;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        String string;
        Scanner scanner;
        scanner = new Scanner();
        List<Token> tokens;
        //string = "101b-(001b     +11b)";
        //string = "101b+11b";
        //string = "101b(+11b)";
        //string = "-+(-101b(+11b)";
        string = "123";
        System.out.println(string);
        tokens = scanner.scan(string);
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

}

package Scanner;

import Scanner.Token.Type;
import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private boolean debugMode = false;
    private final int ERROR = 999;
    private final int[][] transitionMatrix;

    public Scanner() {
        transitionMatrix = new int[][]{
            /*
             * State 0
             */
            {1, 2, ERROR, 106, 107, 0, ERROR},
            /*
             * State 1
             */
            {1, ERROR, ERROR, ERROR, ERROR, 102, ERROR},
            /*
             * State 3
             */
            {ERROR, ERROR, 3, ERROR, ERROR, ERROR, ERROR},
            /*
             * State 4
             */
            {3, ERROR, 3, ERROR, ERROR, 105, ERROR}
        };

    }

    public List<Token> scan(String string) {
        char c;
        int state, index;
        StringBuilder value;
        List<Token> tokens;
        state = 0;
        index = 0;
        tokens = new ArrayList();
        while (index < string.length()) {
            value = new StringBuilder();
            do {
                c = string.charAt(index);
                if (debugMode) {
                    System.out.println("State " + state + ", \'" + c + "\' => " + transitionMatrix[state][filter(c)]);
                }
                index++;
                state = transitionMatrix[state][filter(c)];
                if (state != 0) {
                    value.append(c);
                }
            } while (index < string.length() && state < 100);
            switch (state) {
                case 102:
                    value.delete(value.length()-1,value.length());
                    tokens.add(new Token(Type.NUMBER, value.toString()));
                    break;
                case 105:
                    value.delete(value.length()-1,value.length());
                    tokens.add(new Token(Type.VARIABLE, value.toString()));
                    break;
                case 106:
                    tokens.add(new Token(Type.PARENTHESIS, value.toString()));
                    break;
                case 107:
                    tokens.add(new Token(Type.OPERATOR, value.toString()));
                    break;
                case ERROR:
                    value.append(c);
                    System.out.println("LEXICAL ERROR: the string \'" + value.toString() + "\' is not a valid element in the language.");
                    return tokens;
                default:
                    return tokens;
            }
            state = 0;
        }
        return tokens;
    }

    private int filter(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 0;
            case '$':
                return 1;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return 2;
            case '(':
            case ')':
                return 3;
            case '+':
            case '-':
            case '*':
            case '/':
              return 4;
            case ' ':
            case '\t':
            case '\n':
                return 5;
            default:
                return 6; // Illegal character
        }
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

}

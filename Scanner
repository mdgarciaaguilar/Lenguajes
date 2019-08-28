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
            {1, ERROR, 103, 104, 0, ERROR},
            /*
             * State 1
             */ 
            {1, 102, ERROR, ERROR, ERROR, ERROR}
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
                    tokens.add(new Token(Type.BINARY_NUMBER, value.toString()));
                    break;
                case 103:
                    tokens.add(new Token(Type.OPERATOR, value.toString()));
                    break;
                case 104:
                    tokens.add(new Token(Type.PARENTHESIS, value.toString()));
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
                return 0;
            case 'b':
                return 1;
            case '+':
            case '-':
                return 2;
            case '(':
            case ')':
                return 3;
            case ' ':
            case '\t':
            case '\n':
                return 4;
            default:
                return 5; // Illegal character
        }
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

}

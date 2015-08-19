import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }
}

class Task {
    public void solve(int caseNumber, InputReader in, PrintWriter out) {
        char[] s = in.next().toCharArray();
        char[] result = new char[s.length];
        boolean pos = true;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == '[' || s[i] == ']') {
                pos = !pos;
                result[i] = s[i] == '[' ? '(' : ')';
                continue;
            }
            if (pos) {
                result[i] = s[i];
                continue;
            }
            if (s[i] == '(' || s[i] == ')') {
                result[i] = s[i];
            } else if (s[i] == '*') {
                result[i] = '+';
            } else if (s[i] == '+') {
                result[i] = '*';
            } else if (s[i] <= 'Z') {
                result[i] = (char) (s[i] + 'a' - 'A');
            } else {
                result[i] = (char) (s[i] - 'a' + 'A');
            }
        }
        System.out.println(new String(result));

    }

    public boolean isLower(char c) {
        return Character.isLowerCase(c);
    }

    public boolean isUpper(char c) {
        return Character.isUpperCase(c);
    }

    public char toLower(char c) {
        return Character.toLowerCase(c);
    }

    public char toUpper(char c) {
        return Character.toUpperCase(c);
    }
}

class InputReader {
    BufferedReader reader;
    StringTokenizer token;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        token = null;
    }

    public String next() {
        while (token == null || !token.hasMoreTokens()) {
            try {
                token = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return token.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
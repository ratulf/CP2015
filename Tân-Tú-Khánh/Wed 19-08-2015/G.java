import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);
        String s = in.next();
        int n = s.length();
        boolean changes[] = new boolean[n];
        boolean change = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == ']') {
                change = !change;
            }
            changes[i] = change;
        }
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                r.append('(');
            } else if (s.charAt(i) == ']') {
                r.append(')');
            } else {
                if (changes[i]) {
                    r.append(fix(s.charAt(i) + ""));
                } else {
                    r.append(s.charAt(i));
                }
            }
        }
        System.out.println(r);
    }

    private static String fix(String string) {
        if (string.equals("+")) {
            return "*";
        }
        if (string.equals("*")) {
            return "+";
        }
        if (string.equals(string.toLowerCase())) {
            return string.toUpperCase();
        }
        return string.toLowerCase();
    }

}

class InputReader {
    StringTokenizer tokenizer;
    BufferedReader reader;

    public InputReader(InputStream stream) {
        tokenizer = null;
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
    }

    public String next() {
        while ((tokenizer == null) || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
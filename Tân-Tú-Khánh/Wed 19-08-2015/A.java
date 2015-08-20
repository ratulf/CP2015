import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);
        double n = in.nextDouble();
        double R = in.nextDouble();
        double r = in.nextDouble();
        double x = Math.sin((Math.PI)/n)*r;
        System.out.println(x*R*n);
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
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
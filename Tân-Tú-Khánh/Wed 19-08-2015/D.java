import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();
        int[] arr = new int[n+5];
        for (int i = 5; i < n +5; i++) {
            arr[i] = in.nextInt();
        }
        int[] res = new int[n+5];
        for (int i = 5; i < n+5; i++) {
            int max = Math.max(Math.max(res[i-3], res[i-4]), res[i-5]);
            res[i] = max+arr[i];
        } 
        System.out.println(Math.max(Math.max(res[n+3], res[n+2]),res[n+4]));
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
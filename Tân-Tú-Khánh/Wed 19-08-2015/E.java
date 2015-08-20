import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        System.out.println(max);
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
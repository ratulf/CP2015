import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);
        boolean primes[] = new boolean[1000001];
        Arrays.fill(primes, true);
        for (int i = 2; i * i < 1000001; i++) {
            for (int j = i * 2; j < 1000001; j += i) {
                primes[j] = false;
            }
        }
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        for (int i = 2; i < 1000001; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }
        String s = in.next();
        int n = s.length();
        int count = n - 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '.') {
                count = i;
            }
        }
        count = n - 1 - count;
        s = s.replace(".", "");
        long divi = (long) Math.pow(10, count) * 100;
        long number = Long.parseLong(s);
        for (int x : primeList) {
            while (number % x == 0 && divi % x == 0) {
                number /= x;
                divi /= x;
            }
        }
        System.out.println(divi);
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

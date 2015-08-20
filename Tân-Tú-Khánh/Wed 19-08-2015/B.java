import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);
        int k = in.nextInt();
        String[] user = new String[k];
        int users[] = new int[k];
        for (int i = 0; i < k; i++) {
            user[i] = in.next() + " " + in.next();
        }
        for (int i = 0; i < k; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            String s1 = user[i].replace(" ", "");
            for (int j = 0; j < s1.length(); j++) {
                if (!map.containsKey(s1.charAt(j))) {
                    map.put(s1.charAt(j), 1);
                } else {
                    map.put(s1.charAt(j), map.get(s1.charAt(j)) + 1);
                }
            }
            HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
            for (int j = 0; j < n; j++) {
                String s = in.next();
                for (int l = 0; l < m; l++) {
                    if (!map2.containsKey(s.charAt(l))) {
                        map2.put(s.charAt(l), 1);
                    } else {
                        map2.put(s.charAt(l), map2.get(s.charAt(l)) + 1);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                int div = 0;
                if (entry.getValue() > 0) {
                    if (map2.containsKey(entry.getKey())) {
                        div = map2.get(entry.getKey()) / entry.getValue();
                    }
                    min = Math.min(min, div);
                }
            }
            users[i] = min;
        }
        int pos = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (max < users[i]) {
                max = users[i];
                pos = i;
            }
        }
        System.out.println(user[pos]);
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
import java.io.*;
import java.util.*;

/*
 *  Copyright C-helper
 */
public class Main {
    public static void main(String[] args) {
        InputStream iStream = System.in;
        OutputStream oStream = System.out;
        InputReader in = new InputReader(iStream);
        PrintWriter out = new PrintWriter(oStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
}

class Task {
    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] m = new int[n];
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
        }
        Option[][] options = new Option[n][];
        for (int i = 0; i < n; i++) {
            options[i] = new Option[m[i]];
            for (int j = 0; j < m[i]; j++) {
                int foo = in.nextInt();
                if (!set.contains(foo)) {
                    set.add(foo);
                }
                options[i][j] = new Option(foo, j);
            }
            Arrays.sort(options[i]);
        }
        Iterator<Integer> it = set.iterator();
        long bestdiff = Long.MAX_VALUE;
        int best = -1;
        while (it.hasNext()) {
            int min = it.next();
            int max = min;
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                int idx = search(min, options[i]);
                if (idx == -1) {
                    ok = false;
                } else {
                    max = Math.max(max, options[i][idx].value);
                }
            }
            if (ok) {
                if (max - min < bestdiff) {
                    bestdiff = max - min;
                    best = min;
                }
            }
        }
        out.println(bestdiff);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int idx = search(best, options[i]);
            res.append(options[i][idx].index + 1);
            res.append(" ");
        }
        out.println(res);
    }

    int search(int key, Option[] a) {
        int res = -1;
        int left = 0;
        int right = a.length - 1;
        while (right >= left) {
            int mid = (right + left) >> 1;
            if (a[mid].value < key) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}

class Option implements Comparable<Option> {
    int value;
    int index;

    public Option(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Option o) {
        return Integer.compare(this.value, o.value);
    }

}

class InputReader {
    StringTokenizer token;
    BufferedReader reader;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
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

    public int[] nextArrInt(int n) {
        int[] out = new int[n];
        for (int i = 0; i < n; i++)
            out[i] = nextInt();
        return out;
    }

    public long[] nextArrLong(int n) {
        long[] out = new long[n];
        for (int i = 0; i < n; i++)
            out[i] = nextLong();
        return out;
    }
}
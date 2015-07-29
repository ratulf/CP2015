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
        int m = in.nextInt();
        String[] k = new String[n];
        for (int i = 0; i < n; ++i) {
            k[i] = in.next();
        }

        boolean[] c = new boolean[n];
        int min = 0;
        PriorityQueue<P> q = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int max = 0;
                for (int o = 0; o < m; ++o) {
                    max = Math.max(max,
                            Math.abs(k[i].charAt(o) - k[j].charAt(o)));
                }
                q.add(new P(i, j, max));
            }
        }
        int[] set = DisjointSets.createSets(n);
        int count = 0;

        while (count < n) {
            P p = q.poll();
            if (DisjointSets.root(set, p.a) != DisjointSets.root(set, p.b)) {
                count++;
                DisjointSets.unite(set, p.a, p.b);
            }
            if (count == n - 1) {
                System.out.println(p.d);
                return;
            }
        }
        out.println(min);
    }

    static class P implements Comparable<P> {
        public int a;
        public int b;
        public int d;

        public P(int a, int b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }

        @Override
        public int compareTo(P p) {
            return this.d - p.d;
        }

    }
}

class DisjointSets {

    public static int[] createSets(int size) {
        int[] p = new int[size];
        for (int i = 0; i < size; i++)
            p[i] = i;
        return p;
    }

    public static int root(int[] p, int x) {
        return x == p[x] ? x : (p[x] = root(p, p[x]));
    }

    public static void unite(int[] p, int a, int b) {
        a = root(p, a);
        b = root(p, b);
        if (a != b)
            p[a] = b;
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
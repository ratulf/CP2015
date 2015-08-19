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
        int n = in.nextInt();
        Event[] events = new Event[n];
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long D = in.nextLong();
            long V = in.nextLong();
            long T = in.nextLong();
            events[i] = new Event(D, V, T);
            if (!set.contains(D)) {
                set.add(D);
            }
        }
        Long[] dates = new Long[set.size()];
        Iterator<Long> it = set.iterator();
        for (int i = 0; i < dates.length && it.hasNext(); i++) {
            dates[i] = it.next();
        }
        Arrays.sort(dates);
        long res = 0;
        MagicTree tree = new MagicTree(set.size());
        for (int i = 0; i < n; i++) {
            int left = search(dates, events[i].date - events[i].t);
            int right = search(dates, events[i].date);
            long best = tree.getMax(left, right) + events[i].v;
            tree.update(right, best);
            res = Math.max(res, best);
        }
        out.println(res);
    }

    int search(Long[] a, long key) {
        int left = 0;
        int right = a.length - 1;
        int res = -1;
        while (right >= left) {
            int mid = (right + left) >> 1;
            if (a[mid] >= key) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

class Event {
    long date;
    long v;
    long t;

    public Event(long date, long v, long t) {
        this.date = date;
        this.v = v;
        this.t = t;
    }
}

class MagicTree {
    long[] t;
    int n;

    public MagicTree(int n) {
        t = new long[4 * n + 10];
        this.n = n;
    }

    private void update(int node, int left, int right, int index, long value) {
        if (index < left || index > right)
            return;
        if (left == right) {
            t[node] = Math.max(t[node], value);
            return;
        }
        int mid = (left + right) >> 1;
        update(node * 2 + 1, left, mid, index, value);
        update(node * 2 + 2, mid + 1, right, index, value);
        t[node] = Math.max(t[node * 2 + 1], t[node * 2 + 2]);
    }

    public void update(int index, long value) {
        update(0, 0, n, index, value);
    }

    private long query(int node, int left, int right, int L, int R) {
        if (right < L || left > R) {
            return 0;
        }
        if (L <= left && right <= R) {
            return t[node];
        }
        int mid = (left + right) >> 1;
        long leftNode = query(node * 2 + 1, left, mid, L, R);
        long rightNode = query(node * 2 + 2, mid + 1, right, L, R);
        return Math.max(leftNode, rightNode);
    }

    public long getMax(int left, int right) {
        return query(0, 0, n, left, right);
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
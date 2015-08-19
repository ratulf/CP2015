import java.io.*;
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
        HashMap<Character, Integer>[] user = new HashMap[n];
        String[][] u = new String[2][n];
        for (int i = 0; i < n; i++) {
            user[i] = new HashMap<Character, Integer>();
            char[][] name = new char[2][];
            u[0][i] = in.next();
            u[1][i] = in.next();
            name[0] = u[0][i].toCharArray();
            name[1] = u[1][i].toCharArray();
            for (int r = 0; r < 2; r++) {
                for (int j = 0; j < name[r].length; j++) {
                    if (user[i].containsKey(name[r][j])) {
                        user[i].put(name[r][j], user[i].get(name[r][j]) + 1);
                    } else {
                        user[i].put(name[r][j], 1);
                    }
                }
            }
        }
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            HashMap<Character, Integer> current = new HashMap<Character, Integer>();
            for (int j = 0; j < r; j++) {
                char[] m = in.next().toCharArray();
                for (int z = 0; z < m.length; z++) {
                    if (current.containsKey(m[z])) {
                        current.put(m[z], current.get(m[z]) + 1);
                    } else {
                        current.put(m[z], 1);
                    }
                }
            }
            int best = Integer.MAX_VALUE;
            for (Character need : user[i].keySet()) {
                int have = 0;
                if (current.containsKey(need)) {
                    have = current.get(need);
                }
                best = Math.min(best, have / user[i].get(need));
            }
            score[i] = best;
        }
        int bestUser = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] > score[bestUser])
                bestUser = i;
        }
        out.println(u[0][bestUser] + " " + u[1][bestUser]);
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
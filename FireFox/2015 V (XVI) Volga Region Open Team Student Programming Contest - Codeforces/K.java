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
		char[] str = in.next().toCharArray();
		int min = Integer.MAX_VALUE;
		int countA = 0;
		int countN = 0;
		for (int i = 0; i < n; ++i) {
			if (str[i] == 'A') {
				countA++;
			} else if (str[i] == 'N') {
				countN++;
			}
		}
		int d = countA + countN;
		for (int i = countA - 1; i < d; ++i) {
			int m = 0;
			int c = 0;
			int b = 0;
			for (int j = i; j >= 0; --j) {
				if (str[j] == 'F') {
					m += i - j - c;
					c++;
				}
			}

			for (int j = i + 1; j < n; ++j) {
				if (str[j] == 'A') {
					m += j - i - 1 - b;
					b++;
				}
			}
			m += b * c;
			min = Math.min(m, min);
		}
		System.out.println(min);
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
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStream iStream = System.in;
		OutputStream oStream = System.out;
		InputReader in = new InputReader(iStream);
		PrintWriter out = new PrintWriter(oStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}

}

class Task {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n;
		int id = 1;
		while ((n = in.nextInt()) != 0) {
			int ans = -1;
			int[] a = new int[n];
			int[] b = new int[n];
			int[] c = new int[n];
			int max = 1;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				b[i] = in.nextInt();
				c[i] = in.nextInt();
				max *= (a[i] + b[i]);
			}
			for (int i = 1; i <= max; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if (c[j] <= a[j]) {
						sum++;
					} else {
						sum--;
					}
					c[j]++;
				}
				if (sum == n) {
					ans = i;
					break;
				}
				for (int j = 0; j < n; j++) {
					if ((c[j] - 1 == a[j] && sum >= 0)
							|| c[j] - 1 == a[j] + b[j]) {
						c[j] = 1;
					}
				}
			}

			out.println("Case " + (id++) + ": " + ans);
		}
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
				// TODO Auto-generated catch block
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

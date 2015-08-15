import java.io.*;
import java.math.BigDecimal;
import java.util.*;

class Main {

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
	public void solve(int caseNum, InputReader in, PrintWriter out) {
		int T = in.nextInt();
		for (int it = 1; it <= T; it++) {
			out.print("Case " + it + ": ");
			int n = in.nextInt();
			int k = in.nextInt();
			if (n % 2 == 1 || k == 0) {
				out.println(0);
				continue;
			}
			int[] mod = new int[n + 1];
			long pow = 1;
			for (int i = 0; i <= n; i++) {
				mod[i] = (int) (pow % k);
				pow *= 2;
			}
			long[][][] f = new long[n][n][k];
			f[0][0][0] = 1;
			f[0][1][mod[0]] = 1;
			for (int i = 1; i < n; i++) {
				for (int numOnes = 0; numOnes <= n / 2; numOnes++) {
					for (int remain = 0; remain < k; remain++) {
						f[i][numOnes + 1][(remain + mod[i]) % k] += f[i - 1][numOnes][remain];
					}
				}
				if(i == n - 1) continue;
				for (int numOnes = 0; numOnes <= n / 2; numOnes++) {
					for (int remain = 0; remain < k; remain++) {
						f[i][numOnes][remain] += f[i - 1][numOnes][remain];
					}
				}
			}
			out.println(f[n - 1][n / 2][0]);
		}
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
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

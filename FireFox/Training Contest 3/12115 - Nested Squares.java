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
	int n;

	public void solve(int caseNum, InputReader in, PrintWriter out) {
		int T = in.nextInt();
		for (int id = 1; id <= T; id++) {
			char[] s = in.next().toCharArray();
			int len = s.length * 2 - 1;
			int mid = len / 2;
			int q = in.nextInt();
			out.println("Square " + id + ":");
			for (int i = 0; i < q; i++) {
				int fx = in.nextInt() - 1;
				int fy = in.nextInt() - 1;
				int tx = in.nextInt() - 1;
				int ty = in.nextInt() - 1;
				out.println("Query " + (i + 1) + ":");
				for (int x = fx; x <= tx; x++) {
					for (int y = fy; y <= ty; y++) {
						int row = x <= mid ? x : len - x - 1;
						int col = y <= mid ? y : len - y - 1;
						if (col < row) {
							out.print(s[col]);
						} else {
							out.print(s[row]);
						}
					}
					out.println();
				}

			}
			out.println();
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

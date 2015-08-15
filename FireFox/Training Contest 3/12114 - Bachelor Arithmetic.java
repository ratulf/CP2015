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
		long b, s;
		StringBuilder res = new StringBuilder();
		int cnt = 1;
		while ((b = in.nextLong()) != 0 && (s = in.nextLong()) != 0) {
			res.append("Case " + cnt++ + ": ");
			if (s >= b && b != 1) {
				res.append(":-|");
			} else {
				if (b == 1) {
					res.append(":-\\");
				} else {
					if (BigDecimal.valueOf((s - 1) / (b - 1)).compareTo(
							BigDecimal.valueOf(1.0 * s / b)) > 0) {
						res.append(":-)");
					} else {
						res.append(":-(");
					}
				}
			}
			res.append("\n");
		}
		out.print(res);
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

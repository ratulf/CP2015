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
		StringBuilder res = new StringBuilder();
		String[] result = { "", "", "1/2", "2/6", "9/24", "44/120", "265/720",
				"1854/5040", "14833/40320", "133496/362880", "1334961/3628800",
				"14684570/39916800", "176214841/479001600" };
		while (T-- > 0) {
			res.append(result[in.nextInt()]);
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

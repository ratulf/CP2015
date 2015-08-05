import java.io.*;
import java.util.*;

public class Main {
	static boolean isMultiTestcase = false;

	public static void main(String[] args) {
		InputStream iStream = System.in;
		OutputStream oStream = System.out;
		InputReader in = new InputReader(iStream);
		PrintWriter out = new PrintWriter(oStream);
		Task solver = new Task();
		if (isMultiTestcase) {
			int numberOfTestcases = in.nextInt();
			for (int i = 1; i <= numberOfTestcases; i++) {
				solver.solve(i, in, out);
			}
		} else {
			solver.solve(1, in, out);
		}
		out.close();
	}
}

// 12015
class Task {
	public void solve(int testcaseNumber, InputReader in, PrintWriter out) {
		final int MAX = (int) 1e5 + 1;
		long[] d = new long[MAX];
		long[] o = new long[MAX];
		for (int i = 1; i < MAX; i++) {
			for (int j = 1; i * j < MAX; j++) {
				d[i * j]++;
				o[i * j] += i;
			}
		}
		int numCase = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while (numCase-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			long g = 0;
			long h = 0;
			for (int i = a; i <= b; i++) {
				if (i % k == 0) {
					g += d[i];
					h += o[i];
				}
			}
			sb.append(g + " " + h + "\n");
		}
		out.print(sb);
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

	public String nextLine() {
		String s = null;
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDoule() {
		return Double.parseDouble(next());
	}
}

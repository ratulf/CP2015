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
		while (true) {
			char n[] = in.next().toCharArray();
			if (n.length == 1 && n[0] == '0') {
				break;
			}

			int length = n.length;
			solver.solve(n, in, out);
		}
		out.close();
	}
}

// 12015
class Task {
	public void solve(char[] a, InputReader in, PrintWriter out) {
		int length = a.length;
		int left = 0;
		if (length % 2 == 0) {
			int firstTwo = (a[0] - '0') * 10 + a[1] - '0';
			int i = 1;
			while (i * i <= firstTwo)
				i++;
			out.print(i - 1);
			left = length / 2 - 1;

		} else {
			if (a[0] == '9') {
				out.print(3);
			} else if (a[0] >= '4') {
				out.print(2);
			} else {
				out.print(1);

			}
			left = length / 2;
		}
		for (int i = 0; i < left; ++i) {
			out.print(0);
		}
		out.println();
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

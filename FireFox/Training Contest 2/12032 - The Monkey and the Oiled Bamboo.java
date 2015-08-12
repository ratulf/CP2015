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
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int arr[] = new int[n + 1];
			arr[0] = 0;
			for (int j = 1; j <= n; ++j) {
				arr[j] = in.nextInt();
			}

			int k = 0;
			k = arr[n] - arr[n - 1];
			for (int j = n - 2; j >= 0; --j) {
				if (k < arr[j + 1] - arr[j]) {
					k = arr[j + 1] - arr[j];
				} else if (k == arr[j + 1] - arr[j]) {
					k++;
				}
			}
			k = Math.max(k, arr[0] + 1);
			out.println("Case " + i + ": " + k);

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

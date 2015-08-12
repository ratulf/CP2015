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
		String s;
		int[] value = new int[300];
		value['W'] = 64;
		value['H'] = 32;
		value['Q'] = 16;
		value['E'] = 8;
		value['S'] = 4;
		value['T'] = 2;
		value['X'] = 1;
		while ((s = in.next()).length() > 1) {
			int count = 0;
			int length = s.length();
			int curV = 0;
			for (int j = 1; j < length; ++j) {
				if (s.charAt(j) == '/') {
					if (curV == 64) {
						count++;
					}
					curV = 0;
				} else {
					curV += value[s.charAt(j)];
				}
			}
			out.println(count);
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

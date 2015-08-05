import java.io.*;
import java.util.*;

public class Main {
	static boolean isMultiTestcase = true;

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
		out.println("Case #" + testcaseNumber + ":");
		Rate[] r = new Rate[10];
		for (int i = 0; i < 10; i++) {
			r[i] = new Rate();
			r[i].web = in.next();
			r[i].rate = in.nextInt();
		}
		Arrays.sort(r);
		for (int i = 0; i < 10; i++) {
			if (r[i].rate != r[0].rate)
				break;
			out.println(r[i].web);
		}
	}

	class Rate implements Comparable<Rate> {
		String web;
		int rate;

		@Override
		public int compareTo(Rate o) {
			return o.rate - this.rate;
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

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

// 12085
class Task {
	public void solve(int testcaseNumber, InputReader in, PrintWriter out) {
		int n;
		StringBuilder res = new StringBuilder();
		int it = 0;
		while ((n = in.nextInt()) != 0) {
			++it;
			List<List<Long>> list = new ArrayList<List<Long>>();
			List<Long> cur = new ArrayList<Long>();
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				String foo = in.next();
				a[i] = Long.parseLong(foo);
				if (i == 0) {
					cur.add(a[i]);
				} else {
					if (a[i] == a[i - 1] + 1) {
						cur.add(a[i]);
					} else {
						list.add(cur);
						cur = new ArrayList<Long>();
						cur.add(a[i]);
					}
				}
				if (i + 1 == n) {
					list.add(cur);
				}
			}
			res.append("Case " + it + ":\n");
			for (List<Long> l : list) {
				if (l.size() == 1) {
					res.append("0" + l.get(0));
				} else {
					res.append(process(l.get(0), l.get(l.size() - 1)));
				}
				res.append("\n");
			}
			res.append("\n");
		}
		out.print(res);
	}

	String process(long a, long b) {
		StringBuilder res = new StringBuilder();
		res.append("0");
		res.append(a);
		char[] ca = Long.toString(a).toCharArray();
		char[] cb = Long.toString(b).toCharArray();
		int i;
		for (i = 0; i < ca.length; i++) {
			if (ca[i] != cb[i])
				break;
		}
		res.append("-");
		for (; i < cb.length; i++) {
			res.append(cb[i]);
		}
		return res.toString();
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

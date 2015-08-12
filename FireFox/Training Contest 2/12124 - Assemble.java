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
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int it = 0; it < T; it++) {
			HashMap<String, Integer> com = new HashMap<String, Integer>();
			HashMap<Long, Integer> quaset = new HashMap<>();
			int n = in.nextInt();
			long budget = in.nextLong();
			String[] scom = new String[n];
			long[] price = new long[n];
			long[] quanlity = new long[n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				scom[i] = in.next();
				if (!com.containsKey(scom[i])) {
					com.put(scom[i], cnt);
					cnt++;
				}
				String name = in.next();
				price[i] = in.nextLong();
				quanlity[i] = in.nextLong();
				if (!quaset.containsKey(quanlity[i])) {
					quaset.put(quanlity[i], 1);
				}
			}
			List<Component>[] a = new List[cnt];
			for (int i = 0; i < cnt; i++) {
				a[i] = new ArrayList<>();
			}
			for (int i = 0; i < n; i++) {
				a[com.get(scom[i])].add(new Component(price[i], quanlity[i]));
			}
			long res = 0;
			for (long min : quaset.keySet()) {
				boolean good = true;
				long cost = 0;
				for (int i = 0; i < cnt && good; i++) {
					int size = a[i].size();
					long best = Long.MAX_VALUE;
					for (int j = 0; j < size; j++) {
						if (a[i].get(j).quanlity >= min) {
							best = Math.min(best, a[i].get(j).price);
						}
					}
					if (best == Long.MAX_VALUE) {
						good = false;
					} else {
						cost += best;
					}
				}
				if (cost <= budget && good) {
					res = Math.max(res, min);
				}
			}
			sb.append(res);
			sb.append("\n");
		}
		out.print(sb);
	}
}

class Component {
	long price;
	long quanlity;

	public Component(long price, long quanlity) {
		this.price = price;
		this.quanlity = quanlity;
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

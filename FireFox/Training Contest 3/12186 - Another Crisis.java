import java.io.*;
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
	List<Integer>[] g;

	public void solve(int caseNum, InputReader in, PrintWriter out) {
		StringBuilder res = new StringBuilder();
		int n, T;
		while ((n = in.nextInt()) != 0 && (T = in.nextInt()) != 0) {
			g = new List[n + 1];
			for (int i = 0; i <= n; i++) {
				g[i] = new ArrayList<Integer>();
			}
			for (int i = 1; i <= n; i++) {
				int boss = in.nextInt();
				g[boss].add(i);
			}
			res.append(dfs(0, T));
			res.append("\n");
		}
		out.print(res);
	}

	int dfs(int u, int T) {
		int res = 0;
		if (g[u].size() == 0)
			return 1;
		List<Integer> a = new ArrayList<Integer>();
		for (int v : g[u]) {
			a.add(dfs(v, T));
		}
		Collections.sort(a);
		int need = (a.size() * T + 99) / 100;
		for (int i = 0; i < need; i++) {
			res += a.get(i);
		}
		return res;
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

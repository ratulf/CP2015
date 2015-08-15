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
	List<Integer> primes;

	public void solve(int caseNum, InputReader in, PrintWriter out) {
		int T = in.nextInt();
		generatePrimes(10000);
		int n = primes.size();
		HashSet<Integer>[] sets = new HashSet[n];
		List<Edge>[] g = new List[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sets[i] = new HashSet<>();
			g[i] = new ArrayList<Edge>();
			map.put(primes.get(i), i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (canGo(primes.get(i), primes.get(j)) && !sets[i].contains(j)) {
					sets[i].add(j);
					sets[j].add(i);
					g[i].add(new Edge(j, 1));
					g[j].add(new Edge(i, 1));
				}
			}
		}
		while (T-- > 0) {
			int start = in.nextInt();
			int target = in.nextInt();
			int[] dis = new int[n];
			shortestPaths(g, map.get(start), dis, new int[n]);
			out.println(dis[map.get(target)]);
		}
	}

	boolean canGo(int a, int b) {
		if (a == b)
			return false;
		char[] aa = Integer.toString(a).toCharArray();
		char[] bb = Integer.toString(b).toCharArray();
		int dif = 0;
		for (int i = 0; i < aa.length; i++) {
			if (aa[i] != bb[i])
				++dif;
		}
		return dif < 2;
	}

	public void generatePrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, 2, n + 1, true);
		for (int i = 2; i * i <= n; i++)
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
		primes = new ArrayList<Integer>();
		for (int i = 0; i < prime.length; i++)
			if (prime[i] && i > 1000)
				primes.add(i);

	}

	void shortestPaths(List<Edge>[] edges, int s, int[] prio, int[] pred) {
		Arrays.fill(pred, -1);
		Arrays.fill(prio, Integer.MAX_VALUE);
		prio[s] = 0;
		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add((long) s);
		while (!q.isEmpty()) {
			long cur = q.remove();
			int curu = (int) cur;
			if (cur >>> 32 != prio[curu])
				continue;
			for (Edge e : edges[curu]) {
				int v = e.t;
				int nprio = prio[curu] + e.cost;
				if (prio[v] > nprio) {
					prio[v] = nprio;
					pred[v] = curu;
					q.add(((long) nprio << 32) + v);
				}
			}
		}
	}
}

class Edge {
	int t, cost;

	public Edge(int t, int cost) {
		this.t = t;
		this.cost = cost;
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

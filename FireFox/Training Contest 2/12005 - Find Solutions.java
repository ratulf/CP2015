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
	int[] primes;

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		final int MAX = 2 * ((int) 1e7);
		primes = generatePrimes(MAX);
		StringBuilder res = new StringBuilder();
		long n;
		while ((n = in.nextLong()) != 0) {
			res.append(n + " " + calc(4 * n - 3));
			res.append("\n");
		}
		out.print(res);
	}

	long calc(long n) {
		long res = 1;
		int sz = primes.length;
		for (int i = 0; i < sz && n >= primes[i] * primes[i]; i++) {
			int num = primes[i];
			int count = 0;
			while (n % num == 0) {
				count++;
				n /= num;
			}
			res *= (count + 1);
		}
		if (n != 1) {
			res *= 2;
		}
		return res;
	}

	public int[] generatePrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, 2, n + 1, true);
		for (int i = 2; i * i <= n; i++)
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
		int[] primes = new int[n + 1];
		int cnt = 0;
		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				primes[cnt++] = i;

		return Arrays.copyOf(primes, cnt);
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

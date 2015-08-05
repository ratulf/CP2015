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

class Task {
	static long MOD = 100000000007l;

	public void solve(int testcaseNumber, InputReader in, PrintWriter out) {
		MOD = 100000000007l;

		int n = in.nextInt();
		int x = in.nextInt();
		int m = in.nextInt();
		int y = in.nextInt();
		int k = in.nextInt();

		long a = fib(n);
		long b = fib(n + 1);
		long c = fib(m);
		long d = fib(m + 1);

		if (n >= 45 || m >= 45) {
			out.println("Impossible");
			return;
		}

		long tempB = b * c;
		long tempX = x * c;
		long tempD = a * d;
		long tempY = a * y;
		long left = tempB - tempD;
		long right = tempX - tempY;

		if (right % left != 0) {
			out.println("Impossible");
			return;
		}
		long q = right / left;
		if (q < 0) {
			out.println("Impossible");
			return;
		}

		long i = x - b * q;
		if (i % a != 0) {
			out.println("Impossible");
			return;
		}

		long p = i / a;
		if (p < 0) {
			out.println("Impossible");
			return;
		}
		MOD = 1000000007;
		long result = fib(k) * p + fib(k + 1) * q;
		out.println(result % 1000000007);
	}

	static long[][] res = new long[][] { { 1, 0 }, { 0, 1 } };
	static long[][] tmp = new long[][] { { 1, 1 }, { 1, 0 } };

	private static long fib(long n) {
		res = new long[][] { { 1, 0 }, { 0, 1 } };
		tmp = new long[][] { { 1, 1 }, { 1, 0 } };
		if (n <= 1)
			return n;

		while (n > 0) {
			if ((n & 1) == 1) {
				res = mulMatrix(res, tmp);
			}
			n >>= 1;
			tmp = mulMatrix(tmp, tmp);
		}
		return res[0][1];
	}

	private static long[][] mulMatrix(long[][] a, long[][] b) {
		long[][] res = new long[][] { { 0, 0 }, { 0, 0 } };
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					res[i][j] = res[i][j] + a[i][k] * b[k][j];
					res[i][j] = res[i][j]%MOD;

				}
			}
		}
		return res;
	}

}

class InputReader {
	InputStream is;
	byte[] inbuf = new byte[1024];
	int lenbuf = 0, ptrbuf = 0;

	public InputReader(InputStream stream) {
		is = stream;
	}

	int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	double nd() {
		return Double.parseDouble(ns());
	}

	char nc() {
		return (char) skip();
	}

	String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	int nextInt() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}

import java.io.*;
import java.util.*;

public class Main {
	static boolean isMultiTest = true;

	public static void main(String[] args) {
		OutputStream outputStream = System.out;
		InputStream inputStream = System.in;
		InputFast in = new InputFast();
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		if (isMultiTest) {
			int testNumber = in.nextInt();
			for (int i = 1; i <= testNumber; i++) {
				solver.solve(i, in, out);
			}
		} else {
			solver.solve(1, in, out);
		}
		out.close();
	}
}

class Task {
	long[] f;
	String[] fs;

	public void solve(int testNumber, InputFast in, PrintWriter out) {
		int n = in.nextInt();
		int from = in.nextInt();
		int to = in.nextInt();
		fs = new String[22];
		f = new long[50];
		fs[0] = "0";
		fs[1] = "1";
		f[0] = f[1] = 1L;
		for (int i = 2; i < 50; i++) {
			if (i <= 21) {
				fs[i] = fs[i - 2] + fs[i - 1];
			}
			f[i] = f[i - 2] + f[i - 1];
		}
		if (n > 21) {
			if ((n & 1) == 0)
				n = 48;
			else
				n = 49;
		}
		String ans = rec(n, from, to);
		out.println(ans);
	}

	private String rec(int cur, long from, long to) {
		if (cur <= 21) {
			return fs[cur].substring((int) from, (int) to + 1);
		}
		long left = f[cur - 2];
		StringBuilder sb = new StringBuilder();
		if (to < left) {
			sb.append(rec(cur - 2, from, to));
		} else if (from < left) {
			sb.append(rec(cur - 2, from, left - 1));
			sb.append(rec(cur - 1, 0, to - left));
		} else {
			sb.append(rec(cur - 1, from - left, to - left));
		}
		return sb.toString();
	}
}

class InputFast {
	static InputStream is = System.in;
	static private byte[] buffer = new byte[1024];
	static private int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(buffer);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return buffer[ptrbuf++];
	}

	private boolean isSpace(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public char nextChar() {
		return (char) read();
	}

	public String next() {
		int b = read();
		StringBuilder sb = new StringBuilder();
		while (!(isSpace(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public char[] next(int n) {
		char[] buf = new char[n];
		int b = read(), p = 0;
		while (p < n && !(isSpace(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	public int nextInt() {
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

	public long nextLong() {
		long num = 0;
		int b;
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

class Input {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public Input(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
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

	public String nextLine() {
		String s = "";
		try {
			s = reader.readLine();
		} catch (IOException e) {
			try {
				throw new IOException();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return s;
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

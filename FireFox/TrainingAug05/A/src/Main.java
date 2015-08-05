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

// 12049
class Task {
	public void solve(int testcaseNumber, InputReader in, PrintWriter out) {
		int[] n = new int[2];
		for (int i = 0; i < n.length; i++) {
			n[i] = in.nextInt();
		}
		HashMap<Integer, Integer>[] a = new HashMap[2];
		HashMap<Integer, Integer> has = new HashMap<Integer, Integer>();
		for (int i = 0; i < n.length; i++) {
			a[i] = new HashMap<Integer, Integer>();
			for (int j = 0; j < n[i]; j++) {
				int foo = in.nextInt();
				if (!has.containsKey(foo))
					has.put(foo, 1);
				int have = 0;
				if (a[i].containsKey(foo)) {
					have = a[i].get(foo);
				}
				a[i].put(foo, have + 1);
			}
		}
		int res = 0;
		for (int key : has.keySet()) {
			int have1 = 0;
			int have2 = 0;
			if (a[0].containsKey(key))
				have1 = a[0].get(key);
			if (a[1].containsKey(key))
				have2 = a[1].get(key);
			res += Math.abs(have1 - have2);
		}
		out.println(res);
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

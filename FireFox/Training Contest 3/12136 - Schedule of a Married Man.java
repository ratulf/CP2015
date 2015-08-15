import java.io.*;
import java.math.BigDecimal;
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
	public void solve(int caseNum, InputReader in, PrintWriter out) {
		int T = in.nextInt();
		for (int it = 1; it <= T; it++) {
			int fromTimeForWife = parseToMunutes(in.next());
			int toTimeForWife = parseToMunutes(in.next());
			int fromTimeForMeeting = parseToMunutes(in.next());
			int toTimeForMeeting = parseToMunutes(in.next());
			String ans = "Hits Meeting";
			if (toTimeForWife < toTimeForMeeting) {
				if (toTimeForWife >= fromTimeForMeeting) {
					ans = "Mrs Meeting";
				}
			} else {
				if (toTimeForMeeting >= fromTimeForWife) {
					ans = "Mrs Meeting";
				}
			}

			out.println("Case " + it + ": " + ans);
		}
	}

	private int parseToMunutes(String s) {
		int hour = Integer.parseInt(s.substring(0, s.indexOf(":")));
		int minute = Integer.parseInt(s.substring(s.indexOf(":") + 1,
				s.length()));
		return hour * 60 + minute;
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

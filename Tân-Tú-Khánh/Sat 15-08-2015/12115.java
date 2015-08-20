import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		StringBuilder result = new StringBuilder();
		int t = in.nextInt();
		int iT = 1;
		while (iT <= t) {
			result.append("Square " + iT + ":\n");
			String sample = in.next();
			int n = sample.length();
			char c[] = sample.toCharArray();
			int q = in.nextInt();
			for (int i = 1; i <= q; i++) {
				result.append("Query " + i + ":\n");
				int x1 = in.nextInt();
				int y1 = in.nextInt();
				int x2 = in.nextInt();
				int y2 = in.nextInt();
				for (int x = x1; x <= x2; x++) {
					for (int y = y1; y <= y2; y++) {
						int sX = x > n ? 2 * n - x : x;
						int sY = y > n ? 2 * n - y : y;
						result.append(c[Math.min(sX, sY)-1]);
					}
					result.append("\n");
				}
			}
			result.append("\n");
			iT++;
		}
		System.out.println(result);
	}
}

class InputReader {
	StringTokenizer tokenizer;
	BufferedReader reader;

	public InputReader(InputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
	}

	public String next() {
		while ((tokenizer == null) || !tokenizer.hasMoreTokens()) {
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
}

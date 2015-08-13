package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem12157 {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int test = in.nextInt();
		for (int i = 1; i <= test; i++) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = in.nextInt();
			}
			int mile = 0;
			int juice = 0;
			for (int j = 0; j < n; j++) {
				mile += (a[j] / 30 + 1) * 10;
				juice += (a[j] / 60 + 1) * 15;
			}
			if (mile < juice) {
				System.out.println("Case " + i + ": Mile " + mile);
			} else if (mile == juice) {
				System.out.println("Case " + i + ": Mile Juice " + mile);
			} else {
				System.out.println("Case " + i + ": Juice " + juice);
			}
		}
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

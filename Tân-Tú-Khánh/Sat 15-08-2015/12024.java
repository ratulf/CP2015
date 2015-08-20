import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int t = in.nextInt();
		long dp[] = new long[13];
		long fact[] = new long[13];
		fact[2] = 2;
		fact[3] = 6;
		dp[2] = 1;
		dp[3] = 2;
		for (int i = 4; i < 13; i++) {
			dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
			fact[i] = i * fact[i - 1];
		}
		while (t > 0) {
			int x = in.nextInt();
			System.out.println(dp[x] + "/" + fact[x]);
			t--;
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

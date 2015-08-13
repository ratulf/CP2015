package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem12149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

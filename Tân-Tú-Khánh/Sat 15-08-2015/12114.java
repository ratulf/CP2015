package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int number = 1;
		while (true) {
			int b = in.nextInt();
			int s = in.nextInt();
			if (b == 0 && s == 0) {
				break;
			}
			if(b-1 == 0){
				System.out.println("Case " + number + ": " + ":-\\");
				number++;
				continue;
			}
			double m = ((double) s / b) >= 1 ? 1 : (double) s / b;
			double n = ((double) (s-1) / (b-1)) >= 1 ? 1 : (double) (s-1) / (b-1);
			if(m == n){
				System.out.println("Case " + number + ": " + ":-|");
				number++;
			}
			else if(m < n){
				System.out.println("Case " + number + ": " + ":-)");
				number++;
			}
			else{
				System.out.println("Case " + number + ": " + ":-(");
				number++;
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

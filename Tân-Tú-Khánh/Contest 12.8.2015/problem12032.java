package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class problem12032 {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
			int test = in.nextInt();
			for(int i = 1; i <= test; i++){
				int n = in.nextInt();
				int a[] = new int[n+1];
				for (int j = 1; j <= n; j++) {
					a[j] = in.nextInt();
				}
				int max = Integer.MIN_VALUE;
				for (int j = 1; j <= n; j++) {
					if(a[j] - a[j-1] > max){
						max = a[j] - a[j-1];
					}
				}
				int res = max;
				for(int j = 1; j < n+1; j++){
					if(max == a[j] - a[j-1]){
						max--;
					}
					else if(a[j] - a[j-1] > max){
						res++;
					}
				}
				System.out.println("Case " + i + ": " + res);
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

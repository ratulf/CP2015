import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		while (n > 0) {
			n++;
			int percent = in.nextInt();
			Employee[] p = new Employee[n];
			for (int i = 0; i < n; i++) {
				p[i] = new Employee();
			}
			for (int i = 1; i < n; i++) {
				int x = in.nextInt();
				p[x].sub.add(i);
			}
			System.out.println(rec(p, 0, percent));
			n = in.nextInt();
		}
	}

	private static int rec(Employee[] p, int b, int percent) {
		int n = p[b].sub.size();
		if (n == 0) {
			return 1;
		}
		int r = 0;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = rec(p, p[b].sub.get(i), percent);
		}
		Arrays.sort(a);
		int cell = (int) Math.ceil((float)n / 100 * percent);
		for (int i = 0; i < cell; i++) {
			r += a[i];
		}
		return r;
	}
}

class Employee {
	ArrayList<Integer> sub = null;

	public Employee() {
		sub = new ArrayList<>();
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

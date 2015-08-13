package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem12108 {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		StringBuilder result = new StringBuilder();
		int casei = 1;
		while (n > 0) {
			// init
			HashSet<String> saved = new HashSet<String>();
			Period[] periods = new Period[n];
			boolean found = false;
			long wait = 1;
			int[] states = new int[n];
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				periods[i] = new Period(a, a + b);
				states[i] = in.nextInt();
			}

			int cSleep = countSleep(states, n, periods);
			// handle the 0 sit
			if (cSleep == 0) {
				found = true;
				result.append("Case " + casei + ": " + wait + "\n");
			}
			wait++;
			// init + save states
			String save = parse(states, n);
			saved.add(save);
			while (!found) {
				int[] nextstates = new int[n];
				boolean willSleep = false;
				if (cSleep * 2 > n) {
					willSleep = true;
				}
				// calculate next states
				for (int i = 0; i < n; i++) {
					if (states[i] == periods[i].decide) {
						if (willSleep) {
							nextstates[i] = states[i] + 1;
						} else {
							nextstates[i] = 1;
						}
					} else if (states[i] == periods[i].end) {
						nextstates[i] = 1;
					} else {
						nextstates[i] = states[i] + 1;
					}
				}
				for (int i = 0; i < n; i++) {
					states[i] = nextstates[i];
					// System.out.print(states[i] + " ");
				}
				// System.out.println();
				// Handle infinite loot
				save = parse(states, n);
				if (saved.contains(save)) {
					result.append("Case " + casei + ": " + -1 + "\n");
					found = true;
				} else {
					saved.add(save);
				}
				cSleep = countSleep(states, n, periods);
				if (cSleep == 0) {
					result.append("Case " + casei + ": " + wait + "\n");
					found = true;
				}
				wait++;
			}
			casei++;
			n = in.nextInt();
		}
		System.out.print(result);
	}

	static int countSleep(int s[], int n, Period p[]) {
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (s[i] > p[i].decide) {
				c++;
			}
		}
		return c;
	}

	static String parse(int a[], int n) {
		String r = "";
		for (int i = 0; i < n; i++) {
			r += a[i] + "-";
		}
		return r;
	}
}

class Period {
	int decide = 0;
	int end = 0;

	public Period(int d, int e) {
		this.decide = d;
		this.end = e;
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

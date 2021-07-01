import java.util.*;
import java.io.*;

public class CoinPiles {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder outputBuffer = new StringBuilder();

		int tests = reader.nextInt();
		while (tests > 0) {
			int coin1 = reader.nextInt();
			int coin2 = reader.nextInt();

			int max = Integer.max(coin1, coin2);
			int min = Integer.min(coin1, coin2);

			if ((max != 0 && min == 0) || ((float) max / min > 2)) {
				outputBuffer.append("NO\n");
			} else {
				if ((max % 3 == 2 && min % 3 == 1) || (min % 3 == 2 && max % 3 == 1)
						|| (min % 3 == 0 && max % 3 == 0)) {
					outputBuffer.append("YES\n");
				} else {
					outputBuffer.append("NO\n");
				}
			}
			tests--;
		}
		System.out.println(outputBuffer);
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}

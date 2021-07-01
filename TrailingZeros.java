import java.util.*;
import java.io.*;

public class TrailingZeros {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder outputBuffer = new StringBuilder();

		int number = reader.nextInt();
		long result = 0;
		int pow = 1;

		while (number >= 5 && number >= Math.pow(5, pow)) {
			result = result + number / ((long) Math.pow(5, pow));
			pow++;
		}

		outputBuffer.append(result);
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

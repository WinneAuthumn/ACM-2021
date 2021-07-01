import java.util.*;
import java.io.*;

public class BitStrings {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder outputBuffer = new StringBuilder();

		long number = reader.nextLong();
		long devided = (long) (Math.pow(10, 9) + 7);
		long count = 0;
		long result = 1;

		if (number == 1) {
			result = 2;
		} else {
			while (count < number) {
				result = (result * 2) % devided ;
				count++;
			}
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

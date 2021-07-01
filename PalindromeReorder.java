import java.util.*;
import java.io.*;

public class PalindromeReorder {

	public static void main(String[] args) {
		StringBuilder outputBuffer = new StringBuilder();
		String text = ns();
		int length = text.length();

		char[] list = text.toCharArray();
		Arrays.sort(list);
		text = String.valueOf(list);
		List<CountChar> listChar = new ArrayList<>();
		CountChar charOdd = new CountChar('a', 1);
		int countOdd = 0;
		boolean flag = false;

		for (int i = 0; i < length;) {
			int temp = text.lastIndexOf(list[i]) - i + 1;
			if (temp % 2 == 1) {
				countOdd++;
				charOdd.character = list[i];
				charOdd.count = i;
				if (countOdd > 1) {
					outputBuffer.append("NO SOLUTION");
					flag = true;
					break;
				}
				i++;
			} else {
				listChar.add(new CountChar(list[i], temp));
				i += temp;
			}
		}

		if (!flag) {
			StringBuilder result = new StringBuilder(text);
			if (charOdd.character != 'a') {
				result.deleteCharAt(charOdd.count);
			}
			int position = 0;
			for (int i = 0; i < listChar.size(); i++) {
				int temp = listChar.get(i).count / 2 + position;
				result.delete(position, temp);
				position += temp - position;
			}

			String reverse = new StringBuffer(result).reverse().toString();
			outputBuffer.append(result);
			if (charOdd.character != 'a') {
				outputBuffer.append(String.valueOf(charOdd.character));
			}
			outputBuffer.append(reverse);
		}

		System.out.println(outputBuffer);
	}

	static class CountChar {
		public char character;
		public int count;

		public CountChar(char c, int count) {
			this.character = c;
			this.count = count;
		}
	}

	static InputStream is = System.in;

	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static float nf() {
		return Float.parseFloat(ns());
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}

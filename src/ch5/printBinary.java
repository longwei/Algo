package ch5;

/*
 * 
 */
public class printBinary {

	public static String printBinary(double num) {
		if (num >= 1 || num < 0)
			return "ERROR";
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}

		}
		return binary.toString();
	}

	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(bs);

		for (int i = 0; i <= 500; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			if (!binary.equals("ERROR")) {
				System.out.println(num + " : " + binary);
			}
		}

	}

}

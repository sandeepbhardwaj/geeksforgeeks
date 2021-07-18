package com.koko.string;

/**
 * 65 to 90 => UpperCase A to Z
 * 97 to 122 => LowerCase a to z
 */
public class SimpleCipher {

	// (A,1) = Z
	public static String leftRotate(String str, int d) {
		StringBuilder result = new StringBuilder();
		d = d % 26;
		for (Character ch : str.toCharArray()) {
			if (!Character.isAlphabetic(ch)) {
				result.append(ch);
				continue;
			}
			//left rotate
			int index = ch - d;

			if ((Character.isUpperCase(ch) && index < 'A') || (Character.isLowerCase(ch) && index < 'a')) {
				index = index + 26;
			}
			result.append((char) index);
		}
		return result.toString();
	}

	//(Z,1) = A
	public static String rightRotate(String str, int d) {
		StringBuilder result = new StringBuilder();
		d = d % 26;
		for (Character ch : str.toCharArray()) {
			if (!Character.isAlphabetic(ch)) {
				result.append(ch);
				continue;
			}
			//rotate right
			int index = ch + d;

			//index moves to out of max range then reduce to 26 char
			if ((Character.isUpperCase(ch) && index > 90) || (Character.isLowerCase(ch) && index > 122)) {
				index = index - 26;
			}
			result.append((char) index);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println("Left Rotate (A,2):" + leftRotate("A", 2) + ", Right Rotate (Y,2):" + rightRotate("Y", 2));
	}

}
package cl.hotoffer.test;

import java.security.MessageDigest;

public class Test {

	public static void main(String[] args) throws Exception {

		String password = "1asdas";

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		System.out.println("Hex format : " + sb.toString());
		System.out.println("Hex format : " + sb.length());

	}
}

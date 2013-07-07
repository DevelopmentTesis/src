package cl.hotoffer.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptaKey {

	private EncriptaKey() {

	}

	public static String encriptar(String key) {
		MessageDigest md;
		StringBuffer sb = null;
		try {
			md = MessageDigest.getInstance("SHA-256");

			md.update(key.getBytes());

			byte byteData[] = md.digest();

			sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}

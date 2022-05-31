import java.security.MessageDigest;
import java.util.*;
import java.security.NoSuchAlgorithmException;

public class Sha256_2 {
	public static String hash(String input) throws NoSuchAlgorithmException{
		String result;
		MessageDigest md  = MessageDigest.getInstance("SHA-256");
		md.update(input.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b :digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		result =sb.toString();
		return result;
		
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.print(Sha256_2.hash("asdasdsd"));
		// TODO Auto-generated method stub

	}

}
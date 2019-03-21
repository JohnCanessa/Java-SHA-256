import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
 * 
 */
public class Solution {
	
	/*
	 * Convert byte array to hex.
	 */
	public static String byteArrayToHex(byte[] s) {
		StringBuilder sb = new StringBuilder(s.length * 2);
		for(byte b: s)
			sb.append(String.format("%02x", b));
		return sb.toString();
	}

	
	/*
	 * Enter your code here. Read input from STDIN. Print output to STDOUT.
	 */
	public static void main(String[] args) {

		// **** select a digest algorithm ****
//		final String DIGEST_ALGORITHM	= "MD5";
//		final String DIGEST_ALGORITHM	= "SHA-1";
//		final String DIGEST_ALGORITHM	= "SHA-224";
		final String DIGEST_ALGORITHM	= "SHA-256";	
//		final String DIGEST_ALGORITHM	= "SHA-384";
//		final String DIGEST_ALGORITHM	= "SHA-512";

		// **** open scanner ****
		Scanner sc = new Scanner(System.in);
		
		// **** read string ****
		String s = sc.nextLine();
		
//		System.out.println("s ==>" + s + "<==");
		
		// **** convert string to byte array ****
		byte[] sb = null;
		try {
			sb = s.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// **** instantiate the message digest ****
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(DIGEST_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
//		System.out.println("DIGEST_ALGORITHM: " + DIGEST_ALGORITHM);
		
		// **** generate the digest ****
		byte[] digest = md.digest(sb);
		
//		System.out.println("digest.length: " + digest.length);
		
		// **** display the digest in hex ****
		System.out.println(byteArrayToHex(digest));

		// **** close scanner ****
		sc.close();
	}

}

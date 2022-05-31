import java.security.*;
import java.util.Base64;
public class PublicPrivateKey {

	public static void main(String[] args) throws NoSuchAlgorithmException  {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		Base64.Encoder encode = Base64.getEncoder();
		KeyPair kp = kpg.generateKeyPair();	
		byte[] pub = kp.getPublic().getEncoded();
		byte[] pvt = kp.getPrivate().getEncoded();
		System.out.println("public: "+encode.encodeToString(pub).substring(0,10));
		System.out.println("private: "+encode.encodeToString(pvt));

	}

}
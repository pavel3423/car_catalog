package by.htp.car_catalog.service.util.sequrity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private Hash() {
    }

    public static String getHash(String password, String salt) throws NoSuchAlgorithmException {
	String passWithSalt = password + salt;
	MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
	byte[] passBytes = passWithSalt.getBytes();
	byte[] passHash = sha256.digest(passBytes);
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < passHash.length; i++) {
	    sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));
	}
	return sb.toString();
    }

}

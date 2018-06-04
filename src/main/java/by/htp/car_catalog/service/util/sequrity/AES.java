package by.htp.car_catalog.service.util.sequrity;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;

import by.htp.car_catalog.web.util.WebConstantDeclaration;

public class AES {
    private static final String ENCODING = "UTF-8";
    private static final String KEY;
    private static final String VECTOR;

    static {
	KEY = readFile(WebConstantDeclaration.ROOT + "\\key.crypt");
	VECTOR = readFile(WebConstantDeclaration.ROOT + "\\vector.crypt");
    }

    private AES() {
    }

    public static String encrypt(String value) throws UnsupportedEncodingException, GeneralSecurityException {

	IvParameterSpec iv = new IvParameterSpec(VECTOR.getBytes(ENCODING));
	SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(ENCODING), "AES");

	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	byte[] encrypted = cipher.doFinal(value.getBytes());

	return Base64.encodeBase64String(encrypted);
    }

    public static String decrypt(String encrypted) throws UnsupportedEncodingException, GeneralSecurityException {

	IvParameterSpec iv = new IvParameterSpec(VECTOR.getBytes(ENCODING));
	SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(ENCODING), "AES");

	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

	byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

	return new String(original);

    }

    private static String readFile(String path) {
	File file = new File(path);
	StringBuilder sb = new StringBuilder();
	try (FileReader reader = new FileReader(file)) {
	    int c;
	    while ((c = reader.read()) != -1) {
		sb.append((char) c);
	    }
	} catch (IOException e) {
	    LogManager.getLogger().error("File read error" + file.getPath(), e);
	}
	return sb.toString();
    }
}

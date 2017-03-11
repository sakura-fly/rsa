package rsa;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Keys {
	public final String KEY_ALGORITHM = "RSA";
	private final String PUBLIC_KEY = "RSAPublicKey";
	private final String PRIVATE_KEY = "RSAPrivateKey";
	private final String MODULUS_KEY = "modulus";
	
	public String getModulus(Map<String, Object> keyMap){
		return keyMap.get(MODULUS_KEY).toString();
	}


	public String getPublicKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return (new BASE64Encoder()).encodeBuffer(key.getEncoded());
	}

	public String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return (new BASE64Encoder()).encodeBuffer(key.getEncoded());
	}



	/**
	 * 得到公钥
	 * 
	 * @param key
	 *            密钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	/**
	 * 得到私钥
	 * 
	 * @param key
	 *            密钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public PrivateKey getPrivateKey(String key) {
		PrivateKey privateKey = null;
		try {
			byte[] keyBytes;
			keyBytes = (new BASE64Decoder()).decodeBuffer(key);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return privateKey;
	}

	public Map<String, Object> initKey() {
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
			keyPairGen.initialize(1024);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
			BigInteger m = publicKey.getModulus();
			keyMap.put(PUBLIC_KEY, publicKey);
			keyMap.put(PRIVATE_KEY, privateKey);
			keyMap.put(MODULUS_KEY, m);
//			keyPairGen.g
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyMap;
	}
}

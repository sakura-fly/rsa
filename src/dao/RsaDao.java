package dao;

import java.util.Map;

import model.RSAmodel;
import rsa.Keys;
import rsa.RSAUtils;

public class RsaDao {
	public RSAmodel init(){
		RSAmodel rsa = new RSAmodel();     
		try {
			Keys k = new Keys();
			Map<String, Object> keys = k.initKey();
			String pukStr = k.getPublicKey(keys).replace("\r\n", "");
			String pirkStr = k.getPrivateKey(keys).replace("\r\n", "");  
			rsa.setPrikStr(pirkStr);
			rsa.setPukStr(pukStr);
			rsa.setPrik(k.getPrivateKey(pirkStr));
			rsa.setPuk(k.getPublicKey(pukStr));
			rsa.setModulus(k.getModulus(keys));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsa;
	}
	
	
	public RSAmodel decode(RSAmodel rsa){
		String res = "-1";
		try {
			RSAUtils ru = new RSAUtils();
			res = ru.decrypt(rsa.getCiphertext(), rsa.getPrik());
			rsa.setCleartext(res);
		} catch (Exception e) {
			e.printStackTrace();
			res = "";
		}
		return rsa;
	}
	
	public RSAmodel encode(RSAmodel rsa){
		try {
			RSAUtils ru = new RSAUtils();
			rsa.setCiphertext(ru.encrypt(rsa.getCleartext(), rsa.getPuk()));;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsa;
	}
	
}

package model;

import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAmodel {
	private PublicKey puk;
	private PrivateKey prik;
	private String pukStr;
	private String prikStr;
	private String ciphertext; //密文
	private String cleartext; //明文
	private String modulus;

	public String getModulus() {
		return modulus;
	}

	public void setModulus(String modulus) {
		this.modulus = modulus;
	}


	public String getCiphertext() {
		return ciphertext;
	}

	public void setCiphertext(String ciphertext) {
		this.ciphertext = ciphertext;
	}

	public String getCleartext() {
		return cleartext;
	}

	public void setCleartext(String cleartext) {
		this.cleartext = cleartext;
	}

	public PublicKey getPuk() {
		return puk;
	}

	public void setPuk(PublicKey puk) {
		this.puk = puk;
	}

	public PrivateKey getPrik() {
		return prik;
	}

	public void setPrik(PrivateKey prik) {
		this.prik = prik;
	}

	public String getPukStr() {
		return pukStr;
	}

	public void setPukStr(String pukStr) {
		this.pukStr = pukStr;
	}

	public String getPrikStr() {
		return prikStr;
	}

	public void setPrikStr(String prikStr) {
		this.prikStr = prikStr;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	private String uid;
}

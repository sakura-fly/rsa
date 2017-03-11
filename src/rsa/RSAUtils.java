package rsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

  
public class RSAUtils {  
	
	public final String KEY_ALGORITHM = "RSA";
	  /**
     * 加密函数
     * @param data  源数据,无编码
     * @return 加密后经过Base64编码的文本
     */
    public String encrypt(String data,Key publicKey){
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] dataByte = data.getBytes();
            byte[] outData = cipher.doFinal(dataByte);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(outData);


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    /**
     * 解密
     * @param encryptedData 加密后的base64编码数据
     * @param privateKey
     * @return 源文件字符串
     */
    public String decrypt(String encryptedData,Key privateKey){
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] data = decoder.decodeBuffer(encryptedData);
            byte[] decodedData  = cipher.doFinal(data);
            return new String(decodedData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

 
    
    
}  

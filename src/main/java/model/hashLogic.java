package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * ハッシュ化用アルゴリズム
 * @author ねこ
 *
 */
public class hashLogic {
	/**
	 * 引数をハッシュ化して返す
	 * @param pass ハッシュ化したい文字列
	 * @return ハッシュ化された文字列
	 */
	public String doHash(String pass) {
		String hash = null;
		//ハッシュ化処理
		byte[] cipher_byte;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pass.getBytes());
			cipher_byte = md.digest();
			StringBuffer sb = new StringBuffer(2 * cipher_byte.length);
			for (byte b : cipher_byte) {
				sb.append(String.format("%02x", b & 0xff));
			}
			hash = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hash;
	}
}

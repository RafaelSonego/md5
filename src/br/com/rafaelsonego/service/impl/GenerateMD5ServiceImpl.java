package br.com.rafaelsonego.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.rafaelsonego.service.GenerateMD5Service;

public class GenerateMD5ServiceImpl implements GenerateMD5Service{
	
	private static MessageDigest md = null;
	
    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
	
	@Override
	public String encryptPassword(String pwd) {
		md.reset();
		md.update(pwd.getBytes());
		byte[] digest = md.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashGenerated = bigInt.toString(16);
		return hashGenerated.toUpperCase();
	}

	@Override
	public boolean validatePassword(String pwd, String hash) {
		String hashGenerated = encryptPassword(pwd);
		return hashGenerated.equals(hash.toUpperCase());
	}

}

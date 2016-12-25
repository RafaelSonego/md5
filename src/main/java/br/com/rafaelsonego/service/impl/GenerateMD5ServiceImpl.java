package br.com.rafaelsonego.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import br.com.rafaelsonego.service.GenerateMD5Service;

public class GenerateMD5ServiceImpl implements GenerateMD5Service {
	private static final Logger	log	= Logger.getLogger(GenerateMD5ServiceImpl.class);
	private static MessageDigest md = null;

	static {
		try {
			log.info("Instantiating MessageDigest class");
			md = MessageDigest.getInstance("MD5");
			log.debug("MessageDigest created");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
	}

	public String encryptPassword(String pwd) {
		log.info("*** start method encryptPassword ***");
		log.info("encryptPassword method. Password: " + pwd);
		md.reset();
		log.info("reset messageDigest");
		md.update(pwd.getBytes());
		log.info("update messageDigest with string array");
		byte[] digest = md.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashGenerated = bigInt.toString(16);
		log.info("hash generated " + hashGenerated);
		log.info("*** finished method encryptPassword ***");
		return hashGenerated.toUpperCase();
	}

	public boolean validatePassword(String pwd, String hash) {
		log.info("*** start method validatePassword ***");
		log.info("validatePassword method. Password: " + pwd + " - hash: " + hash);
		String hashGenerated = encryptPassword(pwd);
		log.info("*** finished method validatePassword ***");
		return hashGenerated.equals(hash.toUpperCase());
	}

}

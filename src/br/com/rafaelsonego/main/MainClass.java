package br.com.rafaelsonego.main;

import br.com.rafaelsonego.service.GenerateMD5Service;
import br.com.rafaelsonego.service.impl.GenerateMD5ServiceImpl;

public class MainClass {

	private static final String pwd = "RafaelSonegodoPassword";
	
	public static void main(String[] args) {
		GenerateMD5Service md5 = new GenerateMD5ServiceImpl();
		String hash = md5.encryptPassword(pwd);
		System.out.println(hash);
		boolean result = md5.validatePassword(pwd, hash);
		System.out.println(result);
	}

}

package br.com.rafaelsonego.service;

public interface GenerateMD5Service {
	
	public String encryptPassword(String pwd);
	
	public boolean validatePassword(String pwd, String hash);

}

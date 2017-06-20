package br.com.rafaelsonego.md5.test;

import org.junit.Test;

import br.com.rafaelsonego.service.GenerateMD5Service;
import br.com.rafaelsonego.service.impl.GenerateMD5ServiceImpl;
import junit.framework.TestCase;

public class HashTest extends TestCase {
	
	private final String pwd = "RafaelSonegodoPassword";
	private final String hash = "E200A6BAF426C8650B91BD6766D240FE";
	
	@Test
	public void testEncryptPassword(){
		GenerateMD5Service md5 = new GenerateMD5ServiceImpl();
		String hashGenerated = md5.encryptPassword(pwd);
		assertEquals(hash, hashGenerated);
		
	}
	
	@Test
	public void testValidatePassword(){
		GenerateMD5Service md5 = new GenerateMD5ServiceImpl();
		assertTrue(md5.validatePassword(pwd, hash));
	}

}

package com.logistics.turvo.bcrypt;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import junit.framework.TestCase;

public class PasswordHash extends TestCase {

	public void testBCryptHash(){
		String password="hindrik";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
	}
	
public void testMD5Hash(){
	String password = "hindrik";
	Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
	String hashedPAssword = passwordEncoder.encodePassword(password, null);
	System.out.println(hashedPAssword);
}
}

package com.diego.redesocial.controller;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Tratamento de criptografia
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
public class ConvertPasswordToMD5 {
	
	public ConvertPasswordToMD5() {
		
	}

	public String encripta (String senha) {
        try {
             MessageDigest digest = MessageDigest.getInstance("MD5");
             digest.update(senha.getBytes());
             BASE64Encoder encoder = new BASE64Encoder ();
             return encoder.encode (digest.digest ());
        } catch (NoSuchAlgorithmException ns) {
             ns.printStackTrace ();
             return senha;
        }
   }



}

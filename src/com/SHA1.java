package com;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

import javax.xml.bind.DatatypeConverter;
 
/**
 * Hashing with SHA1
 * source: https://gist.github.com/giraam/7413306
 * @param input String to hash
 * @return String hashed
 */


public class SHA1 {
	public String sha1(String input) {
	    String sha1 = null;
	    try {
	        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
	        msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
	        sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
	    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
	        Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, e);
	    }
	    return sha1;
	}
	
	public static void main(String[] args){
		SHA1 s = new SHA1();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string to encrypt: ");
		String input = scanner.nextLine();
		String sha1 = s.sha1(input);
		System.out.println("sha1 result: " +sha1);

	}
	
}

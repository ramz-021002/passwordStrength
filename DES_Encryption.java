package Cryptography;
import java.security.SecureRandom;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
class DES_Encryption{
   byte[] skey = new byte[1000];
   String skeyString;
   static byte[] raw;
   String inputMessage,encryptedData;
	public DES_Encryption()
	{
	   try
	   {
	    generateSymmetricKey();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the message to encrypt: ");
	    String inputMessage = sc.nextLine();
	    byte[] ibyte = inputMessage.getBytes();
	    byte[] ebyte=encrypt(raw, ibyte);
	    String encryptedData = new String(ebyte);
	    System.out.println("Encrypted message "+encryptedData);
	    System.out.println("Encrypted Data "+"\n"+encryptedData);
	    
	    }
	    catch(Exception e) 
	    {
	     System.out.println(e);
	    }
	
	}
     void generateSymmetricKey()
    {
      try 
      {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter the number to generate key: ");
         int num =r.nextInt();
         String knum = String.valueOf(num);
         byte[] knumb = knum.getBytes();
         skey = getRawKey(knumb);
         skeyString = new String(skey);
         System.out.println("DES Symmetric key = "+skeyString);
       }
       catch(Exception e)
       {
          System.out.println(e);
        }
}
	private static byte[] getRawKey(byte[] seed) throws Exception 
	{
		KeyGenerator kgen = KeyGenerator.getInstance("DES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(56, sr);
		SecretKey skey = kgen.generateKey();
		raw = skey.getEncoded();
		return raw;
	}
	private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception 
	{
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}
}
package Cryptography;
import java.util.*;
public class RSA_Encryption {
    public static void encryption_RSA(int p, int q, int plainText) 
    {
		int n = p*q;
		System.out.println("n is:"+n);
		int m = (p-1)*(q-1);
		int e =0;
		for(int i = 2;i<=m;i++) 
		{
			if(m % i !=0) 
			{
				e = i;
				break;
			}
		}
		System.out.println("E is :"+ e);	
		int ciphertext = (int) (Math.pow(plainText, e) %  n);
		System.out.println("Cipher Text is :"+ ciphertext);
	}	
}

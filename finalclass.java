package Cryptography;
import java.util.Scanner;
public class finalclass {
	public static void main(String[] args) {
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("-------------------------------------------------");
			System.out.println("Enter any number to run encryption algorithms....");
			System.out.println("Enter 0 to exit");
			int de = in.nextInt();
		    if(de == 0) {
		    	System.out.println("*****Exiting the code*****");
		    	break;
		    }
		    
		    // RSA encryption
			RSA_Encryption obj=new RSA_Encryption();
			long startTimeRSA = System.nanoTime();
			try {
				System.out.println("**RSA ENCRYPTION**");
				System.out.println("Enter the values of P and Q: ");
				int p = in.nextInt();
				int q = in.nextInt();
				System.out.print("Enter the plain text: ");
				int plainText = in.nextInt();
				RSA_Encryption.encryption_RSA(p,q,plainText);
			}catch(Exception e) {
				System.out.println("**********"+e+" Exception was caught Enter proper values**********");
			}
			try{
		          Thread.sleep(1000);
		        }catch (InterruptedException ex){
		            System.out.println(ex);
		        }
			long endTimeRSA   = System.nanoTime();
			long totalTimeRSA = endTimeRSA - startTimeRSA;
			System.out.println("Total Time for RSA is: "+totalTimeRSA+" Nano seconds");
			
			
			// AES encryption
			AES_Encryption obj1=new AES_Encryption();
			long startTimeAES = System.nanoTime();
		    try {
		    	System.out.println("**AES ENCRYPTION**");
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter your plan text: ");
				String originalString = sc.nextLine();
				String encryptedString = AES_Encryption.encrypt(originalString);
				System.out.println("Given plain text is: "+originalString);
				System.out.println("The encrypted message is : "+encryptedString);
		    }catch(Exception e){
		    	System.out.println("**********"+e+" Exception was caught Enter proper values**********");
		    }
		    try{
		          Thread.sleep(1000);
		        }catch (InterruptedException ex){
		            System.out.println(ex);
		        }
		    long endTimeAES   = System.nanoTime();
			long totalTimeAES = endTimeAES - startTimeAES;
			System.out.println("Total Time for AES is: "+totalTimeAES+" Nano seconds");
			
			
			// DES encryption****
			System.out.println("**DES ENCRYPTION**");
			long startTimeDES = System.nanoTime();
		    try {
		    	DES_Encryption des = new DES_Encryption();
		    }catch(Exception e){
		    	System.out.println("**********"+e+" Exception was caught Enter proper values**********");
		    }
		    try{
		          Thread.sleep(1000);
		        }catch (InterruptedException ex){
		            System.out.println(ex);
		        }
		    long endTimeDES   = System.nanoTime();
			long totalTimeDES = endTimeDES - startTimeDES;
			System.out.println("Total Time for AES is: "+totalTimeDES+" Nano seconds");
		}
	
		
	}
}


public class CryptoManager {

	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
	int index;
	boolean bound=true;
	
		for(int index1= 0; index1 < plainText.length(); index1++){
			if (plainText.charAt(index1) < LOWER_BOUND || plainText.charAt(index1) > UPPER_BOUND)
                return false;
	}
	
		return true;
		
	}
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		String encrypted="";
		if(key>RANGE)

        {

            while(key>UPPER_BOUND)

                 key=key-RANGE-1;

    
        }

        //Substitute character by a character that is key positions away

        for(int i=0;i<plainText.length();i++)

        {

            encrypted=encrypted+(char)(plainText.charAt(i)+key);

        }

        return encrypted;

   
	}
		
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText ="";
		 int bellasoStrLength = bellasoStr.length();
		 for (int index = 0; index < plainText.length(); index++) {
			 char thisChar = plainText.charAt(index);
			  int encryptedCharint = ((int) thisChar + (int) bellasoStr.charAt(index % bellasoStrLength));
			  while (encryptedCharint > UPPER_BOUND) {
				  encryptedCharint -= RANGE;
        }
		 encryptedText += (char) encryptedCharint;
		 }
		 
	return encryptedText;
}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */	public static String decryptCaesar(String encryptedText, int key)
	 {
		
			// This is the inverse of the encryptCaesar method.
			
			
			String decryptedText="";
			for (int index = 0; index < encryptedText.length(); index++) {
                char thisChar = encryptedText.charAt(index);
                int encryptedCharint = ((int) thisChar + key);
                int decryptedCharint = 0;
				while (encryptedCharint <LOWER_BOUND) {
					  decryptedCharint += RANGE;
                }
                decryptedText += (char) decryptedCharint;
			
			}
			return decryptedText;
			
			
		}
	
	
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedText ="";
		 int bellasoStrLength = bellasoStr.length();
		 
		 for (int index = 0; index < encryptedText.length(); index++) {
	            char thisChar = encryptedText.charAt(index);			
		 int decryptedCharint = ((int) thisChar - (int) bellasoStr.charAt(index % bellasoStrLength));
	            while (decryptedCharint < (int) LOWER_BOUND) {
	                decryptedCharint += RANGE;
	            }
	            decryptedText += (char) decryptedCharint;
	        }
	 return decryptedText;

		
		
	}




	}



public class VigenereCipher{
   public static String Encryptor(String plaintext, String key){
        String code = "a";
        String keyFull = "";
        String key1 = "";
        for (int i = 0; i < plaintext.length(); i++) {
            key1 += key;
            keyFull += key1.substring(i, i+1);
        }
        for (int i = 0; i < plaintext.length(); i++) {
            String c1 = plaintext.substring(i, i+1);
            String c11 = keyFull.substring(i, i+1);
            int realid = 0;
            char c = c1.charAt(0);
            char d = c11.charAt(0);
            
            int keyInt = 0;
            if (c <= 'z' && c >= 'a') {
               keyInt = (((char)c-97)+((char)d)-97)%26;
               realid = 97 + keyInt;
            }
            else if (c <= 'Z' && c >= 'A') {
               keyInt = (((char)c-65)+((char)d)-65)%26;
               realid = 65 + keyInt;
            }
            char realchar = (char)realid;
            code += realchar;
        }
        return code.substring(1);
   }
   public static String Decryptor(String code, String key){
        String key1 = "";
        String keyFull = "";
        if (key.length() != code.length()){
         for (int i = 0; i < code.length(); i++) {
            key1 += key;
            keyFull += key1.substring(i, i+1);
        }}
        else{
        keyFull = key;
        }
        String plaintext = "";
        int realid = 0;
        for (int i = 0; i < code.length(); i++) {
            String c1 = code.substring(i, i+1);
            String c11 = keyFull.substring(i, i+1);
            char c = c1.charAt(0);
            char d = c11.charAt(0);
            
            int keyInt = 0;
            if (c <= 'z' && c >= 'a') {
               keyInt = (((char)c-97)+26-((char)d-97))%26;
               realid = 97 + keyInt;
            }
            else if (c <= 'Z' && c >= 'A') {
               keyInt = (((char)c-65)+26-((char)d-65))%26;
               realid = 65 + keyInt;
            }
            char realchar = (char)realid;
            plaintext += realchar;
        }
        return plaintext;
   }
   public static void main(String[] args){
      System.out.println("What message would you like to decrypt? ");
      String codeD = StdIn.readString();
      System.out.println("What is the key? ");
      String keyD = StdIn.readString();
      System.out.println("Your decrypted message is: " + VigenereCipher.Decryptor(codeD, keyD));
      System.out.println("What message would you like to encrypt? ");
      String codeE = StdIn.readString();
      System.out.println("What is the key? ");
      String keyE = StdIn.readString();
      System.out.println("Your decrypted message is: " + VigenereCipher.Encryptor(codeE, keyE));
   }
}
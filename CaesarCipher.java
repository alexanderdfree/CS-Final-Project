public class CaesarCipher
{
    public static String Encryptor(String code, int offset2)
    {
        int offset = offset2 % 26;
        String plaintext = "";
        for (int i = 0; i < code.length(); i++) {
            String c1 = code.substring(i, i+1);
            int realid = 0;
            char c = c1.charAt(0);
            if (c <= 'z' && c >= 'a') {
               realid = 97 + (c-97 + offset)%26;
            }
            else if (c <= 'Z' && c >= 'A') {
               realid = 65 + (c-65 + offset)%26;
            }
            char realchar = (char)realid;
            plaintext += realchar;
        }
        return plaintext;
    }
    public static char EncryptChar(char c, int offset2)
    {
        int offset = offset2 % 26;
        
        char realid;
        int code = (int)c;
        int code2 = 0;
        if (code <= 'z' && code >= 'a') {
            code2 = 97 + (code-97 + offset) % 26;
        }
        else if (code <= 'Z' && code >= 'A') {
            code2 = 65 + (code-65 + offset) % 26;
        }
        char realchar = (char)code2;
        return realchar;
    }
    public static String Decryptor(String code, int offset2)
    {
        int offset = offset2 % 26;
        String plaintext = "";
        for (int i = 0; i < code.length(); i++) {
            String c1 = code.substring(i, i+1);
            int realid = 0;
            char c = c1.charAt(0);
            if (c <= 'z' && c >= 'a') {
               realid = 97 + (((c - 97) + (26 - offset))%26);
            }
            else if (c <= 'Z' && c >= 'A') {
               realid = 65 + (((c - 65) + (26 - offset))%26);
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
      int keyD = StdIn.readInt();
      System.out.println("Your decrypted message is: " + CaesarCipher.Decryptor(codeD, keyD));
      System.out.println("What message would you like to encrypt? ");
      String codeE = StdIn.readString();
      System.out.println("What is the key? ");
      int keyE = StdIn.readInt();
      System.out.println("Your decrypted message is: " + CaesarCipher.Encryptor(codeE, keyE));
   }
}


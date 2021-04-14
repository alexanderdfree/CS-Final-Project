public class EnigmaMachine{
   //define board and rotors
   private char[][] plugboard;
   private int rotor1Offset;
   private int rotor2Offset;
   private int rotor3Offset;
   //Constructor, initialize board
   public EnigmaMachine(int r1, int r2, int r3){
      //plugboard definition
      plugboard = new char[2][26];
      //offsets setups
      rotor1Offset = 0;
      rotor2Offset = 0;
      rotor3Offset = 0;
      //plugboard setup
      for (int x = 0; x < 2; x++){
         for (int y = 0; y < 26; y++){
            this.plugboard[x][y] = (char)(y + 65);
         }
      }
   }
   //plugboard
   
   public String enigmaEncryptor(String input){
      String finalstring = "";
      
      for (int i = 0; i < input.length(); i++){
         if (this.rotor1Offset >= 26) {
            this.rotor1Offset = 0;
            this.rotor2Offset++;
         }
         if (this.rotor2Offset >= 26) {
            this.rotor2Offset = 0;
            this.rotor3Offset++;
         }
         if (this.rotor3Offset >= 26) {
            this.rotor3Offset = 0;
         }
         char thisChar = input.charAt(i);
         //plugboard
         
         char char1 = this.plugboard[lowercaseNumber(thisChar)-1][1];
         //rotor 1
         char char2 = CaesarCipher.EncryptChar(char1, this.rotor1Offset);
         this.rotor1Offset++;
         //rotor 2
         char char3 = CaesarCipher.EncryptChar(char2, this.rotor2Offset);
         //rotor 3
         char char4 = CaesarCipher.EncryptChar(char3, this.rotor3Offset);
         //reflector
         
         finalstring += char4;
      }
      return finalstring;
   }
   public String enigmaDecryptor(String input){
      String finalstring = "";
      //plugboard
      
      String string1 = "";
      //rotor 1
      CaesarCipher.Decryptor("", 0);
      //rotor 2
      
      //rotor 3
      return finalstring;
   }
   public static int lowercaseNumber(char a){
      return a - 97;
   }
   public void main(String args[]){
      EnigmaMachine enigma = new EnigmaMachine(0, 0, 0);
      this.enigmaEncryptor("test");

   }
}
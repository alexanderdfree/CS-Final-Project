public class EnigmaMachine{
   //define board and rotors
   private char[][] plugboard;
   private char[][] reflector;
   private Rotor rotor1;
   private Rotor rotor2;
   private Rotor rotor3;
   //Constructor, initialize board
   public EnigmaMachine(){
      //plugboard definition
      plugboard = new char[2][26];
      reflector = new char[2][26];
      //plugboard setup
      for (int x = 0; x < 2; x++){
         for (int y = 0; y < 26; y++){
            this.plugboard[x][y] = (char)(y + 97);
         }
      }
      /*for (int x = 0; x < 2; x++){
         for (int y = 0; y < 26; y++){
            this.reflector[x][y] = (char)(y + 97);
         }
      }*/
      this.reflector[1][0] = 'c';
      this.reflector[1][1] = 'd';
      this.reflector[1][2] = 'a';
      this.reflector[1][3] = 'b';
      this.reflector[1][4] = 'g';
      this.reflector[1][5] = 'h';
      this.reflector[1][6] = 'e';
      this.reflector[1][7] = 'f';
      this.reflector[1][8] = 'k';
      this.reflector[1][9] = 'l';
      this.reflector[1][10] = 'i';
      this.reflector[1][11] = 'j';
      this.reflector[1][12] = 'o';
      this.reflector[1][13] = 'p';
      this.reflector[1][14] = 'm';
      this.reflector[1][15] = 'n';
      this.reflector[1][16] = 's';
      this.reflector[1][17] = 't';
      this.reflector[1][18] = 'q';
      this.reflector[1][19] = 'r';
      this.reflector[1][20] = 'w';
      this.reflector[1][21] = 'x';
      this.reflector[1][22] = 'u';
      this.reflector[1][23] = 'v';
      this.reflector[1][24] = 'z';
      this.reflector[1][25] = 'y';
      
      
   }
   /*public String printString(){
      return this.string1;
   }*/
   
   public String enigmaEncryptor(String input){
      String finalstring = "";
      
      for (int i = 0; i < input.length(); i++){
         /*if (this.rotor1Offset >= 26) {
            this.rotor1Offset = 0;
            this.rotor2Offset++;
         }
         if (this.rotor2Offset >= 26) {
            this.rotor2Offset = 0;
            this.rotor3Offset++;
         }
         if (this.rotor3Offset >= 26) {
            this.rotor3Offset = 0;
         }*/
         char thisChar = input.charAt(i);
         //plugboard
         
         char char1 = this.plugboard[1][lowercaseNumber(thisChar)];
         //rotor 1
         char char2 = CaesarCipher.EncryptChar(char1, this.rotor1Offset);
         //
         //rotor 2
         char char3 = CaesarCipher.EncryptChar(char2, this.rotor2Offset);
         //rotor 3
         char char4 = CaesarCipher.EncryptChar(char3, this.rotor3Offset);
         //reflector
         char reflectedChar = this.reflector[1][lowercaseNumber(char4)];
         
         /*char char5 = CaesarCipher.EncryptChar(reflectedChar, this.rotor3Offset);
         char char6 = CaesarCipher.EncryptChar(char5, this.rotor2Offset);
         char char7 = CaesarCipher.EncryptChar(char6, this.rotor1Offset);*/
         char char9 = CaesarCipher.DecryptChar(reflectedChar, this.rotor1Offset);
         char char10 = CaesarCipher.DecryptChar(char9, this.rotor2Offset);
         char char11 = CaesarCipher.DecryptChar(char10, this.rotor3Offset);
         
         //
         //char char8 = this.reflector[1][lowercaseNumber(char7)];
         //
         
         //
         finalstring += char11;
         //this.rotor1Offset++;
      }
      return finalstring;
   }/*
   public String enigmaDecryptor(String input){
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
         
         char char1 = this.plugboard[1][lowercaseNumber(thisChar)];
         //rotor 1
         char char2 = CaesarCipher.EncryptChar(char1, this.rotor1Offset);
         //
         //rotor 2
         char char3 = CaesarCipher.EncryptChar(char2, this.rotor2Offset);
         //rotor 3
         char char4 = CaesarCipher.EncryptChar(char3, this.rotor3Offset);
         //reflector
         char reflectedChar = this.reflector[1][lowercaseNumber(thisChar)];
         
         char char5 = CaesarCipher.EncryptChar(reflectedChar, this.rotor3Offset);
         char char6 = CaesarCipher.EncryptChar(char5, this.rotor2Offset);
         char char7 = CaesarCipher.EncryptChar(char6, this.rotor1Offset);
         char char8 = this.plugboard[1][lowercaseNumber(char7)];
         
         finalstring += char8;
         this.rotor1Offset--;
      }
      return finalstring;
   }*/
   public static int lowercaseNumber(char a){
      return a - 97;
   }
   public static void main(String args[]){
      EnigmaMachine enigma = new EnigmaMachine(1, 2, 3, "test");
      StdOut.println(enigma.enigmaEncryptor("d"));
      //StdOut.println(enigma.enigmaEncryptor(""));
      //StdOut.println(enigma.enigmaDecryptor(enigma.enigmaEncryptor("g")));
      //EnigmaMachine enigma2 = new EnigmaMachine(0, 0, 0, "sfvy");
      //StdOut.println(enigma.enigmaEncryptor("sfvy"));

   }
}
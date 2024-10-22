public class EnigmaMachine{
   //define board and rotors
   private Rotor plugboard;
   private int[] reflector;
   private Rotor rotor1;
   private Rotor rotor2;
   private Rotor rotor3;
   //Constructor, initialize board
   public EnigmaMachine(){
      /*Setup a new EnigmaMachine 
         Input:
             none
         Output:
             this: a new EnigmaMachine
         Ex.
         
         EnigmaMachine encode = new EnigmaMachine()
      */

      //reflector def
      reflector = new int[26];
      //rotor setups
      int[] rot1 = new int[26];
      int[] rot2 = new int[26];
      int[] rot3 = new int[26];
      int[] plugboard1 = new int[26];
      
      //strings of rotor positions
      String rot1string = "DMTWSILRUYQNKFEJCAZBPGXOHV";
      String rot2string = "HQZGPJTMOBLNCIFDYAWVEUSRKX";
      String rot3string = "UQNTLSZFMREHDPXKIBVYGJCWOA";
      String plugboardstring = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      //fill rotor char arrays
      for (int i = 0; i < 26; i ++){
         rot1[i] = charNumber(rot1string.charAt(i));
      }
      for (int i = 0; i < 26; i ++){
         rot2[i] = charNumber(rot2string.charAt(i));
      }
      for (int i = 0; i < 26; i ++){
         rot3[i] = charNumber(rot3string.charAt(i));
      }
      for (int i = 0; i < 26; i ++){
         plugboard1[i] = charNumber(plugboardstring.charAt(i));
      }
      //create rotor classes using rotor char arrays
      rotor1 = new Rotor(rot1, 0);
      rotor2 = new Rotor(rot2, 0);
      rotor3 = new Rotor(rot3, 0);
      plugboard = new Rotor(plugboard1, 0);
      
      //setup reflector using individual chars
      this.reflector[0] = charNumber('c');
      this.reflector[1] = charNumber('d');
      this.reflector[2] = charNumber('a');
      this.reflector[3] = charNumber('b');
      this.reflector[4] = charNumber('g');
      this.reflector[5] = charNumber('h');
      this.reflector[6] = charNumber('e');
      this.reflector[7] = charNumber('f');
      this.reflector[8] = charNumber('k');
      this.reflector[9] = charNumber('l');
      this.reflector[10] = charNumber('i');
      this.reflector[11] = charNumber('j');
      this.reflector[12] = charNumber('o');
      this.reflector[13] = charNumber('p');
      this.reflector[14] = charNumber('m');
      this.reflector[15] = charNumber('n');
      this.reflector[16] = charNumber('s');
      this.reflector[17] = charNumber('t');
      this.reflector[18] = charNumber('q');
      this.reflector[19] = charNumber('r');
      this.reflector[20] = charNumber('w');
      this.reflector[21] = charNumber('x');
      this.reflector[22] = charNumber('u');
      this.reflector[23] = charNumber('v');
      this.reflector[24] = charNumber('z');
      this.reflector[25] = charNumber('y');
      
      
   }

   public String enigmaEncryptor(String input){
      /*changes the input String into an encrypted output String, simulating an Enigma machine

         Input:
             String input: input string that needs to be encrypted/decrypted
             
         Output: 
             String finalString: output string that has been through the enigma machine
         
         Ex.
         EnigmaMachine encode = new EnigmaMachine();
         EnigmaMachine decode = new EnigmaMachine();
         String testInput = “hellomynameisalex”;
         String encrypted = encode.enigmaEncryptor(testInput);
         StdOut.println(encrypted);
         StdOut.println(decode.enigmaEncryptor(encrypted))
         scsqdhkgurjdehvze
         hellomynameisalex
      */

      String finalstring = "";
      
      for (int i = 0; i < input.length(); i++){
         //if rotor 1 is past the 26th position, return to position 0
         if (rotor1.returnOffset() >= 26) {
            rotor1.changeOffset(0);
            rotor2.rotate(); //rotate rotor 2
         }
         //if rotor 2 is past the 26th position, return to position 0
         if (rotor2.returnOffset() >= 26) {
            rotor2.changeOffset(0);
            rotor3.rotate(); //rotate rotor 3
         }
         //if rotor 3 is past the 26th position, return to position 0
         if (rotor3.returnOffset() >= 26) {
            rotor3.changeOffset(0);
         }
         //take char of input string at index
         char thisChar = input.charAt(i);
         //if the character isn't in the english alphabet
         if (!(thisChar <= 'z' && thisChar >= 'a') || (thisChar <= 'Z' && thisChar >= 'A')){
            finalstring += thisChar; //add it directly
         }
         //otherwise
         else{
         //plugboard
         int pluggedChar = this.plugboard.inToOut(charNumber(thisChar));
         //rotor 1
         int rot1char = rotor1.inToOut(pluggedChar);
         
         //rotor 2
         int rot2char = rotor2.inToOut(rot1char);
         //rotor 3
         int rot3char = rotor3.inToOut(rot2char);
         //reflector
         int reflectedChar = this.reflector[rot3char];
         //rotor 3
         int rot4char = rotor3.outToIn(reflectedChar);

         //rotor 2
         int rot5char = rotor2.outToIn(rot4char);
         //rotor 1
         int rot6char = rotor1.outToIn(rot5char);
         //final plugboard
         
         int finalInt = plugboard.outToIn(rot6char);
         
         //add char to final string
         finalstring += (char)(finalInt + 97);}
         
         //rotate the first rotor
         rotor1.rotate();
      }
      return finalstring;
   }
   
   public static int charNumber(char a){
      /*changes the input char into an integer based on ascii decimal tables and its position in the
         alphabet
         
         Input:
             char a: the char that needs to be changed
             
         Output: 
             int newInt: the int version of char a
         
         Ex.
         EnigmaMachine.charNumber(‘a’)
         0
      */

      //if its a lowercase letter, return a - 97
      if (a <= 'z' && a >= 'a'){
         return a - 97;
      }
      //if its an uppercase letter, return a - 65
      if (a <= 'Z' && a >= 'A'){
         return a - 65;
      }
      else return 0;
   }
   
   public static void main(String args[]){
      //main function
      StdOut.println("What message would you like to encrypt/decrypt?");
      EnigmaMachine encode = new EnigmaMachine();
      EnigmaMachine decode = new EnigmaMachine();
      String testInput = StdIn.readString();
      StdOut.println("Original Text: " + testInput);
      String encrypted = encode.enigmaEncryptor(testInput);
      StdOut.println("Encrypted text: " + encrypted);
      StdOut.println("Decrypted text (should match original): " + decode.enigmaEncryptor(encrypted));
   }
}
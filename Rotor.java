public class Rotor{
   //setup rotor class
   private int[] rotorArr;
   private int offset;
   public Rotor(int[] r, int o){
      /*Setup a new rotor using the int[] r
      and an offset of o.
      Input:
          int[] r: the int array representing the rotor's output alphabet
          int o: the offset of the rotor (should start at 0)
      Output:
          this: a new rotor
      Ex.
      int[] rot = new int[26];
      Rotor rotor1 = new Rotor(rot, 0);
      rotor1.print()
      0
      0
      0
      (continued)
      */
      rotorArr = r;
      offset = o;
   }
   public int inToOut(int input){
      /*return the output of the rotor at index input
         Input:
             int input: the index of the output you want
             
         Output: 
             int output: the current rotor’s output at position input, including offset
         Ex.
         int[] rot = new int[26];
         rot[3] = 2;
         Rotor rotor1 = new Rotor(rot, 0);
         rotor1.inToOut(3)
         2
      */
      return rotorArr[(input + offset) % 26];
   }
   public int outToIn(int output){
      /*return the input of the rotor when the output is the int argument
         Input:
             int output: the output you want to find the index for
             
         Output: 
             int input: the current rotor’s input to get int output, including offset
             
         Ex.
         int[] rot = new int[26];
         rot[3] = 2;
         Rotor rotor1 = new Rotor(rot, 0);
         rotor1.outToIn(2)
         3
      */
      for (int i = 0; i < 26; i++){ //for every int in the alphabet
         if (rotorArr[i] == output){ //if the rotor output matches the argument
            return ( i - offset + 26 ) % 26; //return it
         }
      }
      return 0;
   }
   public void rotate(){
      /*change the offset of the rotor by 1
         Input:
             none
             
         Output: 
             none
         Side effects:
              offset increases by 1
             
         Ex.
         int[] rot = new int[26];
         Rotor rotor1 = new Rotor(rot, 1);
         rotor1.rotate();
         rotor1.print()
         Offset: 2
         0 0 0 0 0 0 0 0 … (continued)
      */
      this.offset++; //rotate the rotor
   }
   public int returnOffset(){
      /*return the offset of the current rotor
         Input:
             none
             
         Output: 
             this.offset: the current offset
             
         Ex.
         int[] rot = new int[26];
         rot[3] = 2;
         Rotor rotor1 = new Rotor(rot, 25);
         rotor1.returnOffset()
         25
      */
      return this.offset; // return the rotor offset
   }
   public void changeOffset(int newInt){
      /*change the offset of the current rotor
         Input:
             newInt: the integer that the new offset should be
             
         Output: 
             none
         
         Side Effects:
             offset = newInt (the offset is now equal to the int argument given)
         Ex.
         int[] rot = new int[26];
         Rotor rotor1 = new Rotor(rot, 25);
         rotor1.changeOffset(4);
         rotor1.print()
         Offset: 4
         0 0 0 0 0 0 0… (continued)
      */
      this.offset = newInt;
   }
   public void print(){
      /*prints the offset and then each individual state of the rotor’s alphabet
         Input:
             none
             
         Output: 
             StdOut: prints the virtual rotor
         
         Ex.
         int[] rot = new int[26];
         Rotor rotor1 = new Rotor(rot, 25);
         rotor1.changeOffset(4);
         rotor1.print()
         Offset: 4
         0 0 0 0 0 0 0… (continued)
      */
      StdOut.println("Offset: " + this.offset);
      for (int i = 0; i < this.rotorArr.length; i++){
         StdOut.print(this.rotorArr[i] + " "); //print the rotor
      }
   }
}
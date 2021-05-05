public class Rotor{
   private int[] rotorArr;
   private int offset;
   public Rotor(int[] r, int o){
      /*Setup a new rotor using the int[] r
      and an offset of o.
      Input:
         int[] r: the int array representing the rotor's output alphabet
         int o: the offset of the rotor (should start at 0)
      Output:
         this: a new empty Tic Tac Toe board
      Ex.
      int[] rot = new int[26];
      Rotor rotor1 = new Rotor(rot, 0);
      rotor1.print()
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      0
      (continued)
      */
      rotorArr = r;
      offset = o;
   }
   //input to output (int input)
   //output to input (int output)
   //rotate
   public int inToOut(int input){
      return rotorArr[(input + offset) % 26];
   }
   public int outToIn(int output){
      for (int i = 0; i < 26; i++){
         if (rotorArr[i] == output){
            return ( i - offset + 26 ) % 26;
         }
      }
      return 0;
   }
   public void rotate(){
      this.offset++;
   }
   public int returnOffset(){
      return this.offset;
   }
   public void changeOffset(int newInt){
      this.offset = newInt;
   }
   public void print(){
      StdOut.println("Offset: " + this.offset);
      for (int i = 0; i < this.rotorArr.length; i++){
         StdOut.print(this.rotorArr[i] + " ");
      }
   }
}
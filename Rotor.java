public class Rotor{
   private int[] rotorArr;
   private int offset;
   public Rotor(int[] r, int o){
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
}
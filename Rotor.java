public class Rotor{
   private char[] rotorArr;
   private int offset;
   public Rotor(char[] rotArr, int o){
      rotorArr = rotArr;
      offset = o;
   }
   //input to output (int input)
   //output to input (int output)
   //rotate
   public char inToOut(int input){
      return rotorArr[input];
   }
   public char outToIn(int output){
      int result = 0;
      for (int i = 0; i < 26; i++){
         result = i;
         if ((int)rotorArr[i] - 97 == output){
            return (char)(result + 97);
         }
      }
      return (char)(result + 97);
   }
   public void rotate(){
      this.offset++;
   }
}
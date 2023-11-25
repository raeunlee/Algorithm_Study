import java.io.*;
import java.util.*;

public class Main {
    static class Number{
      boolean one,two,three,four,five,six,seven;
      public Number(boolean one, boolean two, boolean three, boolean four, boolean five, boolean six, boolean seven){
        this.one = one; this.two = two; this.three = three; this.four = four; this.five= five; this.six= six; this.seven = seven;
      }
    }
    public static void main(String[] args) {
      Number One = new Number(false, false, true,false,false,true,false);
      Number Two = new Number(false,true,true,true,true,false,true);
      Number Three = new Number(false,true,true,false,true,true,true);
      Number Four = new Number(true,false,true,false,false,true,true);
      Number Five = new Number(true,true,false,false,true,true,true);
      Number Six = new Number(true,true,false,true,true,true,true);
      Number Seven = new Number(true,true,true,false,false,true,false);
      Number Eight = new Number(true,true,true,true,true,true,true);
      Number Nine = new Number(true,true,true,false,true,true,true);
      Number Zero = new Number(true,true,true,true,true,true,false);
      Number None = new Number(false,false,false,false,false,false,false);
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      
      while(T-->0){
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int[] numDiv1 = new int[5];
        int[] numDiv2 = new int[5];
        List<Number> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();
        for(int i=0;i<5;i++)
          {
            numDiv1[i] = num1/ (int) Math.pow(10,4-i);
            numDiv2[i] = num2/ (int) Math.pow(10,4-i);
            
            num1 = num1 - (int) Math.pow(10,4-i) * numDiv1[i];
            num2 = num2 - (int) Math.pow(10,4-i) * numDiv2[i];
          }
        
          Number number1 = None;
          Number number2 = None;
            boolean first1 = false; // 첫자리가 0이아닐떄까지
            boolean first2 = false; // 첫자리가 0이아닐떄까지
          for(int num : numDiv1){
            if(num!=0) first1 = true;
            if(!first1){
              number1 = None;
            } else{            
            switch(num){
                case 0:
                   number1 = Zero;
                  break;
                case 1:
                   number1 = One;
                  break;
                case 2:
                   number1 = Two;
                  break;
                case 3:
                   number1= Three;
                  break;
                case 4:
                   number1 = Four;
                  break;
                case 5:
                   number1 = Five;
                  break;
                case 6 :
                   number1 = Six;
                  break;
                case 7 :
                   number1 = Seven;
                  break;
                case 8 :
                   number1 = Eight;
                  break;
                case 9 :
                   number1 = Nine;
                  break;
                default :
                   number1 = None;
                  break;
            }
              }
            list1.add(number1);
            }
            for(int num : numDiv2){
              if(num!=0) first2 = true;
              if(!first2){
                number1 = None;
              } else{
                
              switch(num){
                case 0:
                   number2 = Zero;
                  break;
                case 1:
                   number2 = One;
                  break;
                case 2:
                   number2 = Two;
                  break;
                case 3:
                   number2= Three;
                  break;
                case 4:
                   number2 = Four;
                  break;
                case 5:
                   number2 = Five;
                  break;
                case 6 :
                   number2 = Six;
                  break;
                case 7 :
                   number2 = Seven;
                  break;
                case 8 :
                   number2 = Eight;
                  break;
                case 9 :
                   number2 = Nine;
                  break;
                default :
                   number2 = None;
                  break;
            }
                }
           list2.add(number2);
            
          }
        findAnswer(list1,list2);
      }
    }
    static public void findAnswer(List<Number> a, List<Number> b){
      int answer =0;
      for(int i=0;i<5;i++)
        {
          Number na = a.get(i);
          Number nb = b.get(i);
          answer+=findDiff(na,nb);
        }
      System.out.println(answer);
    }
  static public int findDiff(Number a, Number b){
    int diff =0;
    if(a.one != b.one) diff++;
    if(a.two != b.two) diff++;
    if(a.three != b.three) diff++;
    if(a.four != b.four) diff++;
    if(a.five != b.five) diff++;
    if(a.six != b.six) diff++;
    if(a.seven != b.seven) diff++;
    return diff;
  }
}

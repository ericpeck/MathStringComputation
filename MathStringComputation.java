/*
 * This is written with NetBeans IDE 8.2
 * The package is unnecessary.
 */
package mathstringcomputation;
import java.util.*;
/**
 *
 * @author ericpeck
 */
public class MathStringComputation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test1
        String input1 = "11 + 10 * 4 / 2 - 2";    
        int answer1 = 11+10*4/2-2;
        int eval1 = evaluateString(input1);
        
        
        //test2
        String input2 = "This is not a numerical equation.";
        int eval2 = evaluateString(input2);
        
        //test3
        String input3 = "1 + 2 + 3 + 4 + 5";
        int answer3 = 1+2+3+4+5;
        int eval3 = evaluateString(input3);
        
        //test4
        String input4 = "10 - 9 - 8 - 7 - 6";
        int answer4 = 10-9-8-7-6;
        int eval4 = evaluateString(input4);
        
        //test5
        String input5 = "1+2+3+4+5"; //not a proper format. will catch and print exception.
        int eval5 = evaluateString(input5);
            
        System.out.println(answer1 == eval1); //test1
        System.out.println(eval2);            //test2
        System.out.println(answer3 == eval3); //test3
        System.out.println(answer4 == eval4); //test4
        System.out.println(eval5);            //test5
    }
    
    public static int evaluateString(String input){
        int finalValue = 0;
        
        //try{ 
             //the reason this unusual number is put is in case the input string is a bad string and will return this.
            ArrayList<String> inputHolder = new ArrayList<>();
            String[] inputs = input.split(" ");

            inputHolder.addAll(Arrays.asList(inputs));
            
            while(!inputHolder.isEmpty() && inputHolder.size() != 1){

                if(inputHolder.indexOf("*") != -1 && inputHolder.indexOf("/") != -1){
                    int val1 = inputHolder.indexOf("*");
                    int val2 = inputHolder.indexOf("/");

                    if(val1 < val2){
                        inputHolder = evaluating(inputHolder, val1);
                    }
                    else{
                        inputHolder = evaluating(inputHolder, val2);
                    }
                }
                else if(inputHolder.indexOf("*") != -1){
                    int val = inputHolder.indexOf("*");
                    inputHolder = evaluating(inputHolder, val);  
                }
                else if(inputHolder.indexOf("/") != -1){
                    int val = inputHolder.indexOf("/");
                    inputHolder = evaluating(inputHolder, val);  
                }
                else if(inputHolder.indexOf("+") != -1 && inputHolder.indexOf("-") != -1){
                    int val1 = inputHolder.indexOf("+");
                    int val2 = inputHolder.indexOf("-");

                    if(val1 < val2){
                        inputHolder = evaluating(inputHolder, val1);
                    }
                    else{
                        inputHolder = evaluating(inputHolder, val2);
                    }
                }
                else if(inputHolder.indexOf("+") != -1){
                    int val = inputHolder.indexOf("+");
                    inputHolder = evaluating(inputHolder, val);  
                }
                else if(inputHolder.indexOf("-") != -1){
                    int val = inputHolder.indexOf("-");
                    inputHolder = evaluating(inputHolder, val);  
                }
                else break;  
             }
            try{
                return finalValue = Integer.parseInt(inputHolder.get(0));
            }
            catch(Exception e){
                //catches if an input isn't in a proper form and prints the exception error.
                //return 0 
                System.out.println(e);  
            }
            return 0; 
    }
    
    public static ArrayList<String> evaluating(ArrayList<String> inputArray, int indexVal){
        
        int val1 = Integer.parseInt(inputArray.get(indexVal-1));
        int val2 = Integer.parseInt(inputArray.get(indexVal+1));
        int val3int = 0;
        
        switch(inputArray.get(indexVal)){
            case "+": val3int = val1 + val2;
            break;
            
            case "-": val3int = val1 - val2;
            break;
            
            case "*": val3int = val1 * val2;
            break;
            
            case "/": val3int = val1 / val2;
            break;
        }
        
        String val3String = String.valueOf(val3int);
        
        inputArray.set(indexVal, val3String);
        inputArray.remove(indexVal+1);
        inputArray.remove(indexVal-1);
        
        return inputArray;
    }
    
}

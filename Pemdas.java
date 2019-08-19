import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class Pemdas here.
 *
 * @author (Samad alias Nyein Chan)
 * @version (18th August 2019)
 */
public class Pemdas
{
    // instance variables - replace the example below with your own
    private Operators operators;
    private Map<String, Integer> pemdas;
    private final List<String> OPERATORS = Arrays.asList("+", "-", "/", "x");

    /**
     * Constructor for objects of class Pemdas
     */
    public Pemdas()
    {
        operators = new Operators();
        pemdas = new HashMap<>();
        fillUpPemdas();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void fillUpPemdas()
    {
        pemdas.put("x", 1);
        pemdas.put("/", 2);
        pemdas.put("+", 3);
        pemdas.put("-", 4);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private String getSuperiorOperator(String operator1, String operator2)
    {
        return pemdas.get(operator1) < pemdas.get(operator2) ? operator1: operator2;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private String getInferiorOperator(String operator1, String operator2)
    {
        return pemdas.get(operator1)>pemdas.get(operator2) ? operator1: operator2;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getAnswer(String output)
    {
        ArrayList<String> al = new ArrayList<>();
        while(containsTwoOperators(output)){
            List<String> splitter = splitOnce(output);
            al.add(splitter.get(1));
            output = splitter.get(0);
            System.out.println("splitter: "+splitter.get(0)+", "+splitter.get(1));
        }
        
        for(String splits: al){
            if(splits.startsWith(OPERATORS.get(0)) || splits.startsWith(OPERATORS.get(1)) || splits.startsWith(OPERATORS.get(2)) || splits.startsWith(OPERATORS.get(3))){
                output = Double.toString(operators.antiConcatinator(output)) + splits;
            }
            else{
                output = splits + Double.toString(operators.antiConcatinator(output));
            }
        }
        return Double.toString(operators.antiConcatinator(output));
    }
    
    public List<String> splitOnce(String output){
        String expression1, expression2;
        List<Integer> operatorIndices = findOperatorIndices(output);
        if(operatorIndices.get(0) > operatorIndices.get(1)){
            expression1 = output.substring(0, operatorIndices.get(1)+1);
            expression2 = output.substring(operatorIndices.get(1)+1, output.length());
            return Arrays.asList(expression2, expression1);
        }
        else{
            expression1 = output.substring(0, operatorIndices.get(1));
            expression2 = output.substring(operatorIndices.get(1), output.length());
            return Arrays.asList(expression1, expression2);
        }
    }
    
    public List<Integer> findOperatorIndices(String output){
        int operator1Index=-1, operator2Index=-1;
        for(int i=0; i<output.length(); i++){
            if(OPERATORS.contains(Character.toString(output.charAt(i))) && operator1Index==-1){
                operator1Index = i;
            }
            else if(OPERATORS.contains(Character.toString(output.charAt(i)))){
                operator2Index = i;
            }
        }
        
        if(operator1Index == -1 || operator2Index == -1){
            return null;
        }
        
        char supOp = getSuperiorOperator(Character.toString(output.charAt(operator1Index)), Character.toString(output.charAt(operator2Index))).charAt(0);
        return supOp == output.charAt(operator1Index) ? Arrays.asList(operator1Index, operator2Index): Arrays.asList(operator2Index, operator1Index);
    }
    
    public boolean containsTwoOperators(String expression){
        if(OPERATORS.contains(expression.charAt(0))){
            expression = expression.substring(1, expression.length());
        }
        final String expreshon = expression;
        long numOfOperators = OPERATORS.stream()
                                      .map(operator -> expreshon.contains(operator))
                                      .filter(containsOperator -> containsOperator==true)
                                      .count();
        if(numOfOperators > 1){
            return true;
        }
        int[] count = new int[4];
        for(int i=0; i<expression.length(); i++){
            String c = Character.toString(expression.charAt(i));
            if(OPERATORS.contains(c)){
                count[OPERATORS.indexOf(c)]++;
            }
        }
        return count[0]>1 || count[1]>1 || count[2]>1 || count[3]>1;
    }
    
    
}

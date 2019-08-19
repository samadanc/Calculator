/**
 * Write a description of class Operators here.
 *
 * @author (Samad alias Nyein Chan)
 * @version (18th August 2019)
 */
public class Operators
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Operators
     */
    public Operators()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double add(double x, double y)
    {
        // put your code here
        return x + y;
    }
    
    public double subtract(double x, double y)
    {
        // put your code here
        return x - y;
    }
    
    public double multiply(double x, double y)
    {
        // put your code here
        return x * y;
    }
    
    public double divide(double x, double y)
    {
        // put your code here
        return x / y;
    }
    
    public double antiConcatinator(String output)
    {
        String[] arr;
        double x = 0;
        double y = 0;
        
        if(output.contains("+")){
            //arr = output.split("+");
            //arr = new String[] {"a"};
            for(int i = 0; i<output.length();i++){
                if (output.charAt(i)=='+'){
                    x = Double.parseDouble(output.substring(0,i));
                    y = Double.parseDouble(output.substring(i+1));
                }
            }
            return add(x,y);
        }
        
        else if(output.contains("x")){
            for(int i = 0; i<output.length();i++){
                if (output.charAt(i)=='x'){
                    x = Double.parseDouble(output.substring(0,i));
                    y = Double.parseDouble(output.substring(i+1));
                }
            }
            return multiply(x,y);
        }
        
        else if(output.contains("/")){
            for(int i = 0; i<output.length();i++){
                if (output.charAt(i)=='/'){
                    x = Double.parseDouble(output.substring(0,i));
                    y = Double.parseDouble(output.substring(i+1));
                }
            }
            return divide(x,y);
        }
        
        else if(output.contains("-") && !output.startsWith("-")){
            for(int i = 0; i<output.length();i++){
                if (output.charAt(i)=='-'){
                    x = Double.parseDouble(output.substring(0,i));
                    y = Double.parseDouble(output.substring(i+1));
                }
            }
            return subtract(x,y);
        }
        return Double.parseDouble(output);
    }
}

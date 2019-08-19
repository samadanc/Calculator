import java.util.ArrayList;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    private Operators op;
    private double n;
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        // initialise instance variables
        op = new Operators();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod()
    {
        // put your code here
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<=15; i++){
            al.add(i);
            if(i==5){
                al.remove(i);
            }
        }
        al.forEach(elem -> System.out.println(elem));
    }
}

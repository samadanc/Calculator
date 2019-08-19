import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Write a description of class GUI here.
 *
 * @author Samad alias Nyein Chan
 * @version (18th August 2019)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private JFrame frame;
    private Container contentPane;
    private JTextField output;
    private Pemdas pemdas;
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        makeFrame();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void makeFrame()
    {
        frame = new JFrame("Calculator");
        frame.setSize(300,200);
        contentPane = frame.getContentPane();
        makeMenuBar();
        makeContent();
        //frame.setDefaultLookAndFeelDecorated(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    private void makeMenuBar(){
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu helpMenu = new JMenu("Help");
        menubar.add(helpMenu);
        
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        
        aboutItem.addActionListener(e -> about());       
    }
    
    private void about(){
        JOptionPane.showMessageDialog(frame, "It's a Calculator","Calculator", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void makeContent(){
        //JPanel north = new JPanel();
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,5));
        JPanel[] p = new JPanel[18];
        for(int i = 0;i<18;i++){
            p[i] = new JPanel();
        }
        output = new JTextField();
        output.setSize(500,200);
        
        JButton one = new JButton("1");
        p[0].add(one);
        center.add(p[0]);
        JButton two = new JButton("2");
        p[1].add(two);
        center.add(p[1]);
        JButton three = new JButton("3");
        p[2].add(three);
        center.add(p[2]);
        JButton backspace = new JButton("←");
        p[3].add(backspace);
        center.add(p[3]);
        JButton plus = new JButton("+");
        p[4].add(plus);
        center.add(p[4]);
        JButton multiply = new JButton("x");
        p[5].add(multiply);
        center.add(p[5]);
        JButton four = new JButton("4");
        p[6].add(four);
        center.add(p[6]);
        JButton five = new JButton("5");
        p[7].add(five);
        center.add(p[7]);
        JButton six = new JButton("6");
        p[8].add(six);
        center.add(p[8]);
        JButton empty = new JButton("c");
        p[9].add(empty);
        center.add(p[9]);
        JButton minus = new JButton("-");
        p[10].add(minus);
        center.add(p[10]);
        JButton divide = new JButton("/");
        p[11].add(divide);
        center.add(p[11]);
        JButton seven = new JButton("7");
        p[12].add(seven);
        center.add(p[12]);
        JButton eight = new JButton("8");
        p[13].add(eight);
        center.add(p[13]);
        JButton nine = new JButton("9");
        p[14].add(nine);
        center.add(p[14]);
        JButton zero = new JButton("0");
        p[15].add(zero);
        center.add(p[15]);
        JButton decimal = new JButton(".");
        p[16].add(decimal);
        center.add(p[16]);
        JButton equals = new JButton("=");
        p[17].add(equals);
        center.add(p[17]);
        
        
        contentPane.add(output, BorderLayout.NORTH);
        contentPane.add(center, BorderLayout.CENTER);
        
        one.addActionListener(e -> one());
        two.addActionListener(e -> two());
        three.addActionListener(e -> three());
        four.addActionListener(e -> four());
        five.addActionListener(e -> five());
        six.addActionListener(e -> six());
        seven.addActionListener(e -> seven());
        eight.addActionListener(e -> eight());
        nine.addActionListener(e -> nine());
        zero.addActionListener(e -> zero());
        plus.addActionListener(e -> plus());
        minus.addActionListener(e -> minus());
        divide.addActionListener(e -> divide());
        multiply.addActionListener(e -> multiply());
        decimal.addActionListener(e -> decimal());
        equals.addActionListener(e -> equals());
        backspace.addActionListener(e -> backspace());
        empty.addActionListener(e -> empty());
        
        frame.getRootPane().setDefaultButton(equals);
    }
    
    private void one(){
        output.setText(output.getText()+"1");
    }
    
    private void two(){
        output.setText(output.getText()+"2");
    }
    
    private void three(){
        output.setText(output.getText()+"3");
    }
    
    private void four(){
        output.setText(output.getText()+"4");
    }
    
    private void five(){
        output.setText(output.getText()+"5");
    }
    
    private void six(){
        output.setText(output.getText()+"6");
    }
    
    private void seven(){
        output.setText(output.getText()+"7");
    }
    
    private void eight(){
        output.setText(output.getText()+"8");
    }
    
    private void nine(){
        output.setText(output.getText()+"9");
    }
    
    private void zero(){
        output.setText(output.getText()+"0");
    }
    
    private void minus(){
        output.setText(output.getText()+"-");
    }
    
    private void plus(){
        output.setText(output.getText()+"+");
    }
    
    private void multiply(){
        output.setText(output.getText()+"x");
    }
    
    private void divide(){
        output.setText(output.getText()+"/");
    }
    
    private void decimal(){
        output.setText(output.getText()+".");
    }
    
    private void equals(){
        String out = output.getText();
        String finalOut = getAnswer(out);
        if (finalOut.endsWith(".0")){
            output.setText(finalOut.substring(0,finalOut.length()-2));
        }
        else{
            output.setText(finalOut);
        }
    }
    
    private String getAnswer(String out){
        pemdas = new Pemdas();
        return pemdas.getAnswer(out);
    }
    
    private void empty(){
        output.setText("");
    }
    
    private void backspace(){
        String newOutput = output.getText().substring(0,output.getText().length()-1);
        output.setText(newOutput);
    }
    
    public static void main(String args[]){
        new GUI();
    }
 
}

package 可视化按钮;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ColorPane extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton buttons[];
	private String names[]={"blue","cyan","green","magenta","orange","pink","red","white","yellow"};
    private Container container;
    private GridLayout grid;
    public ColorPane(){
    	super("GridLayout ColorPane ");
    	grid=new GridLayout(3,3);
    	container =getContentPane();
    	container.setLayout(grid);
    	buttons=new JButton[names.length];
    	for (int count=0;count<names.length;count++){
    		buttons[count]=new JButton(names[count]);
    		buttons[count].addActionListener(this);
    		container.add(buttons[count]);
    	}
    	setSize(300,300);
    	setVisible(true);	
    }
    public void actionPerformed (ActionEvent e){
    	JButton button = (JButton)e.getSource();
    	try {
    		Color c = (Color)Class.forName("java.awt.Color").getField(button.getText()).get(null);
    		if(button.getBackground().equals(c)) {
    			button.setBackground(null);
    		} else {
    			button.setBackground(c);
    		}
		} catch (Exception e1) { }
    }
    public static void main(String args[]){
    	new ColorPane();
    }
}

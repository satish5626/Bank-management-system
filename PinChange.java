
package bank.management.systems;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,14));
        text.setBounds(180,230,400,30);
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("system",Font.BOLD,14));
        pintext.setBounds(140,280,150,25);
        image.add(pintext);
        
         pin=new JPasswordField();
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(270,280,120,25);
        image.add(pin);
        
        JLabel repintext=new JLabel("Re-Enter New PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("system",Font.BOLD,14));
        repintext.setBounds(140,320,150,25);
        image.add(repintext);
        
         repin=new JPasswordField();
        repin.setFont(new Font("Railway",Font.BOLD,22));
        repin.setBounds(270,320,120,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(120, 380, 100, 25);
        change.setFont(new Font("Raleway", Font.BOLD, 12));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(290, 380, 100, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
         if (ae.getSource() == change) {
            
        try {
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered pin does not match");
                return;
            }
        if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                return;
            }
         if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                return;
         }
         Conn con=new Conn();
         //change three tables bank ,signupthree,login in these three tables if we can change the pin update 3 tables.
         
           String query1="update bank set pin='"+rpin+"' where pin ='"+pinnumber+"'";  
           String query2="update login set pin='"+rpin+"' where pin ='"+pinnumber+"'";    
           String query3="update signupthree set pin='"+rpin+"' where pin ='"+pinnumber+"'";  
           
           con.stmt.executeUpdate(query1);
           con.stmt.executeUpdate(query2);
           con.stmt.executeUpdate(query3);
           
           JOptionPane.showMessageDialog(null, "PIN Changed successfully");
           setVisible(false);
           new Transactions(rpin).setVisible(true);
                
        }catch (Exception e){
            System.out.println(e);
        }
    }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
        public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}

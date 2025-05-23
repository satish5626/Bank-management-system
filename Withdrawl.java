
    
package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text =new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAWl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,10));
        text.setBounds(150,250,600,35);
        image.add(text);
        
        amount =new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,12));
        amount.setBounds(150,290,220,20);
        image.add(amount);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(300,375,100,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back=new JButton("Back");
        back.setBounds(300,405,100,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date(); //import java.util.*; package
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "please enter the amount you want to withdraw");
            }else {
                try{
                Conn con=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+number+" Withdraw successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                } 
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            
           new Transactions(pinnumber).setVisible(true); 
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("");
    }
    
}



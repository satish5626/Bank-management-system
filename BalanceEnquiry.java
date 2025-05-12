package bank.management.systems;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(300, 400, 100, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);
        
        Conn con=new Conn(); 
        int balance=0;
        try{
            
            ResultSet rs=con.stmt.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            
            while(rs.next()){
                String type=rs.getString("type");
                int transactionAmount = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) { // Ensure case-insensitive matching
                    balance += transactionAmount;
                } else {
                    balance -= transactionAmount;
                }
            }
                }catch (Exception e){
                        System.out.println(e);
                        }
        JLabel text=new JLabel("Your current account balance is Rs. "+balance );
        text.setForeground(Color.WHITE);
        text.setBounds(140,250,400,25);
        image.add(text);
            
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    
}

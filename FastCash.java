package bank.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,fastcash,pinchange,balanceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(160,250,600,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,14));
        image.add(text);
        
         deposit = new JButton("Rs 100");
        deposit.setBounds(125,315,120,25);
        deposit.setFont(new Font("Raleway", Font.BOLD, 12));
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(280,315,120,25);
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 12));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash = new JButton("Rs 1000");
        fastcash.setBounds(125,345,120,25);
        fastcash.setFont(new Font("Raleway", Font.BOLD, 12));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement = new JButton("Rs 2000");
        ministatement.setBounds(280,345,120,25);
        ministatement.setFont(new Font("Raleway", Font.BOLD, 12));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange = new JButton("Rs 5000");
        pinchange.setBounds(125,375,120,25);
        pinchange.setFont(new Font("Raleway", Font.BOLD, 12));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(280,375,120,25);
        balanceenquiry.setFont(new Font("Raleway", Font.BOLD, 12));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         exit = new JButton("BACK");
        exit.setBounds(280,405,120,25);
        exit.setFont(new Font("Raleway", Font.BOLD, 12));
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
          }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);//Typecast
            Conn con=new Conn();                               //trim the Rs and space 
        try{
            
            ResultSet rs=con.stmt.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            int balance=0;
            while(rs.next()){
                String type=rs.getString("type");
                int transactionAmount = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) { // Ensure case-insensitive matching
                    balance += transactionAmount;
                } else {
                    balance -= transactionAmount;
                }
                
            }
            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            
            Date date=new Date();
            String query ="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
            con.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited successfully");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
    }
    public static void main(String[] args) {
      new   FastCash("");
    }
    
}

    


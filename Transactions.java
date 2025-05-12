
package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,fastcash,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("please select your Transaction");
        text.setBounds(160,250,600,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,14));
        image.add(text);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(125,315,120,25);
        deposit.setFont(new Font("Raleway", Font.BOLD, 10));
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton(" Cash Withdrawl");
        withdrawl.setBounds(280,315,120,25);
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 10));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(125,345,120,25);
        fastcash.setFont(new Font("Raleway", Font.BOLD, 10));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement = new JButton(" Mini Statement");
        ministatement.setBounds(280,345,120,25);
        ministatement.setFont(new Font("Raleway", Font.BOLD, 10));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange = new JButton("PIN Change");
        pinchange.setBounds(125,375,120,25);
        pinchange.setFont(new Font("Raleway", Font.BOLD, 10));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balanceenquiry = new JButton(" Balance Enquiry");
        balanceenquiry.setBounds(280,375,120,25);
        balanceenquiry.setFont(new Font("Raleway", Font.BOLD, 10));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         exit = new JButton(" Exit");
        exit.setBounds(280,405,120,25);
        exit.setFont(new Font("Raleway", Font.BOLD, 10));
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
    }else if(ae.getSource()==deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
    }else if(ae.getSource()==withdrawl){
        setVisible(false);
        new Withdrawl(pinnumber).setVisible(true);
    }else if(ae.getSource()==fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
    }else if(ae.getSource()==pinchange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
    }else if(ae.getSource()==balanceenquiry){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
    }else if(ae.getSource()==ministatement){
        setVisible(false);
        new MiniStatement(pinnumber).setVisible(true);
    }
    }
    public static void main(String[] args) {
      new   Transactions("");
    }
    
}

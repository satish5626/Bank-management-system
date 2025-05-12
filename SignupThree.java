
package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
   SignupThree(String formno){
       this.formno=formno;
       
       setLayout(null);
       
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(850, 1100)); 
       
       
       JLabel i1=new JLabel("Page 3: Account Details");
       i1.setFont(new Font("Raleway",Font.BOLD,22));
       i1.setBounds(280,30,400,40);
       panel.add(i1);
       
       
        JLabel type=new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,90,200,30);
        panel.add(type);
       
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,130,150,30);
        panel.add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,130,250,30);
        panel.add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,170,250,30);
        panel.add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,170,250,30);
        panel.add(r4);
        
        ButtonGroup groupaccount =new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,250,200,30);
        panel.add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-6774");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,250,300,30);
        panel.add(number);
        
        JLabel carddetail=new JLabel("Your 16 digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,280,300,20);
        panel.add(carddetail);
        
         JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,320,200,30);
        panel.add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,320,300,30);
        panel.add(pnumber);
        
        JLabel pindetail=new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,350,300,20);
        panel.add(pindetail);
        
        JLabel services=new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,400,300,30);
        panel.add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,450,200,30);
        panel.add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,450,200,30);
        panel.add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,500,200,30);
        panel.add(c3);
        
        c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,500,200,30);
        panel.add(c4);
        
        c5=new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,550,200,30);
        panel.add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,550,200,30);
        panel.add(c6);
        
        c7=new JCheckBox("I Hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,630,540,30);
        panel.add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        panel.add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        panel.add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 850, 1000);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        
        setSize(850,1000);
        setLocation(350,10);
        setVisible(true);
       
   }
   public void actionPerformed(ActionEvent ae){
       if (ae.getSource()==submit){
         String accountType =null;  
         if(r1.isSelected()){
             accountType ="Saving Account";             
         }else if(r2.isSelected()){
             accountType="Fixed Deposit Account";
         }else if(r3.isSelected()){
             accountType="Current Account";
         }else if(r4.isSelected()){
             accountType="Recuuring Deposit Account";
         }
         Random random = new Random();
         String cardnumber =""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
         
         String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
         
         String facility="";
         if(c1.isSelected()){
             facility =facility+"ATM Card";
         }else if(c2.isSelected()){
             facility =facility+"Internet Banking";
         }else if(c3.isSelected()){
             facility =facility+"Mobile Banking";
         }else if(c4.isSelected()){
             facility =facility+"Email & SMS Alerts";
         }else if(c5.isSelected()){
             facility =facility+"Check Book";
         }else if(c6.isSelected()){
             facility =facility+"E-Statement";
         }
         try{
            if(accountType.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is Required");
            } else {
                Conn con=new Conn();
                String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                con.stmt.executeUpdate(query1);
                con.stmt.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Card Number :"+cardnumber+ "\n pin:"+pinnumber);
                
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
            }
             
         }catch(Exception e){
             System.out.println(e);
         }
         
       }else if(ae.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
         
       }
   }

    
    public static void main(String[] args) {
        new SignupThree("");
    }
    
}

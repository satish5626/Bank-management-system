package bank.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{

    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        
    setTitle("Automated Teller Machine");//set the title
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); 
    Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label =new JLabel(i3);              //set the bank iamge icon
    label.setBounds(70,10,100,100);
    add(label);
    
    JLabel text=new JLabel("WELCOME TO ATM");
    text.setFont(new Font("OsWard",Font.BOLD,38)); //dispaly the welcome to atm 
    text.setBounds(200,40,400,40);
    add(text);
    
    JLabel cardno =new JLabel("Card No:");
    cardno.setFont(new Font("Raleway",Font.BOLD,28));  //display card no
    cardno.setBounds(120,150,150,30);
    add(cardno);
    
    cardTextField=new JTextField();
    cardTextField.setBounds(300,150,250,30);
    cardTextField.setFont(new Font("Arial",Font.BOLD,14)); //card no text field
    add(cardTextField);
    
    JLabel pin=new JLabel("PIN:");
    pin.setFont(new Font("Raleway",Font.BOLD,28)); //display pin 
    pin.setBounds(120,220,250,40);
    add(pin);
    
    pinTextField=new JPasswordField();
    pinTextField.setBounds(300,220,250,30);
    pinTextField.setFont(new Font("Arial",Font.BOLD,14)); //pin text field
    add(pinTextField);
    
    
    login =new JButton("SIGN IN");
    login.setBounds(300,300,100,30);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);//sign in button 
    login.addActionListener(this);
    add(login);
    
    
    
    clear =new JButton("CLEAR");
    clear.setBounds(430,300,100,30);
    clear.setBackground(Color.BLACK);// clear button
    clear.setForeground(Color.WHITE);
    clear.addActionListener(this);
    add(clear);
    
    signup =new JButton("SIGN UP");
    signup.setBounds(300,350,230,30);
    signup.setBackground(Color.BLACK); //signup button
    signup.setForeground(Color.WHITE);
    signup.addActionListener(this);
    add(signup);
    
    
    
    
    getContentPane().setBackground(Color.WHITE);
    
        setSize(700,700);
        setLocation(300,200);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==clear){
        cardTextField.setText("");
        pinTextField.setText("");
    } else if(ae.getSource()==login){
        Conn con=new Conn();
        String cardnumber=cardTextField.getText();
        String pinnumber=pinTextField.getText();
        String query="select * from login where cardnumber ='"+cardnumber+"' and pin ='"+pinnumber+"'";
        try{
            ResultSet rs=con.stmt.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "Incorrect card Number and PIN");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }else if (ae.getSource()==signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
    }
    public static void main(String[] args) {
        new Login();
        
    }
    
}

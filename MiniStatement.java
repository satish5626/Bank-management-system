
package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank =new JLabel("Indian Overseas Bank");
        bank.setBounds(80,20,150,20);
        add(bank);
        
         JLabel card =new JLabel();
        card.setBounds(20,80,250,20);
        add(card);
        
        try{
            Conn con=new Conn();
            ResultSet rs=con.stmt.executeQuery("select * from login where pin ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number :"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
        try {
            Conn con=new Conn();
            ResultSet rs =con.stmt.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            while(rs.next()){
           mini.setText(mini.getText()+ "<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
             
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,100,320,200);
        
        setSize(350,500);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }

    
    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}

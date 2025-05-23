package bank.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,occupation,education;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.WHITE);
        panel2.setPreferredSize(new Dimension(850, 1100));
        
        setTitle("NEW APPLICATION FORM- PAGE 2");
        
        
        JLabel additionalDetails=new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,28));
        additionalDetails.setBounds(290,80,400,30);
        panel2.add( additionalDetails);
        
        JLabel name=new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        panel2.add(name);
        
        String valReligion[]={"Hindu","Muslim","sikh","Christian","other"};
        religion=new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,140,400,30);
        panel2.add(religion);
        
        
        JLabel categorys=new JLabel("Category :");
        categorys.setFont(new Font("Raleway",Font.BOLD,20));
        categorys.setBounds(100,190,200,30);
        panel2.add(categorys);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        panel2.add(category);
        
        
        JLabel incomes=new JLabel("Income :");
        incomes.setFont(new Font("Raleway",Font.BOLD,20));
        incomes.setBounds(100,240,200,30);
        panel2.add(incomes);
        
        String incomeCategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        panel2.add(income);
        
        
        
        JLabel educations=new JLabel("Educational");
        educations.setFont(new Font("Raleway",Font.BOLD,20));
        educations.setBounds(100,290,200,30);
        panel2.add(educations);
           
        JLabel qualification=new JLabel("Qualification :");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        panel2.add(qualification);
        
        String educationValues[]={"Graduate","Non-Graduate","Post-Graduation","Doctrate","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        panel2.add(education);
        
        
        JLabel occupations=new JLabel("Occupation :");
        occupations.setFont(new Font("Raleway",Font.BOLD,20));
        occupations.setBounds(100,390,200,30);
        panel2.add(occupations);
        
        String occupationValues[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        panel2.add(occupation);
        
        JLabel pannumber=new JLabel("PAN Number :");
        pannumber.setFont(new Font("Raleway",Font.BOLD,20));
        pannumber.setBounds(100,440,200,30);
        panel2.add(pannumber);
        
        panTextField =new JTextField();
        panTextField.setFont(new Font("Railway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        panel2.add(panTextField);
        
        JLabel aadharnumber=new JLabel("Aadhar Number :");
        aadharnumber.setFont(new Font("Raleway",Font.BOLD,20));
        aadharnumber.setBounds(100,490,200,30);
        panel2.add(aadharnumber);
        
        aadharTextField =new JTextField();
        aadharTextField.setFont(new Font("Railway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        panel2.add(aadharTextField);
        
        JLabel seniorcitizen=new JLabel("Senior citizen :");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,540,200,30);
        panel2.add(seniorcitizen);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        panel2.add(syes);
        
        sno= new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        panel2.add(sno);
        
        ButtonGroup seniorCitizen=new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);
        
        
        
        JLabel existingacc=new JLabel("Exisiting Account:");
        existingacc.setFont(new Font("Raleway",Font.BOLD,20));
        existingacc.setBounds(100,590,200,30);
        panel2.add(existingacc);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        panel2.add(eyes);
        
        eno= new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        panel2.add(eno);
        
        ButtonGroup existingAcc=new ButtonGroup();
        existingAcc.add(eyes);
        existingAcc.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(600,640,80,30);
        next.addActionListener(this);
        panel2.add(next);
        
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setBounds(0, 0, 850, 1000);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,1000);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingacc=null;
        if(eyes.isSelected()){
            existingacc="Yes";
        }else if(eno.isSelected()){
            existingacc="No";
        }
        
        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();
        
        
        try{
            
                Conn con=new Conn();
                String query ="insert into signuptwo values('"+formno+ "','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingacc+"')";
                con.stmt.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
       new SignupTwo("");
    }
    
}



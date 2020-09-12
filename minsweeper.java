//USELES  NUMBER =   101
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class minsweeper implements ActionListener
{
    int moves=0;
    int start=0;
    int gridsize;//=10;
    int minesize;//=10;
    JFrame f;
    GridLayout g1;//=new GridLayout(gridsize,gridsize,0,0);
    int ff;//=(gridsize*gridsize)*2;
    JButton B1,B2,B3,B4,B5;
    JTextField tf1,tf2;
    JLabel l1,l2;
    JButton B[];//=new JButton[ff];
    JPanel jp=new JPanel();
    JPanel jp1[];//=new JPanel[ff/2];
    int a[];//=new int[ff/2];
    int bb[];//=new int[ff/2];//IT KEEP ALL THAT VALUE IN ARRAY WHICH IS CREATED AFTER BOMB AND ITS COUNT
    int fh;//=(gridsize+2);
    int min,max;//=(fh*fh)-(fh+1)-2;//81-12=69
    
    int randomNum[];//new int[minesize];//IT KEPT RANDOM NUMBER GENERATED B/W 8 TO 40
    int count[];//=new int[fh*fh];//COUNT ARROUND BOMB
    int setarray[];//=new int[fh*fh];//ARRAY WHERE BOMB AND ITS COUNT ARE KEPT
    CardLayout cl1=new CardLayout();
    int count3=1;
    Random rand = new Random();
    int dd[];//=new int[gridsize*gridsize];
 int countt=0;
int ggg;//=gridsize-10;
int check[];//=new int[fh*fh];
int opened[];//=new int[fh*fh];
int countopen=0;
int nn=0;
//int gh1=500+(10*ggg);
    minsweeper(String g,int grd,int mins)
            
    {
         gridsize=grd;
    minesize=mins;
        ff=(gridsize*gridsize)*2;
        fh=(gridsize+2);
        max=(fh*fh)-(fh+1)-2;min=fh+1;
        randomNum=new int[minesize];
        count=new int[fh*fh];
        setarray=new int[fh*fh];
        dd=new int[gridsize*gridsize];
        check=new int[fh*fh];
        opened=new int[fh*fh];
        ggg=gridsize-10;
        a=new int[ff/2];
        bb=new int[ff/2];
        jp1=new JPanel[ff/2];
        B=new JButton[ff];
        g1=new GridLayout(gridsize,gridsize,0,0);
        
        f=new JFrame(g);
        B1=new JButton("START");
        B1.setBounds(5,5,100,30);
        B1.addActionListener(this);
        f.add(B1);
        B2=new JButton("BEGINNER");
        B2.setBounds(115,5,100,30);
        B2.addActionListener(this);
        f.add(B2);
        B3=new JButton("MEDIUM");
        B3.setBounds(220,5,100,30);
        B3.addActionListener(this);
        f.add(B3);
        B4=new JButton("EXPERT");
        B4.setBounds(325,5,100,30);
        B4.addActionListener(this);
        f.add(B4);
        B5=new JButton("RESET");
        B5.setBounds(430,5,100,30);
        B5.addActionListener(this);
        f.add(B5);
        l1=new JLabel("MOVES");
        l1.setBounds(535,5,50,10);
        
        f.add(l1);
        tf1=new JTextField("0");
        tf1.setBounds(535,16,70,25);
        
        f.add(tf1);
        l2=new JLabel("RESULT");
        l2.setBounds(620,5,50,10);
        
        f.add(l2);
        tf2=new JTextField();
        tf2.setBounds(620,16,70,25);
        
        f.add(tf2);
       int count=0;
        for(int j=0;j<gridsize*gridsize;j++)
        {
            jp1[j]=new JPanel();
            jp1[j].setLayout(cl1);
            for(int i=0;i<2;i++)
            {
                
                String hh=String.valueOf(count);
             B[count]=new JButton();
             
            if(count%2==0)//ADD ACTION LISTENER TO ONLY FRONT BUTTON
             B[count].addActionListener(this);
               B[count].setSize(10,10);
            jp1[j].add(B[count]);
              count++;
            }
            
            jp.add(jp1[j]);
        }
        jp.setLayout(g1);
        
        if(gridsize<16)
        {jp.setBounds(50,50,600,600);
            jp.setSize(600,600);}
        else
        { jp.setBounds(50,50,800,800);
            jp.setSize(700,700); } 
        f.add(jp);
        
//SET USELESS ARRAY AROUND OVER BOX PLACE WHERE WE HAVE KEPT 101
//ARE USELESS .IT IS USED HERE TO EASY CALCULATE AROUND BOMB
setarrayuseless();
 for(int i=0;i<fh*fh;i++)
        {
            System.out.print(i+"="+setarray[i]+"\t");
            if(i%fh==fh-1)
                System.out.println();
        }

//SET USELESS ARRAY AROUND OVER BOX PLACE WHERE WE HAVE KEPT 101
//ARE USELESS .IT IS USED HERE TO EASY CALCULATE AROUND BOMB       

//SET ARRAY WHERE BOMB CAN BE GENERATED
setarraywherebomb();
//SET ARRAY WHERE BOMB CAN BE GENERATED

 
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent e)
	{
            
            //HERE MINES ARE SET FIRSTLY
            //THEN SET COUNTIMG AROUND MINES
            //THE OPEN THE BUTTON WHICH WE HAVE A CLICKED AND NEAR BY TO THAT BUTTON 
            for(int i1=0;i1<B.length/2;i1++)
            {
                if(e.getSource()==B[i1*2]&&count3==1&&start==1)
                {
                   
                                                
                                               if(count3==1)
                                                {
//GENERATE RANDOM ARRAY
 for(int j=0;j<minesize;j++)
                                     {
                                  int r = rand.nextInt((max - min) + 1) + min;
                                     int g2=check1(r);
                   //CHECK IF  BUTTON PRESS IS START WITH ZERO
                                  int t2=check2(r,i1);
                                     //bb[i1]==r means jo button press kiya h vo toh bomb ni
                                  //bb[i1] main value of array store krayi thi h
                                  
                                  if(g2==0||bb[i1]==r||t2==0)
                                         j--;
                                     else
                                     {
                                         randomNum[j]=r;
                                         setarray[r]=100;
                                          System.out.println(randomNum[j]);
                                     }

   //RANDOM ARRAY
                                     
                                   }
 //PRINT ARRAY
 for(int i=0;i<(fh*fh);i++)
        {
            System.out.print(i+"="+setarray[i]+"\t");
            if(i%fh==(fh-1))
                System.out.println();
        }
        
 //RANDOM ARRAY
//SET ARRAY WHERE COUNTING ARE KEPT AROUND THE BOMB AND GIVING VALUE OF WHOLE 
 //ARRAY TO BUTTON
setarray();

//PRINT ARRAY
for(int i=0;i<(fh*fh);i++)
        {
            System.out.print(i+"="+setarray[i]+"\t");
            if(i%9==8)
                System.out.println();
        }
        
                                    
                                             }
                                               count3++;
                                               //HERE WE CHECK ALL 0 NEAR TO PRESSED BUTTON 
                                               openarraynearby(bb[i1]);
                                              //HERE WE ARE OPENING BUTTON FOR FIRST TIME
                                             openfirstclick();
                                             cl1.next(jp1[i1]);
                                             String mov="";
                                             mov=mov+String.valueOf(moves);
                                              tf1.setText(mov);
                                               
                                               
                                              
            }
        }
            //HERE MINES ARE SET FIRSTLY
            //THEN SET COUNTIMG AROUND MINES
            //THE OPEN THE BUTTON WHICH WE HAVE A CLICKED AND NEAR BY TO THAT BUTTON 
            
            
            //REPEATIN WORKING
            if(nn!=1)//nn take check where game is not over if game is over nn=0 -> to nn=1
            {
            for(int i2=0;i2<B.length/2;i2++)
            {
                if(e.getSource()==B[i2*2]&&!B[i2*2+1].getText().equals("X")&&start==1)
                {
                    cl1.next(jp1[i2]);
                    moves++;
                    String mov="";
                                             mov=mov+String.valueOf(moves);
                                              tf1.setText(mov);
                }
                else if(e.getSource()==B[i2*2]&&start==1)
                {
                   tf2.setText("LOSS");
                   tf2.setBackground(Color.red);
                  JOptionPane.showMessageDialog(null,"SORRY! YOU HAVE PRESSED THE MINE");
                   nn++;
                }
            }
            }
            //REPEATIN WORKING
           
         if(e.getSource()==B1)
         {
             start=1;
         }
         if(e.getSource()==B2)
         {
             f.dispose();
            
             new minsweeper("MINESWEEPER by Amit Sachdeva",8,16);
         }
         if(e.getSource()==B3)
         {
             f.dispose();
            
             new minsweeper("MINESWEEPER by Amit Sachdeva",12,24);
         }
         if(e.getSource()==B4)
         {
             f.dispose();
            
             new minsweeper("MINESWEEPER by Amit Sachdeva",17,34);
         }
         if(e.getSource()==B5)
         {
             f.dispose();
            
             new minsweeper("MINESWEEPER by Amit Sachdeva",gridsize,minesize);
         }
         
           
     }
    //************************SET USELESS ARRAY AROUND OVER BOX PLACE WHERE WE HAVE KEPT 101
//***************************ARE USELESS .IT IS USED HERE TO EASY CALCULATE AROUND BOMB
    void setarrayuseless()
    {
        int k=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<fh;j++)
            { 
                if(i==0)
                {
                   setarray[j]=101;
                   check[j]=1;
                }
                else if(i==2)
                {
                    setarray[fh*j]=101;
                    check[fh*j]=1;
                    
                }
                else if(i==3)
                {
                setarray[(fh)*(fh-1)+j]=101;
                check[(fh)*(fh-1)+j]=1;
                }
                else
                {
                    setarray[(fh-1)+fh*j]=101;
                    check[(fh-1)+fh*j]=1;
                }
            }
        }
      
    }
    //*********************************HERE WE ARE COUNTING ARROUND BOMB
    void setarray()
    {
        
      for(int i=(fh+1);i<((fh*fh)-(fh+1));i++)
      {
          if(setarray[i]==0)
          {
              
           if(setarray[i-(fh+1)]==100)
           {
               count[i]++;}
           if(setarray[i-(fh)]==100)
           {
               count[i]++;}
           if(setarray[i-(fh-1)]==100)
           {     count[i]++;}
           if(setarray[i-1]==100)
           { count[i]++;}
           if(setarray[i+1]==100)
           {  count[i]++;}
           if(setarray[i+(fh-1)]==100)
           {   count[i]++;}
           if(setarray[i+fh]==100)
           {  count[i]++;}
           if(setarray[i+(fh+1)]==100)
           {    count[i]++;}
           setarray[i]=count[i];
          
          }
          System.out.println();          
      }
      //ASSIGN BUTTON A VALUE AND BOMB
      int count21=0; String jj;
      for(int k=(fh+1);k<((fh*fh)-(fh+1));k++)
      {
       if(setarray[k]!=101)
       {
         a[count21]=setarray[k];
             jj=String.valueOf(a[count21]);
            if(a[count21]!=100&&a[count21]!=0) 
            { B[1+2*count21].setText(jj);
              B[1+2*count21].setEnabled(false);  
             }
            else if(a[count21]==0)
            {
               B[1+2*count21].setText("");
              B[1+2*count21].setEnabled(false); 
            }
           else
            {
              B[1+2*count21].setText("X");  
              B[1+2*count21].setEnabled(false); 
            }
           count21++;
           
       }
       
      }
      //ASSIGN BUTTON A VALUE AND BOMB
    
    }
    //********************CHECK RANDOM NUMBER GENERATE IS NOT EQUAL TO USELESS NUMBER 
 int check1(int r)
 {
     //CHECK WHETHER NEW NUMBER GENERATED IS NOT ALREADY PRESENT
     for(int i=0;i<minesize;i++)
     {
         if(randomNum[i]==r)
         {
             return 0;
         }
     }
     //CHECK WHETHER NEW NUMBER GENERATED NOT EQUAL TO USELESS number
     for(int i=(fh+1);i<((fh*fh)-(fh+1));i++)
     {
      if(setarray[i]==101&&i==r)
          return 0;
     }
    
     return 1;
 }
 //SET WHERE BOMB CAN BE GENERATED
 void setarraywherebomb()
 {int count33=0;
    for(int i=0;i<(fh*fh)-1;i++)
    {
        if(setarray[i]!=101)
        {
            bb[count33]=i;
            count33++;
        }
    }
 }
   //*******************CHECK WHETHER BOMB IS NOT GENERATED ADJACENT TO BUTTON PRESS
 int check2(int r,int i1)
 {
    //1) bb[i1] stores the value of array and have value of array which button is pressed
     //2)r is random no. generated 
     //3)we check whether button pressed does not have bomb around it so that
     //its value =0 .
     //4)k-10 etc check whether random number generated is not adjacent to button press
    
    
    int u=bb[i1];
    int k=r;
     if(k-(fh+1)==u||k-(fh)==u||k-(fh-1)==u||k-1==u||k+1==u||k+(fh-1)==u||k+fh==u||k+(fh+1)==u)
           { return 0;}
          
           return 1;
 }
void openarraynearby(int by)
 { //1)OPENED[i] HAVE VALUE OF ARRAY[ fh*fh] which HAVE BEEN TRAVERSED
     //2)CHECK[i] CONTAIN i=THAT PLACE IN ARRAY[fh*Fh] WHICH WE HAVE TRAVERSED NOT AGAIN TRAVERSED
     //3)logic::::HERE WHEN WE GET ZERO WE CALL RECURSIVLY FUCNTION AND IT CHECK ALL AROUND AND IF GET ANY ZERO THEN AGAIN CALL SAME FUNCTION
     //4) FIRST IF CHECK POSITION ON WHICH WE ARE CURRENTLY PRESENT !=0 THEN WE RETURN ADDING IN OPENED ARRAY
     if(setarray[by]!=0)
     {
       //  check[by]=1;
         opened[by]=1;
         
         return;
     }
     else
     {
                                opened[by]=1;
                                
                           
                         if(setarray[by-(fh+1)]==0&&check[by-(fh+1)]==0)
                           {
                               check[by-(fh+1)]=1;
                               openarraynearby(by-(fh+1));
                           }
                           else
                           {
                                 opened[by-(fh+1)]=1;
                                 
                           }
                         
                         if(setarray[by-(fh)]==0&&check[by-(fh)]==0)
                           {
                               check[by-(fh)]=1;
                               openarraynearby(by-(fh));
                           }
                           else
                           {
                                 
                                 opened[by-(fh)]=1;
                           }
                         
                         if(setarray[by-(fh-1)]==0&&check[by-(fh-1)]==0)
                           {
                               check[by-(fh-1)]=1;
                               openarraynearby(by-(fh-1));
                           }
                           else
                           {
                                 opened[by-(fh-1)]=1;
                                 
                           }
                         
                          if(setarray[by-1]==0&&check[by-1]==0)
                           {
                               check[by-1]=1;
                               openarraynearby(by-1);
                           }
                           else
                           {
                                 opened[by-1]=1;
                               
                           }
                          
                          if(setarray[by+1]==0&&check[by+1]==0)
                           {
                               check[by+1]=1;
                               openarraynearby(by+1);
                           }
                           else
                           {
                                 opened[by+1]=1;
                                
                           }
                          
                          if(setarray[by+fh]==0&&check[by+fh]==0)
                           {
                               check[by+fh]=1;
                               openarraynearby(by+fh);
                           }
                           else
                           {
                                 opened[by+fh]=1;
                                
                           }
                          
                           if(setarray[by+fh+1]==0&&check[by+fh+1]==0)
                           {
                               check[by+fh+1]=1;
                               openarraynearby(by+fh+1);
                           }
                           else
                           {
                                 opened[by+fh+1]=1;
                               
                           }
                           
                           if(setarray[by+fh-1]==0&&check[by+fh-1]==0)
                           {
                               check[by+fh-1]=1;
                               openarraynearby(by+fh-1);
                           }
                           else
                           {
                                 opened[by+fh-1]=1;
                                 
                           }
                           return;
                         
     }
 
     
      
   
 }
//OPENED ALL BUTTON WHICH IS STORED IN ARRAY
void openfirstclick()
{
    for(int i=0;i<fh*fh;i++)
    {
        if(opened[i]==1)
        openbutton(i);
    }
}
void openbutton(int gg)
{
    for(int i=0;i<bb.length;i++)
    {
        if(gg==bb[i])
        {
            cl1.next(jp1[i]);
            return;
        }
    }
    
    
}
//OPENED ALL BUTTON WHICH IS STORED IN ARRAY
public static void main(String... s)
    {
        new minsweeper("MINSWEEPER by Amit Sachdeva",8,16);
    }
}

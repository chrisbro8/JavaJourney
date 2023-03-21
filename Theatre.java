/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.theatre;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.ArrayList;
/**
 *s
 * @author ehima
 */
public class Theatre {

  public static void main(String args[] ){
    int[] row0=new int[12];
    int[] row1=new int[16];
    int[] row2=new int[20];
    int[][] collectedarray=new int[3][0];
    Arrays.fill(row0,0);
    Arrays.fill(row1,0);
    Arrays.fill(row2,0);
    collectedarray[0]=row0;
    collectedarray[1]=row1;
    collectedarray[2]=row2;
    String[][] convertnum={{"O","O","O","O","O","O","O","O","O","O","O","O"},
                          {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"},
                          {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"}};
    
    
    //The class creaction Sections

    
    
    
    //Save file for one-time preloaded save
    File SAVEFILE= new File("SaveFile.txt");
    try{
        
        FileWriter file_writer=new FileWriter("SaveFile.txt");
        for(int i=0;i<convertnum.length;i++){
            file_writer.write("row"+(i+1)+":");
            for(int j=0;j<convertnum[i].length;j++){
                file_writer.write(convertnum[i][j]);
                if((j+1)==(convertnum[i].length)/2){
                    file_writer.write(" ");
                    
                }
                
                
            
            }
            file_writer.write("\n");
            
        }
        
        file_writer.close();

    }catch(IOException e){
        System.out.print("An Error has Occurred");
        e.printStackTrace();//Check for the errors

    }
   

    int useroption=0;
    boolean loop=true;
    boolean cancel=false;
    boolean match=true;
    int rownumber=0;
    int seatnumber=0;
    double pricenumber=0;
    
    
    

    ArrayList<Ticket> TicketList = new ArrayList<Ticket>();
    ArrayList<Person> personList = new ArrayList<Person>();
    System.out.println("Welcome to the New Theatre\n");
   
                  
    
    while (loop){
        
        String name;
        String surname;
        String email;
        Person personk1=new Person();
        Ticket  personk=new Ticket(personk1);

           
        
        Scanner inputnum=new Scanner(System.in);
       
        if (match){
            String line="--------------------------------------------";
            
            System.out.println(line);
            System.out.println("Please select an option:\n");
            System.out.println("1) Buy a ticket\n");
            System.out.println("2) Print seating area\n");
            System.out.println("3) Cancel ticket\n");
            System.out.println("4) List avaliable seat\n");
            System.out.println("5) Save to file\n");
            System.out.println("6) Load from file\n");
            System.out.println("7) Print ticket information and total price\n");
            System.out.println("8) Sort tickets by price\n");
            System.out.println("0) Quit\n");
            System.out.println(line);
            
             
              boolean option=true;
              Scanner input=new Scanner(System.in);
              
           
              while(option){
                  
         
                    try{
                        System.out.print("Enter an Option:");

               
                
               
                        useroption=input.nextInt();
                       
                       option=false;
                       System.out.print("\n");
                       
                    }catch(InputMismatchException e){
                        option=true;
                        System.out.println("You entered a wrong data-type");
                        input.next();
                        
                
                      
                      
                    }
              }
              try{


                
                

                    if (useroption==1){
                        Scanner inputperson=new Scanner(System.in);
                        System.out.print("Enter your name :");
                        name=inputperson.next();
                        personk1.setname(name);
                        

                        
                       
                        System.out.print("Enter your Surname :");
                        surname=inputperson.next();
                        personk1.setsurname(surname);
                        
                        System.out.print("Enter your email address :");
                        email=inputperson.next();
                        personk1.setemail(email);
                        personk.setPerson(personk1);
                      
                       
                        
                  }
                    int useroption2=useroption;
                    if((useroption2<0) || (useroption2>8)){
                        option=true;
                        System.out.println("Useroption is out Of Range");
                    }

                
                
                
                
            
                
            

            

                switch(useroption){ 
                    case 1:{
                        
                       
                    //input already declared


                    boolean correctnumber=true;
                    
                    while (correctnumber==true){
                        

                        
                        
                      
                            
                            Scanner input3=new Scanner(System.in);
                            match=true;
                            System.out.println("\n");
                            System.out.println("Purchasing a  new Seat");
                            System.out.print("Enter the Row-Number:");

                            rownumber=inputnum.nextInt();
                            personk.setrow(rownumber);
                            System.out.print("Enter the Seat-Number:");
                            seatnumber=inputnum.nextInt();
                            personk.setseat(rownumber);

                            if ((seatnumber>0 && seatnumber<=20)&&(rownumber>0 && rownumber<=3)){
                                correctnumber=false;
                                System.out.print("Enter the ticket price £");
                                pricenumber=input3.nextDouble();
                                personk.setprice(pricenumber);
                                buy_ticket(rownumber,seatnumber,collectedarray,cancel);
                                convertnum=print_seating_area(collectedarray);
                                





                            }
                            else{
                                System.out.println("The Input entered is Out of range");
                            }

                        
                       
                        
                        
                          
                    }
                    TicketList.add(personk);
                    personList.add(personk1);
                    break;

                    }
                    case 2:{
                        convertnum=print_seating_area(collectedarray);
                        System.out.print("     ");
                        System.out.println("***********");
                        System.out.print("\n");
                        System.out.print("     ");
                        System.out.print("*  ");
                        System.out.print("STAGE");
                        System.out.println("  *");
                        System.out.print("\n");
                        System.out.print("     ");
                        System.out.println("***********");
                        int k=0;

                        for(int i=0;i<convertnum.length;i++){
                            int size=(20-convertnum[i].length)/2;
                            String space=" ".repeat(size);
                            System.out.println(" ");
                            if (size>0&&((k==0))){
                                space=" ".repeat(size);
                                System.out.print(space);
                            }
                            for(int j=0;j<(convertnum[i].length);j++){
                                System.out.print(convertnum[i][j]);
                                if ((0.5*(convertnum[i].length)-1)==j){
                                    System.out.print(" ");
                                }
                                if ((size>0) && (j+1==convertnum[i].length)){
                                    System.out.print(space);
                                }
                            }




                        }
                        System.out.print("\n");
                        break;
                    }

                    case 3:{
                        System.out.println("You are about to cancel a ticket!");
                        
                        //already have scanner input up-top
                        
                        boolean valid=true;
                        String enter="false";
                        
                        while (valid){
                            valid=false;
                       
                            System.out.print("Enter the Row-Number:");
                            rownumber=inputnum.nextInt();
                            
                            System.out.print("Enter the Seat-Number:");
                            seatnumber=inputnum.nextInt();
                           
                            
                            
                            if (rownumber>3 || rownumber <0){
                                System.out.println("That Row doesnt exist");
                                valid=true;
                            }
                            if (valid==false &&(seatnumber>collectedarray[rownumber-1].length || seatnumber<1)){
                                System.out.println("That Seat doesnt exist");
                                valid=true;
                            }
                            if (valid==false){
                                
                            int i=0;
                            for(Ticket personkk:TicketList){

                                if ( personkk.getseat()==seatnumber &&(personkk.getrow()==rownumber)){
                                    enter="true";
                                    break;

                                }
                                i++;
                            }
                            int removedata=i;
                           
                            TicketList.remove(removedata); 
                            personList.remove(removedata);
                            if(enter=="true"){
                            System.out.println("###############################");
                            System.out.println("Sucessfully cancelled a Ticket");
                            System.out.println("###############################");
                            }
                            
                            
                             
                                collectedarray=cancel_ticket(rownumber,seatnumber,collectedarray);
                                print_seating_area(collectedarray);
                                cancel=true;
                                
                                buy_ticket(rownumber,seatnumber,collectedarray,cancel);
                                cancel=false;
                                
                            
                            
                            
                            
                            }
                        }
                        
                        break;
                    }
                    case 4:{
                        show_avaliable(collectedarray);
                        break;
                    }
                    case 5:{
                        convertnum=print_seating_area(collectedarray);
                        save(convertnum);
                        break;
                    }
                    case 6:{
                        load(SAVEFILE);

                        break;
                    }
                    case 7:{
                        
                        show_info_ticket(TicketList);
                        match=true;
                        
                        break;
                            
                    }
                    case 8:{
                        
                        
                        break;
                    }
                    case 0:{
                        System.out.println("Quitted the Program");
                        loop=false;
                    }
                }
        
                //match=false;
            }catch(InputMismatchException e){
                System.out.println("Invalid input-type");
                loop=true;
                inputnum.next();
                                
                                
            } 
            
        }
            



    }
  }




  public static int buy_ticket(int rownumber,int seatnumber,int[][] collectedarray,boolean cancel){
    

    
      if (rownumber==1){

        if(collectedarray[0][seatnumber-1]==0 && cancel==false) {


          collectedarray[0][seatnumber-1]=1;

          System.out.println("###############################");
          System.out.println("You Successfully Purchased Row 1,Seat "+seatnumber);
          System.out.println("\n\n\nYou Booked your ticket");
        }else{
          if(cancel==false){
            System.out.println("The Seat "+seatnumber+" Row 1 has been Taken");
          }else{
            System.out.println("The Seat "+seatnumber+",Row 1 has been Cancelled");
          }
        }
      }
      else if (rownumber==2 && cancel==false){

        if(collectedarray[1][seatnumber-1]==0) {
          collectedarray[1][seatnumber-1]=1;
          System.out.println("###############################");
          System.out.println("You Successfully Purchased Row 2,Seat "+seatnumber);
          System.out.println("\n\n\nYou Booked your ticket");
        }else{
          if(cancel==false){
            System.out.println("The Seat "+seatnumber+" Row 2 has been Taken");
          }else{
            System.out.println("The Seat "+seatnumber+",Row 2 has been Cancelled");
          }
        }
      }
      else if (rownumber==3 && cancel==false){
        if(collectedarray[2][seatnumber-1]==0){
          System.out.println("###############################");
          System.out.println("You Successfully Purchased Row 3,Seat "+seatnumber);
          System.out.println("\n\n\nYou Booked your ticket");
          collectedarray[2][seatnumber-1]=1;
        }else{
          if(cancel==false){
            System.out.println("The Seat "+seatnumber+" Row 3 has been Taken");
          }else{
            System.out.println("The Seat "+seatnumber+" Row 3 has been Cancelled");
          }
        }
      }
    

         
        
    
    return 0; 
 }






  
  
  
  
  
  
  
  
  
  public static String[][] print_seating_area(int [][]collectedarray){
    String[][] convertnum={{"O","O","O","O","O","O","O","O","O","O","O","O"},
                          {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"},
                          {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"}};
 
    for( int i=0;i<=(collectedarray.length)-1;i++){
      for(int j=0;j<=(collectedarray[i].length)-1;j++){
        if (collectedarray[i][j]==1){
          convertnum[i][j]="X";
        }
        else if(collectedarray[i][j]!=1){
          convertnum[i][j]="O";
          
          
        } 
      }
    }
   
    return convertnum;

  }
  public static int[][] cancel_ticket(int rownumber,int seatnumber,int[][] collectedarray){
    
    
    if(rownumber==1){
      if(collectedarray[0][seatnumber-1]==1)
        collectedarray[0][seatnumber-1]=0;

    }
    else if(rownumber==2){
      if(collectedarray[1][seatnumber-1]==1)
        collectedarray[1][seatnumber-1]=0;
      
    }
    else if(rownumber==3){
      if(collectedarray[2][seatnumber-1]==1){
        collectedarray[2][seatnumber-1]=0;
      }
      
    }

    return collectedarray;
  }


  public static void show_avaliable(int[][] collectedarray){
    print_seating_area(collectedarray);
    for( int i=0;i<=(collectedarray.length)-1;i++){
      System.out.print("Seat avaliable in row "+(i+1)+" :");
      for(int j=0;j<=(collectedarray[i].length)-1;j++){
        if (collectedarray[i][j]==0){
          System.out.print(" "+(j+1));
          
          
     
        }
        if(j<(collectedarray[i].length)-1 && collectedarray[i][j]==0){
          System.out.print(",");

        }
      }
      System.out.print(".");
      System.out.print("\n");
    }

  }
  public static void save(String[][] convertnum){
      System.out.println("......Saving the row informations........");
    try{
        File SAVEFILE= new File("SaveFile.txt");
        FileWriter file_writer=new FileWriter("SaveFile.txt");
        for(int i=0;i<convertnum.length;i++){
            file_writer.write("row"+(i+1)+":");
            for(int j=0;j<convertnum[i].length;j++){
                file_writer.write(convertnum[i][j]);
                if((j+1)==(convertnum[i].length)/2){
                    file_writer.write(" ");
                    
                }
                
            
            }
            file_writer.write("\n");
            
        }
        
        file_writer.close();

    }catch(IOException e){
        System.out.print("An Error has Occurred");
        e.printStackTrace();//Check for the errors

    }
  }
  public static void load(File SAVEFILE){
      System.out.println("......loading the Row infortmations........");
      try {
      Scanner read_file = new Scanner(SAVEFILE);
      while (read_file.hasNextLine()) {
        String row_info= read_file.nextLine();
        System.out.println(row_info);
      }
      read_file.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
  public static void show_info_ticket(ArrayList<Ticket> TicketList){
     double total=0;
   
    for (Ticket x: TicketList) {
        System.out.println("###############");
         x.print();
         total=total+x.getprice();
         System.out.println("\n##################");
         
         
     }
          
          System.out.println("total price:"+total);

      
      
      
      
   
          
      
  }
  public static void sort_tickets(int[] array){
      int minIndex, temp;
      for(int start = 0; start < array.length-1; start++){
          minIndex = start;
        for(int i = start+1; i <= array.length-1; i++){
            if(array[i] < array[minIndex]) minIndex = i;
        }
        temp = array[start];
        array[start] = array[minIndex];
        array[minIndex] = temp;
      }
  }
      
}


 











    
  

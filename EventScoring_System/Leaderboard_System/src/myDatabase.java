
import java.util.Scanner;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myDatabase {
    
    private static Connection getDBConnection() throws InstantiationException, IllegalAccessException
    {
        Connection dbConnection=null;
        try
        {
            Class.forName("og.apache.derby.jdbc.clientDriver").newInstance();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            String dburl="jdbc:derby://localhost:1527/F1_Systemsdb;create=true";
            dbConnection=DriverManager.getConnection(dburl);
            System.out.println("Testing connect: Connected to the database !!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
            
        return dbConnection;
                
    }
    
    public static void addIndividual(String name,String team,String gender,int individualpoints) throws InstantiationException, IllegalAccessException
    {
     int id=0;
     Connection dbConnection=null;
     Statement statement=null;
     ResultSet resultset=null;
     String querycount="SELECT COUNT(ID) FROM Individuals";
     String queryIndividuals="Select * FROM Individuals";
     
     try
     {
         dbConnection=getDBConnection();
         statement=dbConnection.createStatement();
         resultset=statement.executeQuery(querycount);
         while(resultset.next())
         {
             id=resultset.getInt(1);
         }
         id=id+1;
         System.out.println("Next ID for the individual will be " + id);
         System.out.println(queryIndividuals);
     }
     catch(SQLException e)
     {
         System.out.println(e.getMessage());
     }
     finally
     {
         if(resultset !=null)
         {
             try {
                 resultset.close();
             } catch (SQLException ex) {
                 Logger.getLogger(myDatabase.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }
     
     String query="INSERT INTO INDIVIDUALS (ID, NAME, TEAM, GENDER, INDIVIDUALPOINTS)" 
             + "VALUEs  ("+id+",'"+name+"','"+team+"','"+gender+"',"+individualpoints+")";
     
     try
     {
         dbConnection=getDBConnection();
         statement=dbConnection.createStatement();
         System.out.println(query);
         statement.executeUpdate(query);
         System.out.println("Individual is inserted into individual table  !!!");
         
     }
     catch(SQLException ex)
     {
         Logger.getLogger(myDatabase.class.getName()).log(Level.SEVERE, null, ex);
     }
    finally
     {
         if(statement!=null)
         {
             try
             {
                 statement.close();
             }
             catch(SQLException ex)
             {
                 Logger.getLogger(myDatabase.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         if(dbConnection!=null)
         {
             try
             {
                 dbConnection.close();
             }
             catch(SQLException ex)
             {
                  Logger.getLogger(myDatabase.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         
     }
       
    }
    
    public static void OptionAddIndividual() throws InstantiationException, IllegalAccessException
    {
        Scanner kb=new Scanner(System.in);
        char exit='n';
        do
        {
            System.out.println("Enter Individual name");
            String name=kb.next();
            System.out.println("Enter Team name");
            String team=kb.next();
            System.out.println("Enter Individual gender");
            String gender=kb.next();
            System.out.println("Enter Individual points");
            int individualpoints=kb.nextInt();
            addIndividual(name,team,gender,individualpoints);
            System.out.println("Would you liket to exit?");
            exit=kb.next().charAt(0);
        }
        while(exit !='y');
        System.out.println("Thank you for adding the Participant's information");
    }
    
    public static void removeIndividual(String name) throws InstantiationException, IllegalAccessException
    {
        Connection dbConnection=null;
        PreparedStatement statement=null;
        String queryIndividuals="Delete FROM individuals where name='"+name+"'";
        try
        {
            dbConnection=getDBConnection();
            statement=dbConnection.prepareStatement(queryIndividuals);
            System.out.println(queryIndividuals);
            statement.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void optionRemoveIndividual() throws InstantiationException, IllegalAccessException
    {
        Scanner kb=new Scanner(System.in);
        char exit='n';
        do
        {
            System.out.println("Enter Individual name you would like removed");
            String name=kb.next();
            removeIndividual(name);
            System.out.println("Would you like to exit? y/n");
            exit=kb.next().charAt(0);
        }
        while(exit !='y');
        System.out.println("Individual has been removed");
    }
    public static void showIndividualsList() throws InstantiationException, IllegalAccessException
    {
     int id=0;
     Connection dbConnection=null;
     Statement statement=null;
     ResultSet resultset=null;
     String querycount="SELECT COUNT(ID) FROM Individuals";
     String queryIndividuals="Select * FROM Individuals";
     
     try
     {
         dbConnection=getDBConnection();
         statement=dbConnection.createStatement();
         resultset=statement.executeQuery(querycount);
         while(resultset.next())
         {
             id=resultset.getInt(1);
         }
         id=id+1;
         System.out.println("Individual count: " + id);
         System.out.println(queryIndividuals);
         
         resultset=statement.executeQuery(queryIndividuals);
         while(resultset.next())
         {
             System.out.println("Individual id: "+ resultset.getString("ID")+ "\n");
             System.out.println("Individual name: "+ resultset.getString("NAME")+ "\n");
             System.out.println("Team name: "+ resultset.getString("TEAM")+ "\n");
             System.out.println("Individual gender: "+ resultset.getString("GENDER")+ "\n");
             System.out.println("Individual points: "+ resultset.getString("INDIVIDUALPOINTS")+ "\n");
             System.out.println("-------------\n");
         }
     }
     catch(SQLException e)
     {
         System.out.println(e.getMessage());
     }
     finally
     {
         if(resultset !=null)
         {
             try {
                 resultset.close();
             } catch (SQLException ex) {
                 Logger.getLogger(myDatabase.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }
        
    }
    public static String[] getIndividualsList() throws InstantiationException, IllegalAccessException
    {
        String individuals[]=null;
        String individualUpdate[];
        Connection dbConnection=null;
        Statement statement=null;
        ResultSet resultset=null;
        int count=0;
        int index=0;
        String querycount="SELECT COUNT(ID) FROM Individuals";
        String queryIndividuals="Select * FROM Individuals";
        try
     {
         dbConnection=getDBConnection();
         statement=dbConnection.createStatement();
         resultset=statement.executeQuery(querycount);
         while(resultset.next())
         {
             count=resultset.getInt(1);
         }
         count=count+1;
         System.out.println("Individual count: " + count);
         System.out.println(queryIndividuals);
         
         individuals=new String[count];
         
         resultset=statement.executeQuery(queryIndividuals);
         
         while(resultset.next())
         {
             individuals[index]="Individual name: "+ resultset.getString("NAME")+ 
                     "\n Team name: "+ resultset.getString("TEAM")+
                     "\n Gender: "+ resultset.getString("GENDER")+ 
                     "\n Individual points: "+ "\n__________________ -\n";
             index++;
         }
     }
     catch(SQLException e)
     {
         System.out.println(e.getMessage());
     }
     finally
     {
         if(resultset !=null)
         {
             try {
                 resultset.close();
             } catch (SQLException ex) {
                 Logger.getLogger(myDatabase.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }
        
        individualUpdate=new String[count-1];
        for(int i=0;i<(count-1);i++)
        {
            individualUpdate[i]=individuals[i];
        }
        for(int i=0;i<(count-1);i++)
        {
            System.out.println(individualUpdate[i]);
        }
        
        return individualUpdate;
             
        
    }
    
    public static void menu() throws InstantiationException, IllegalAccessException
    {
        Scanner kb=new Scanner(System.in);
        char exit='n';
        int option= 0;
        System.out.println("Enter a choice");
        do
        {
            System.out.println("             1- Connect to database \n"
                    + "         2- Add an individual \n"
                    + "         3- Remove an individual \n"
                    + "         4- Show individual list \n"
                    + "         5- Get an individual \n"
                    + "         6- Exit");
            option=kb.nextInt();
            
            switch(option)
            {
                case 1: System.out.println("Connected to database");
                getDBConnection();
                break;
                case 2: System.out.println("Add individual");
                //addIndividual(String name,String team,String gender,int individualpoints)
                
                //addIndividual("John","Team Red","Male",0);
                OptionAddIndividual();
                break;
                
                case 3: System.out.println("Remove an individual");
                optionRemoveIndividual();
                break;
                
                case 4: System.out.println("Individual list");
                showIndividualsList();
                break;
                
                case 5: System.out.println("Get an individual");
                getIndividualsList();
                break;
                case 6: System.out.println("Thanks and goodbye");
                exit='y';
                break;
                default:
                System.out.println("Choose again");
                break;
            }
        }
        while(exit !='y');
        
                
    }
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException
    {
        menu();
    }
    
}

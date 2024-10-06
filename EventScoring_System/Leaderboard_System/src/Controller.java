
import java.io.ObjectInputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author goget
 */
public class Controller 
{
    public static void main(String[] args)
    {
        Individual I1= new Individual();
        Individual I2= new Individual();
        Individual I3= new Individual();
        Individual I4= new Individual();
        Individual I5= new Individual();
        Individual I6= new Individual();
        Individual I7= new Individual();
        Individual I8= new Individual();
        Individual I9= new Individual();
        Individual I10= new Individual();
        
        I1.setName("Jonathan");
        I1.setID(1);
        I1.setGender("Male");
        
        I2.setName("Jerry");
        I2.setID(2);
        I2.setGender("Male");
        
        I3.setName("Levi");
        I3.setID(3);
        I3.setGender("Male");
        
        I4.setName("Kiri");
        I4.setID(4);
        I4.setGender("Male");
        
        I5.setName("Jack");
        I5.setID(5);
        I5.setGender("Male");
        
        I6.setName("Sara");
        I6.setID(6);
        I6.setGender("FemaLe");
        
        I7.setName("Terry");
        I7.setID(7);
        I7.setGender("Female");
        
        I8.setName("Tyson");
        I8.setID(8);
        I8.setGender("Male");
        
        I9.setName("Kiritsugu");
        I9.setID(9);
        I9.setGender("Male");
        
        I10.setName("Melly");
        I10.setID(10);
        I10.setGender("Female");
        
        Team team1=new Team("Red", 5);
        Team team2=new Team("Black", 5);
        
        team1.addIndividual(I1);
        team1.addIndividual(I2);
        team1.addIndividual(I3);
        team1.addIndividual(I4);
        team1.addIndividual(I5);
        
        team2.addIndividual(I6);
        team2.addIndividual(I7);
        team2.addIndividual(I8);
        team2.addIndividual(I9);
        team2.addIndividual(I10);
        
        team1.teamSetPoints(0, 100);
        team1.TeamRank(1, 0);
        team1.showInformation();
        team1.printInfo();
        team2.showInformation();
        
        Event E1=new Event("Sporting",2);
        E1.addTeams(team1);
        E1.addTeams(team2);
        E1.getTeamsInformartion();
        E1.countTeams();
        E1.individualList();
        
        Event E2=new Event("Academics",4);
        E2.addTeams(team1);
        E2.addTeams(team2);
        E2.getTeamsInformartion();
        E2.countTeams();
        E2.individualList();
        
        Event E3=new Event("Racing event",3);
        
        
         System.out.println("**************Tournament*****************");
       
        String[] test= E1.startEvent();
        
        for(int i=0;i<test.length;i++)
        {
           System.out.println("test: "+ test[i]);
        }
         System.out.println("************** Points *****************");
         test=E1.eventPoints();
         for(int i=0;i<test.length;i++)
        {
           System.out.println("test: "+ test[i]);
        }
         team1.getIndividuals(1);
         
    }
    
}
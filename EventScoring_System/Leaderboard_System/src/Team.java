import java.util.ArrayList;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Team 
{
    
    private String teamName;
    private Individual[] individual;
    private int index;
    private int count;
    private int teamPoints;
    private int totalTeamPoints;
    

    public Team (String teamName, int totalIndividuals)
    {
        this.teamName= teamName;
        this.individual=new Individual[totalIndividuals];
        count= 0;
        this.teamPoints= 0;
        this.totalTeamPoints= 0;
    }
    public void addIndividual(Individual M)
    {
        this.individual[this.index]=M;
        individual[index].setID(index);
        this.index++;
        this.count++;
    }

   public void countIndividual()
    {
        System.out.println("Members total: " + this.count);
       
    }
   
    public int getCount()
    {
        return count;
    }
    
    public void countPoints()
    {
        for(int i=0; i<this.index;i++)
        {
            this.teamPoints= this.teamPoints;
            
        }
        this.setTeampoints(teamPoints);
    }
    public void setTotalPoints()
    {
        this.totalTeamPoints= this.totalTeamPoints+ this.getTeamPoints();
    }
    public void setTeamName(String teamName)
    {
        this.teamName= teamName;
    }
    public String getTeamName()
    {
        return teamName;
    }
    public int getTeamPoints()
    {
        return teamPoints;
    }
    
    public void teamSetPoints(int index,int points)
    {
        
        this.individual[index].setPoints(points);
        
        System.out.println("Team: "+ this.individual[index].getName()+" got "+points+" points");
    }
     public void teamSetTotalPoints(int index)
    {
         this.individual[index].setTotalPoints();
        
        System.out.println("Team: "+ this.individual[index].getName()+" got "+this.individual[index]+" Total points");
    }
     public int teamGetTotalPoints(int index)
     {
        return this.individual[index].getTotalPoints();
     }
    public void setTeampoints(int teamPoints)
    {
        this.teamPoints= teamPoints;
    }
    public void printInfo()
     {
         for(int i=0;i<this.index;i++)
         {
         System.out.println("Member Id: "+ this.individual[i].getID()+" Member name:  " + this.individual[i].getName()+ 
                 " Team name: " + this.getTeamName());
         }
     }
     public void showInformation()
     {
         for(int i=0;i<this.index;i++)
         {
         System.out.println("Member ID: "+ this.individual[i].getID()+" Individual name: " + this.individual[i].getName() + 
                 ",Team: " + this.getTeamName()+ 
                 ",points: " + this.teamGetTotalPoints(i));
         }
     }
      public String[] getIndividualA()
     {
         String individual[]=new String[count];
         for(int i=0;i<this.index;i++)
         {
          individual[i]=this.individual[i].getID()+" Individual name:  " + 
                  this.individual[i].getName()+ " Team: " + this.getTeamName();
         }
         return individual;
     }
      public String getIndividuals(int i)
     {
         String member[]=new String[count];
         
         
        return  "Individual name: " + 
                  this.individual[i].getName() + " Team: " 
                + this.getTeamName();
     
     }
      public String TeamRank(int rank, int i)
       {
            return  "Rank position: " + rank+  " Team: " + this.getTeamName();
       }
     public String TeamFinalRank(int rank, int i){
       
            return  "Final Rank:" + rank+  "Team: " 
            + this.getTeamName(); 

       }

    int getCountIndividuals() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    
    

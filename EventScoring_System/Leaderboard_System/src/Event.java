
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author goget
 */
public class Event 
{
    Team[] teams;
    String eventName;
    String ranks;
    int index;
    int count=0;
    int countIndividuals=0;
    private String individuals[];
    
    public Event(String eventName,int numberTeams)
    {
        teams=new Team[numberTeams];
        this.eventName=eventName;
        this.index=0;
        this.count=0;
        this.countIndividuals=0;
    }
    public void setEventName(String eventName)
    {
        this.eventName= eventName;
    }
    public String getEventName()
    {
        return eventName;
    }
     public void addTeams(Team t)
    {
        teams[index]=t;
        teams[index].getCount();
        System.out.println("Team :"+index+" Team information");
        teams[index].showInformation();
        index++;
        count++;
       
    }
      public void countTeams()
    {
        
        for(int i=0;i<this.count;i++)
        {
            System.out.println("i: "+i);
            for(int k=0;k<teams[i].getCount();k++)
            {
             
                this.countIndividuals++;
           
            }
        }
    }
      
      public void countIndividualsTeams()
      {
          for(int i=0;i<this.count;i++)
          {
              for(int j=0;j<teams[i].getCountIndividuals();j++)
              {
                  this.countIndividuals++;
                  System.out.println("Count individuals so far: " + this.countIndividuals);
              }
          }
      }
      
      
      public void individualsListToFile()
      {
          try
          {
              FileWriter mywriter=new FileWriter("individuallist.txt");
              this.individuals=new String[this.countIndividuals];
              int count=0;
              for(int i=0;i<this.count;i++)
              {
                  for(int j=0;j<teams[i].getCountIndividuals();j++)
                  {
                      individuals[count]=teams[i].getIndividuals((j));
                      mywriter.write(individuals[count]);
                      count++;
                  }
              }
              mywriter.close();
              System.out.println("Individuals list wrote in the file successfully!!");
          }
          catch(IOException e)
          {
              System.out.println("An error occured!!");
              e.printStackTrace();
              
          }
      }
      public String[] individualListFromFile()
      {
          String individuals[]=new String[this.countIndividuals];
          int count=0;
          String info=" "; 
          try
          {
              File myFile=new File("individuallist.txt");
              Scanner myReader=new Scanner(myFile);
              while(myReader.hasNextLine())
              {
                  String data=myReader.nextLine();
                  info=info+data+"\n";
                  if(data.contains("-"))
                  {
                      individuals[count]=info;
                      info=" ";
                      count++;
                  }
              }
              myReader.close();
          }
          catch(FileNotFoundException e)
          {
              System.out.println("An error occured");
              e.printStackTrace();
          }
          return individuals;
      }
      public String[] getIndividualsList()
      {
          return this.individuals;
      }
      public void setIndividualsList(String [] a)
      {
          this.individuals=a;
      }
      
     public void individualList()
    {
        System.out.println(this.eventName+" Event ");
        this.individuals=new String[this.countIndividuals];
        int count=0;
        for(int i=0;i<this.count;i++)
        {
            for(int j=0;j<teams[i].getCount();j++)
            {
                individuals[count]=teams[i].getIndividuals(j);
                System.out.println(individuals[count]);
                count++;
            }
        }
        System.out.println("Total individuals "+this.countIndividuals);
        System.out.println("individuals array length"+ individuals.length);
    }
     
     
     public void getTeamsInformartion()
    {
        for(int i=0;i<count;i++)
        {
            this.teams[i].showInformation();
        }
    }
     public String[] rankPosition()
    {
         System.out.println("Rank Position");
         System.out.println("count individuals" + countIndividuals);
         String individuals[]=new String[countIndividuals];
         int size=this.countIndividuals;
         
          ArrayList<Integer> list= new ArrayList<Integer>(size);
          int number[]=new int[size];
          int rank=0;
          int count=0;
          
          for(int i=1; i<=size;i++)
          {
              list.add(i);
          }
          Random rand= new Random();
          while(list.size()>0)
          {
          int index=rand.nextInt(list.size());
            
              
           
              number[rank]=list.remove(index);
             
             
              System.out.println(number[rank]);
              
              individuals[number[rank]-1]="Rank position: "+ number[rank] +""+ this.individuals[count];
              System.out.println("***"+individuals[number[rank]-1]);
              count++;
              
          }  
             
          return individuals; 
        
    }
     public String[] startEvent()
     {
         System.out.println("count individuals: " + countIndividuals);
         String drivers[]=new String[countIndividuals];
          int size=countIndividuals;
          ArrayList<Integer> list= new ArrayList<Integer>(size);
          int number[]=new int[size];
          int rank=0;
          int count=0;
          
          for(int i=1; i<=size;i++)
          {
              list.add(i);
          }
          Random rand= new Random();
          while(list.size()>0)
          {
          int index=rand.nextInt(list.size());
            
              
           
              number[rank]=list.remove(index);
                      
              
              drivers[number[rank]-1]="Final Rank within team: "+ number[rank] +" "+ this.individuals[count];
              
              count++;
              
          }
         return individuals; 
     }
     public String[] eventPoints()
      {
           String Teams[]=this.startEvent();
            int points=0;
          for(int i=0;i<Teams.length;i++)
          {
              switch(i)
              {
                  case 0: points=50; 
                  break;
                  case 1: points=40; 
                  break;
                  case 2: points=25; 
                  break;
                  case 3: points=10;
                  break;
                  case 4: points= 5;
                  break;
                  case 5: points= 10;
                  break;
                  case 6: points= 35;
                  break;
                  case 7: points= 40;
                  break;
                          
                  default: points=0; break;
              }
               Teams[i]=Teams[i]+" points: "+points;
          }
             
          return Teams; 
          
      }
      
}

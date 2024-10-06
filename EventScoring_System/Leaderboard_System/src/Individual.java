/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author goget
 */
public class Individual
{
    private int id;
    private String name;
    private String gender;
    private int points;
    public int totalPoints;
    
    public Individual()
    {
        this.id= 0;
        this.name= "";
        this.gender= "Male";
        this.points= 0;
        this.totalPoints= 0;
    }

    public void setPoints(int points)
    {
        this.points= points;
    }
    public int getPoints()
    {
        return points;
    }
    
    public void setTotalPoints()
    {
        this.totalPoints=this.totalPoints + this.getPoints();
    }
    public int getTotalPoints()
    {
        return this.totalPoints;
    }
    
    public void setID(int id)
    {
        this.id= id;
    }
    public int getID()
    {
        return id;
    }
    
    public void setName(String name)
    {
        this.name= name;
    }
    public String getName()
    {
        return name;
    }
    
    public void setGender(String gender)
    {
        this.gender= gender;
    }
    public String getGender()
    {
        return gender;
    }
    public String individual()
    { 
        return this.getName()+ ", id : "+ this.getID()+ ", Gender: " + this.getGender();
    }
    
}

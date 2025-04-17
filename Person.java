import java.util.ArrayList;

public class Person {
    public ArrayList<Item> inventory;
    public int health = 100;
    public int points = 0;
    //Location currentLocation = ;

    public Person(int health, int points) {
        this.health = health;
        this.points = points;
        this.inventory = new ArrayList<>(); 
    }

    //uses current location
    public void lookAround(){
    }

    //uses NPCs who are in the current location
    public void talk(npc){
    }

    //gives desc of current location
    public String search(){
    }

    public void fight(item){
    }

    //with fist
    public void fight(){
    }

    //gives desc of item
    public String lookAt(item){
    }

    public void pickUp(item){
    }

    public void drop(item){
    }

    //unlocked once stage 3 reached
    protected void save(drainedStudent){
    }


    
}
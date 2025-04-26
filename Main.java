import java.util.Scanner;
public class Main {

    public void setUp(){
        Location bioLab = new Location("Bio Lab", "The biology lab has many workstations set up for dissection. There are pins at each table and a tank of frogs in the back corner. On the drying rack, there lies a bunch of scalpels ready for the upcoming dissection.", true);
        Location chemLab = new Location("Chem Lab", "The chem lab has shiny gray countertops. It looks like a class was just in here. The chem teacher has taught here forever, but he doesn’t look a day over 25. You’ve gotta learn his skin care routine. Small beakers sit on the drying rack next to the sink. In the corner is a beaker with a solution still inside...", true);
        Location cafe = new Location("Cafe", "This is the school's cafeteria. Dozens of long tables sit in organized rows. Two students linger at the back of the cafeteria on their phones. Near the front of the room is a kitchen. Cooking utensils lie around: spoons, tongs, spatula, and a knife...", true);
        Location englishRoom = new Location("English Room", "Your English teacher decorated her room based on her favorite gothic novel, Dracula. The whole room has a red and black theme and is always dimly lit. In the corner, you can just barely make out another student. Their phone light brightens up the underside of their face, giving them a flashlight under face campfire scary story effect.", true);
        Location gym = new Location("Gym", "The gym walls are covered in banners won by different students over the years. The golf team was known across the country, they had won nationals ten years in a row. However, the team this year was known to be pranksters and particularly rebellious. Come to think of it, you haven’t seen any of the team in a while… strange. However, one of their golf clubs is resting against the far gym wall.", true);
        Location historyRoom = new Location("History Room", "The history room is pretty textbook high school classroom. On the walls, hung maps display all the different parts of the world. On the wall closest to you, there is a map of Europe with a pin marking the center of Romania. In a desk in the far back corner, there is a leftover note and a sharpened pencil lying next to it.", true);
        Location mathRoom = new Location("Math Room", "Your math teacher leaned hard into the dad puns on posters. She even has one that says, “Not all math jokes are bad, just sum”. It’s weird that she’s so lame, she seems so young… but she acts like she’s no younger than 55.", true);
        Location studyRoom = new Location("Study Room", "This was the study room dedicated to the seniors. The room has a few couches and some bean bags. The floor is littered with backpacks of seniors who gave up on using lockers two years ago. One senior is chilling in the corner, reading a book.", true);
        Location homeRoom= new Location("Home Room", "Your homeroom classroom is typically used as a physics classroom. There are posters around the room with bad physics puns, such as I’m not lazy, I’m just overflowing with potential energy. On your desk, there is a sharpened pencil and a note left by a previous student. You are early, and only one other student is in class yet. Your teacher is sitting at their desk. They seem particularly happy today, they radiate a youthful exuberance.", true); 
        Location hallwayOne= new Location("Hallway One", "This hallway has a door to the study room to the left and the entrance to the gym to the right. Behind you is hallway two.", false); 
        Location hallwayTwo= new Location("Hallway Two", "There are no rooms directly connected to this hallway but up ahead of you in hallway one you can see some more rooms. Behind you in hallway three you can also see some more doors.", false); 
        Location hallwayThree= new Location("Hallway Three", "In this hallway to your right there is the door to your homeroom. To your left there is the entrance to the school but it is always locked while school is in session. In front of you is hallway two and behind you is hallway five.", false); 
        Location hallwayFive= new Location("Hallway Five", "There are no doors directly connected to this hallway but in ahead of you is hallway 3 where you can see some doors. Behind you is hallway six where you can make out some more doors.", false); 
        Location hallwaySix= new Location("Hallway Six", "To your left is the entrance to the english room and behind you is the entrance to the history room. In front of you is hallway five and to your right is hallway seven", false); 
        Location hallwaySeven= new Location("Hallway Seven", "To your left is the entrance to the math room. Behind you is hallway six and in front of you is hallway eight.", false); 
        Location hallwayEight= new Location("Hallway Eight", "To your left is the chem lab and to your right is the bio lab. Behind you is hallway seven and in front of you is hallway nine.", false); 
        Location hallwayNine=  new Location("Hallway Nine", "To your left is one of the entrances to the cafe. In front of you is hallway ten and behind you is hallway eight.", false); 
        Location hallwayTen= new Location("Hallway Ten", "To your left is another entrance to the cafe. Behind you is hallway nine and in front of you is hallway eleven.", false); 
        Location hallwayEleven= new Location("Hallway Eleven", "In front of you is hallway twelve and behind you is hallway eleven.", false); 
        Location hallwayTwelve= new Location("Hallway Twelve", "In front of you is the entrance to the library and behind you is hallway eleven.", true); 
        Weapon golfClub= new Weapon("Golf Club", "A shiny nine iron that once belonged to the golf team.", "You swing and hit you enemy with the golf club. It makes a great loud thwack.", gym, false, 5 ); 
        gym.addItem(golfClub);
        BreakableWeapon sharpenedPencil1= new BreakableWeapon("Sharpened Pencil", "An insanely sharp #2 pencil. This thing would be a beast on a standardized test.", "You jab your opponent with the sharpened pencil. It breaks skin.", homeRoom, false, 2, 2); 
        homeRoom.addItem(sharpenedPencil1); 
        Weapon acid= new Acid(chemLab, false); 
        chemLab.addItem(acid);
        BreakableWeapon sharpenedPencil2= new BreakableWeapon("Sharpened Pencil", "An insanely sharp #2 pencil. This thing would be a beast on a standardized test.", "You jab your opponent with the sharpened pencil. It breaks skin.", historyRoom, false, 2, 2); 
        historyRoom.addItem(sharpenedPencil2); 
        BreakableWeapon ruler= new BreakableWeapon("Ruler", "A wooden ruler with both inches and cenimeters depending on which side you use. How exciting!", "You slap your opponent with a ruler. It's not very effective but it does more than your hands.", mathRoom, false, 2, 4); 
        mathRoom.addItem(ruler);
        Weapon scalpel= new Weapon("Scalpel", "A super sharp scalpel. Originally intended for dissections, but could be useful in some sticky situations.", "You slice your opponent with your scalpel. That one is gonna leave a nasty mark.", bioLab, false, 5); 
        bioLab.addItem(scalpel);
        Weapon knife= new Weapon("knife", "A shiny black and silver kitchen knife.", "You stab your opponent with the knife. It makes and awful squishing noise. Gross.", cafe, false, 6 ); 
        cafe.addItem(knife);
        Student homeRoomStudent= new Student("Student","Your fellow classmate who is locked in on some homework.", homeRoom, 100, false); 
        homeRoom.addNPC(homeRoomStudent);
        Student englishRoomStudent= new Student("Student", "Your classmate sits in the corner of the room. He is playing a video game on his phone.", englishRoom, 100, false); 
        englishRoom.addNPC(englishRoomStudent); 


    }
    
    
}

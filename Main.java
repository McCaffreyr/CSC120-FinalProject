import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class Main {
    //booleans
    Boolean phaseOneComplete; 
    Boolean phaseTwoComplete;
    Boolean phaseThreeComplete;

    //locations
    LocationMap map;
    Location nullLocation;  
    Location bioLab;
    Location chemLab;
    Location cafe;
    Location englishRoom;
    Location gym;
    Location historyRoom;
    Location mathRoom;
    Location studyRoom;
    Location homeRoom;
    Location hallwayOne;
    Location hallwayTwo;
    Location hallwayThree;
    Location hallwayFive;
    Location hallwaySix;
    Location hallwaySeven;
    Location hallwayEight;
    Location hallwayNine;
    Location hallwayTen;
    Location hallwayEleven;
    Location hallwayTwelve;
    Location libraryRoomOne; 
    Location libraryRoomTwo; 
    Location libraryRoomThree; 
    Location libraryRoomFour; 
    Location libraryRoomFive; 
    Location libraryRoomSix; 
    Location libraryRoomSeven; 
    Location libraryRoomEight; 
    Location libraryStairs; 
    Location cellarStairs; 
    Location cellarRoomOne; 
    Location cellarRoomTwo; 
    Location cellarRoomThree; 
    Location cellarRoomFour;
    Location cellarRoomFive; 
    Location cellarRoomSix; 
    Location cellarRoomSeven; 
    Location dungeon;  

    //items
    Item nullItem;
    Weapon golfClub;
    BreakableWeapon yellowSharpenedPencil;
    Weapon acid;
    BreakableWeapon pinkSharpenedPencil;
    BreakableWeapon ruler;
    BreakableWeapon syringe;
    Weapon scalpel;
    Weapon knife;
    Weapon dictionary;
    Note homeRoomNote; 
    Note historyRoomNote; 
    Note hallwayTwelveNote; 
    Note cellarStairsNote; 
    Item tangled; 
    Item historyOfTransylvania; 
    Item dracula; 

    //npcs
    Student homeRoomStudent;
    Student englishRoomStudent;
    Student studyRoomStudent;
    Student cafeRoomStudent;
    Teacher homeRoomTeacher; 
    HallMonitor hallMonitorOne; 
    HallMonitor hallMonitorTwo; 
    NPC nullNPC;
    Librarian librarian; 
    DrainedStudent drainedStudentOne; 
    DrainedStudent drainedStudentTwo; 
    DrainedStudent drainedStudentThree; 
    DrainedStudent drainedStudentFour; 
    DrainedStudent drainedStudentFive; 
    DrainedStudent drainedStudentSix; 
    DrainedStudent drainedStudentSeven; 
    DrainedStudent drainedStudentEight; 
    DrainedStudent drainedStudentNine; 
    ScienceTeacher scienceTeacher; 

    //player
    Person player;

    //scanner
    Scanner scanner; 


    Main(){ 
        this.phaseOneComplete= false; 
        this.phaseTwoComplete= false; 
        this.phaseThreeComplete= false; 
        this.map = new LocationMap();
        Object[] nullKeyItems={}; 
        //establishing locations
        this.nullLocation= new Location("null Location", "n/a", "n/a", true, nullKeyItems); 

        this.bioLab = new Location("Bio Lab","The biology lab has many workstations set up for dissection. There are pins at each table and a tank of frogs in the back corner.",  "The biology lab has many workstations set up for dissection. There are pins at each table and a tank of frogs in the back corner. On the drying rack, there lies a bunch of SCALPELs ready for the upcoming dissection. Near the teacher's desk is a clean and shiny SYRINGE.", true, nullKeyItems);

        this.chemLab = new Location("Chem Lab","The chem lab has shiny gray countertops. It looks like a class was just in here. The chem teacher has taught here forever, but he doesn’t look a day over 25. You’ve gotta learn his skin care routine. ", "The chem lab has shiny gray countertops. It looks like a class was just in here. The chem teacher has taught here forever, but he doesn’t look a day over 25. You’ve gotta learn his skin care routine. Small beakers sit on the drying rack next to the sink. In the corner is a beaker with an ACID solution still inside...", true, nullKeyItems);

        this.cafe = new Location("Cafe","This is the school's cafeteria. Dozens of long tables sit in organized rows. Cooking utensils lie around: spoons, tongs, spatula...", "This is the school's cafeteria. Dozens of long tables sit in organized rows. A student lingers at the back of the cafeteria eating a sandwhich. Near the front of the room is a kitchen. Cooking utensils lie around: spoons, tongs, spatula, and a KNIFE...", true, nullKeyItems);
       
        this.englishRoom = new Location("English Room", "Your English teacher decorated her room based on her favorite gothic novel, Dracula. The whole room has a red and black theme and is always dimly lit.", "Your English teacher decorated her room based on her favorite gothic novel, Dracula. The whole room has a red and black theme and is always dimly lit. In the corner, you can just barely make out another STUDENT. Their phone light brightens up the underside of their face, giving them a flashlight under face campfire scary story effect. On the teachers desk there is a heavy DICTIONARY.", true, nullKeyItems);
      
        this.gym = new Location("Gym", "The gym walls are covered in banners won by different students over the years. The golf team was known across the country, they had won nationals ten years in a row. However, the team this year was known to be pranksters and particularly rebellious. Come to think of it, you haven’t seen any of the team in a while… strange.", "The gym walls are covered in banners won by different students over the years. The golf team was known across the country, they had won nationals ten years in a row. However, the team this year was known to be pranksters and particularly rebellious. Come to think of it, you haven’t seen any of the team in a while… strange. However, one of their GOLF CLUBs is resting against the far gym wall.", true, nullKeyItems);
       
        this.historyRoom = new Location("History Room", "The history room is pretty textbook high school classroom. On the walls, hung maps display all the different parts of the world. On the wall closest to you, there is a map of Europe with a pin marking the center of Romania.", "The history room is pretty textbook high school classroom. On the walls, hung maps display all the different parts of the world. On the wall closest to you, there is a map of Europe with a pin marking the center of Romania. In a desk in the far back corner, there is a leftover note and a PINK SHARPENED PENCIL lying next to it.", true, nullKeyItems);
     
        this.mathRoom = new Location("Math Room", "Your math teacher leaned hard into the dad puns on posters. She even has one that says, “Not all math jokes are bad, just sum”. It’s weird that she’s so lame, she seems so young… but she acts like she’s no younger than 55.", "Your math teacher leaned hard into the dad puns on posters. She even has one that says, “Not all math jokes are bad, just sum”. It’s weird that she’s so lame, she seems so young… but she acts like she’s no younger than 55. A RULER that was left out after geometry class sits on a near desk.", true, nullKeyItems);
       
        this.studyRoom = new Location("Study Room","This was the study room dedicated to the seniors. The room has a few couches and some bean bags. The floor is littered with backpacks of seniors who gave up on using lockers two years ago.",  "This was the study room dedicated to the seniors. The room has a few couches and some bean bags. The floor is littered with backpacks of seniors who gave up on using lockers two years ago. One STUDENT is chilling in the corner, reading a book.", true, nullKeyItems);
       
        this.homeRoom= new Location("Home Room","Your homeroom classroom is typically used as a physics classroom. There are posters around the room with bad physics puns, such as: I’m not lazy, I’m just overflowing with potential energy.", "Your homeroom classroom is typically used as a physics classroom. There are posters around the room with bad physics puns, such as:  I’m not lazy, I’m just overflowing with potential energy. On your desk, there is a YELLOW SHARPENED PENCIL and a NOTE left by a previous student. You are early, and only one other STUDENT is in class yet. Your TEACHER is sitting at their desk. They seem particularly happy today. They radiate a youthful exuberance.", true, nullKeyItems); 
       
        this.hallwayOne= new Location("Hallway One", "This hallway has a door to the study room to the left and the entrance to the gym to the right. Behind you is hallway two.", "This hallway has a door to the study room to the left and the entrance to the gym to the right. Behind you is hallway two.", false, nullKeyItems); 
       
        this.hallwayTwo= new Location("Hallway Two","There are no rooms directly connected to this hallway but up ahead of you in hallway one you can see some more rooms. Behind you in hallway three you can also see some more doors.", "There are no rooms directly connected to this hallway but up ahead of you in hallway one you can see some more rooms. Behind you in hallway three you can also see some more doors.", false, nullKeyItems); 
      
        this.hallwayThree= new Location("Hallway Three", "In this hallway to your right there is the door to your homeroom. To your left there is the entrance to the school but it is always locked while school is in session. In front of you is hallway two and behind you is hallway five.", "In this hallway to your right there is the door to your homeroom. To your left there is the entrance to the school but it is always locked while school is in session. In front of you is hallway two and behind you is hallway five.", false, nullKeyItems); 
      
        this.hallwayFive= new Location("Hallway Five", "There are no doors directly connected to this hallway but in ahead of you is hallway 3 where you can see some doors. Behind you is hallway six where you can make out some more doors.", "There are no doors directly connected to this hallway but in ahead of you is hallway 3 where you can see some doors. Behind you is hallway six where you can make out some more doors.", false,nullKeyItems); 
      
        this.hallwaySix= new Location("Hallway Six", "To your left is the entrance to the english room and behind you is the entrance to the history room. In front of you is hallway five and to your right is hallway seven.", "To your left is the entrance to the english room and behind you is the entrance to the history room. In front of you is hallway five and to your right is hallway seven.", false, nullKeyItems); 
      
        this.hallwaySeven= new Location("Hallway Seven","To your left is the entrance to the math room. Behind you is hallway six and in front of you is hallway eight.",  "To your left is the entrance to the math room. Behind you is hallway six and in front of you is hallway eight.", false, nullKeyItems); 
      
        this.hallwayEight= new Location("Hallway Eight","To your left is the chem lab and to your right is the bio lab. Behind you is hallway seven and in front of you is hallway nine.",  "To your left is the chem lab and to your right is the bio lab. Behind you is hallway seven and in front of you is hallway nine.", false, nullKeyItems); 
       
        this.hallwayNine=  new Location("Hallway Nine", "To your left is one of the entrances to the cafe. In front of you is hallway ten and behind you is hallway eight.", "To your left is one of the entrances to the cafe. In front of you is hallway ten and behind you is hallway eight.", false, nullKeyItems); 
 
        this.hallwayTen= new Location("Hallway Ten","To your left is another entrance to the cafe. Behind you is hallway nine and in front of you is hallway eleven.",  "To your left is another entrance to the cafe. Behind you is hallway nine and in front of you is hallway eleven.", false, nullKeyItems); 
       
        this.hallwayEleven= new Location("Hallway Eleven", "In front of you is hallway twelve and behind you is hallway eleven.", "In front of you is hallway twelve and behind you is hallway eleven.", false, nullKeyItems); 

        this.hallwayTwelve= new Location("Hallway Twelve", "In front of you is the entrance to the library (library room one) and behind you is hallway eleven.", "In front of you is the entrance to the library and behind you is hallway eleven. There is a NOTE on the floor of the hallway.", true, nullKeyItems); 

        this.libraryRoomOne= new Location("Library Room One", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This room has a shelf of books recently returned!", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This room has a shelf of books recently returned!", false, nullKeyItems ); 

        this.libraryRoomTwo= new Location("Library Room Two", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This room has the librarians desk and a looming suspicious bookshelf behind it. \nThere are three book pedastals that seem suspiciously empty. Perhaps it's a good idea to SEARCH for these books. \nA note lies on the librarians desk that reads 1.Gather books 2.Place on pedastals 3.MOVE TO LIBRARY STAIRS. Interesting note... the librarian must be very forgetful!", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This room has the librarians desk and a looming suspicious bookshelf behind it. \nThere are three book pedastals that seem suspiciously empty. Perhaps it's a good idea to SEARCH for these books. \n A note lies on the librarians desk that reads 1.Gather books 2.Place on pedastals 3.MOVE TO LIBRARY STAIRS. Interesting note... the librarian must be very forgetful!", false, nullKeyItems); 

        this.libraryRoomThree= new Location("Library Room Three", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the children's book section.","Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the children's book section.", true, nullKeyItems); 

        this.libraryRoomFour= new Location("Library Room Four", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the young adult section.", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the young adult section.", false, nullKeyItems); 

        this.libraryRoomFive= new Location("Library Room Five", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the poetry section.", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the poetry section.", false, nullKeyItems); 

        this.libraryRoomSix= new Location("Library Room Six", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the non-fiction section.", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the non-fiction section.", true, nullKeyItems );

        this.libraryRoomSeven= new Location("Library Room Seven", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the sci-fi section.", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the sci-fi section.", false, nullKeyItems); 

        this.libraryRoomEight= new Location("Library Room Eight", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the classics section.", "Books, books, and more books. So many rooms in this library. Will you be able to find what you are looking for? This is the classics section.", true , nullKeyItems); 
        
        this.cellarStairs= new Location("Cellar Stairs", "The end of the dark deep stairway. It feels damp and haunting. You can just barley make out CELLAR ROOM ONE from here.","The end of the dark deep stairway. It feels damp and haunting. You can just barely make out CELLAR ROOM ONE from here. There is a crumpled NOTE on the floor.", true, nullKeyItems ); 
        this.cellarRoomOne= new Location("Cellar Room One", "A dimly lit, dark, room that smells awful with not much in it.", "A dimly lit, dark, room that smells awful.", false, nullKeyItems); 
        this.cellarRoomTwo= new Location("Cellar Room Two", "Another dimly lit, dark, room that smells awful with not much in it.", "A dimly lit, dark, room that smells awful.", false, nullKeyItems); 
        this.cellarRoomThree= new Location("Cellar Room Three", "Another dimly lit, dark, room that smells awful with not much in it.", "A dimly lit, dark, room that smells awful.", false, nullKeyItems); 
        this.cellarRoomFour= new Location("Cellar Room Four", "Another dimly lit, dark, room that smells awful with not much in it.", "A dimly lit, dark, room that smells awful.", false, nullKeyItems); 
        this.cellarRoomFive= new Location("Cellar Room Five", "Another poorly lit room.", "Another poorly lit room. However, in the corner of the room you see a DRAINED STUDENT slumped over not moving. Tubes are connected to his arms and a bright green liquid flows out and collects in a bag. The number nine is written above his head.", false ,nullKeyItems); 
        this.cellarRoomSix= new Location("Cellar Room Six", "This room is incredibly dim and stinky", "This room is incredibly dim. However, next to you, you see a DRAINED STUDENT slumped over not moving. Tubes are connected to his arms and a bright green liquid flows out and collects in a bag. The number one is written above his head. Alongside the far wall you see an entrance to a DUNGEON", true, nullKeyItems); 
        this.cellarRoomSeven= new Location("Cellar Room Seven", "Another dimly lit, dark, room that smells awful with not much in it.", "Another dimly lit, dark, room that smells awful with not much in it.", false, nullKeyItems); 
        this.dungeon= new Location("Dungeon", "Inside this room you find a large vat in the center of the room.", "Inside this room you find the whole golf team with a bright green liquid being pumped from their vains to a large vat in the center. Above each of them is the numbers 2-8.", true, nullKeyItems); 
        this.libraryStairs= new Location("Library Stairs", "A creepy stairway that leads only one way. Down. Move down to the CELLAR STAIRS.","A creepy stairway that leads only one way. Down. Move down to the CELLAR STAIRS", false, nullKeyItems); 

        //establishing items phase one
        this.nullItem= new Item("null", "null", this.nullLocation, false ); 
        this.golfClub= new Weapon("Golf Club", "A shiny nine iron that once belonged to the golf team.", "You swing and hit you enemy with the golf club. It makes a great loud thwack.", this.gym, false, 5 ); 
        this.gym.addItem(this.golfClub);
        this.yellowSharpenedPencil= new BreakableWeapon("Yellow Sharpened Pencil", "An insanely sharp classic #2 pencil. This thing would be a beast on a standardized test.", "You jab your opponent with the sharpened pencil. It breaks skin.", this.homeRoom, false, 2, 2); 
        this.homeRoom.addItem(this.yellowSharpenedPencil); 
        this.acid= new Acid(this.chemLab, false); 
        this.chemLab.addItem(this.acid);
        this.pinkSharpenedPencil= new BreakableWeapon("Pink Sharpened Pencil", "An insanely sharp #2 pencil, now in a new fun pink color! This thing would be a beast on a standardized test in style.", "You jab your opponent with the pink sharpened pencil. It breaks skin and looks chic while doing it.", this.historyRoom, false, 2, 2); 
        this.historyRoom.addItem(this.pinkSharpenedPencil); 
        this.ruler= new BreakableWeapon("Ruler", "A wooden ruler with both inches and cenimeters depending on which side you use. How exciting!", "You slap your opponent with a ruler. It's not very effective but it does more than your hands.", this.mathRoom, false, 2, 4); 
        this.mathRoom.addItem(this.ruler);
        this.syringe= new BreakableWeapon("Syringe", "A large syringe with a very sharp tip.", "You stab your opponent with a syringe. It's very effective, but you feel the needle bend.", this.bioLab, false, 3, 2); 
        this.bioLab.addItem(this.syringe);
        this.scalpel= new Weapon("Scalpel", "A super sharp scalpel. Originally intended for dissections, but could be useful in some sticky situations.", "You slice your opponent with your scalpel. That one is gonna leave a nasty mark.", this.bioLab, false, 5); 
        this.bioLab.addItem(this.scalpel);
        this.knife= new Weapon("Knife", "A shiny black and silver kitchen knife.", "You stab your opponent with the knife. It makes and awful squishing noise. Gross.", this.cafe, false, 6 ); 
        this.cafe.addItem(this.knife);
        this.dictionary = new Weapon("Dictionary","You find the heaviest book in the classroom. It would definitely hurt to get hit with this thing.","You smack your opponent with the dictionary. It leaves a red mark.",this.englishRoom,false,2);
        
        //establishing NPCS
        this.englishRoom.addItem(this.dictionary);
        this.homeRoomStudent= new Student("Home Room Student","Your fellow classmate who is locked in on some homework.", this.homeRoom, 100, false); 
        this.homeRoom.addNPC(this.homeRoomStudent);
        this.englishRoomStudent= new Student("English Room Student", "Your classmate sits in the corner of the room. He is playing a video game on his phone.", this.englishRoom, 100, false); 
        this.englishRoom.addNPC(this.englishRoomStudent); 
        this.studyRoomStudent=new Student("Study Room Student", "A student is reading a book in the corner of the room. He seems quite focused but still approachable", this.studyRoom, 100, false); 
        this.studyRoom.addNPC(this.studyRoomStudent); 
        this.cafeRoomStudent= new Student("Cafe Student", "A freshman eating a sanwhich. You think it is peanut butter and jelly.", this.cafe, 100, false); 
        this.cafe.addNPC(this.cafeRoomStudent); 
        this.homeRoomTeacher= new Teacher("Home Room Teacher", "Your home room teacher who glows with a youthful exuberance.", this.homeRoom, 10); 
        this.homeRoom.addNPC(homeRoomTeacher); 
        this.nullNPC= new NPC("Null NPC", "n/a", this.nullLocation, 10, true); 
        this.hallMonitorOne= new HallMonitor("Hall Monitor One", "A menancing teacher that walks around the halls looking for mischevious students skipping class.", this.hallwayOne, 10);
        hallwayOne.addNPC(hallMonitorOne); 
        this.hallMonitorTwo= new HallMonitor("Hall Monitor Two", "A menancing teacher that walks around the halls looking for mischevious students skipping class.", this.hallwayTwelve,10); 
        hallwayTwelve.addNPC(hallMonitorTwo); 
        this.scienceTeacher= new ScienceTeacher("Science Teacher", "Your science teacher who has awesome skin but a horrible vibe!", this.dungeon, 40); 
        this.dungeon.addNPC(scienceTeacher); 

        //estblashing items phase two and three 
        this.homeRoomNote= new Note("Home Room Note", "I'm glad you found me. I hid it well so the teachers wouldn't find me. Something bad is happening in this school. I don't know exactly what it is, but I know the golf team members have been disappearing. I am going to try investigate. But if i'm not seen around again...find out what's happening in here and be careful!", this.homeRoom, false); 
        this.homeRoom.addItem(homeRoomNote); 
        this.cellarStairsNote= new Note("Cellar Stairs Note", "Oh no, I fear i may have lead you to far, but if your seeing this...it's to late to turn back now. I figured out what was going on... all the teachers, led by the science teacher, were kidnppaing the rebellious kids from school and draining their youth so they could appear more youthful themselves. Seems like there might be some larger message here about how society fears aging and the unrealistic beauty standrads we hold people too... but i dont have time for all of that right now. I can hear the science teacher down here with me... he's coming. I'm ill prepared it's too late for me. If your reading this maybe you can be the one to SAVE us DRAINED STUDENTS from this hell. Please help! ", this.cellarStairs,false); 
        this.cellarStairs.addItem(cellarStairsNote);
        this.historyRoomNote= new Note("History Room Note", "Glad to see you wandering the school looking for clues just like I am. Have you found any of the weapons yet? Gotta be prepared for the unknown.", this.historyRoom, false); 
        this.historyRoom.addItem(historyRoomNote);
        this.hallwayTwelveNote= new Note("Hallway Twelve Note", "The Library is just ahead. Be careful what you tell the librarian...we can't have the teachers catch on to our investigation...but i know she is involved somehow... I might try and snoop around her desk a little bit to try and find out.", this.hallwayTwelve, false); 
        this.hallwayTwelve.addItem(hallwayTwelveNote);
        this.tangled= new Item("Tangled", "A picture book of Disney's Tangled. It is very worn... it must be a favorite.", this.libraryRoomThree, false); 
        this.libraryRoomThree.addItem(this.tangled);
        this.historyOfTransylvania= new Item("History of Transylvania", "A thick chapter book that is the history of Transylvania. When you look at the check out history it has been checked out by teachers almost every day this past week. Strange.", this.libraryRoomSix, false); 
        this.libraryRoomSix.addItem(this.historyOfTransylvania);
        this.dracula= new Item("Dracula", "The classic original vampire book. There is a weird green substance coating some of the pages.", this.libraryRoomEight, false); 
        this.libraryRoomEight.addItem(this.dracula); 

        //establishing NPCS phase 3 and two
        this.drainedStudentOne= new DrainedStudent("Drained Student One", "A very tired looking student. They look older than normal. Very Wrinkly.", this.cellarRoomSix); 
        this.cellarRoomSix.addNPC(drainedStudentOne);
        this.drainedStudentTwo= new DrainedStudent("Drained Student Two", "A very tired looking student. They look older than normal. Very Wrinkly.", this.dungeon); 
        this.dungeon.addNPC(drainedStudentTwo);
        this.drainedStudentThree= new DrainedStudent("Drained Student Three", "A very tired looking student. They look older than normal. Very Wrinkly.", this.dungeon); 
        this.dungeon.addNPC(drainedStudentThree);
        this.drainedStudentFour= new DrainedStudent("Drained Student Four", "A very tired looking student. They look older than normal. Very Wrinkly.", this.dungeon); 
        this.dungeon.addNPC(drainedStudentFour);
        this.drainedStudentFive= new DrainedStudent("Drained Student Five", "A very tired looking student. They look older than normal. Very Wrinkly.", this.dungeon); 
        this.dungeon.addNPC(drainedStudentFive);
        this.drainedStudentSix= new DrainedStudent("Drained Student Six", "A very tired looking student. They look older than normal. Very Wrinkly.", this.dungeon);
        this.dungeon.addNPC(drainedStudentSix);
        this.drainedStudentSeven= new DrainedStudent("Drained Student Seven", "A very tired looking student. They look older than normal. Very Wrinkly.", this.dungeon);  
        this.dungeon.addNPC(drainedStudentSeven);
        this.drainedStudentEight= new DrainedStudent("Drained Student Eight", "A very tired looking student. They look older than normal. Very Wrinkly.", this.dungeon); 
        this.dungeon.addNPC(drainedStudentEight);
        this.drainedStudentNine= new DrainedStudent("Drained Student Nine", "A very tired looking student. They look older than normal. Very Wrinkly.", this.cellarRoomFive);    
        this.cellarRoomFive.addNPC(drainedStudentNine);
        this.librarian= new Librarian("Librarian", "a nasty short lady with small glasses and a evil grin. ", this.libraryRoomTwo, 20); 
        this.libraryRoomTwo.addNPC(librarian); 

        //setting key items to rooms
        Object[] bioLabKeyItems={this.scalpel, this.syringe}; 
        this.bioLab.setKeyItems(bioLabKeyItems);
        Object[]chemLabKeyItems={this.acid}; 
        this.chemLab.setKeyItems(chemLabKeyItems);
        Object[] cafeKeyItems={ this.cafeRoomStudent, this.knife}; 
        this.cafe.setKeyItems(cafeKeyItems);
        Object[] englishRoomKeyItems={this.englishRoomStudent, this.dictionary}; 
        this.englishRoom.setKeyItems(englishRoomKeyItems);
        Object[]gymKeyItems={this.golfClub}; 
        this.gym.setKeyItems(gymKeyItems);
        Object[]historyRoomKeyItems={this.pinkSharpenedPencil, this.historyRoomNote}; 
        this.historyRoom.setKeyItems(historyRoomKeyItems);
        Object[]mathRoomKeyItems= {this.ruler}; 
        this.mathRoom.setKeyItems(mathRoomKeyItems);
        Object[]studyRoomKeyItems={this.studyRoomStudent}; 
        this.studyRoom.setKeyItems(studyRoomKeyItems);
        Object[] homeRoomKeyItems={this.yellowSharpenedPencil, this.homeRoomStudent, this.homeRoomTeacher, this.homeRoomNote}; 
        this.homeRoom.setKeyItems(homeRoomKeyItems);
        Object[]hallwayTwelveKeyItems={this.hallwayTwelveNote}; 
        this.hallwayTwelve.setKeyItems(hallwayTwelveKeyItems);
        Object[]libraryOneKeyItems={}; 
        this.libraryRoomOne.setKeyItems(libraryOneKeyItems);
        Object[]libraryTwoKeyItems={}; 
        this.libraryRoomTwo.setKeyItems(libraryTwoKeyItems);
        Object[]libraryThreeKeyItems={this.tangled}; 
        this.libraryRoomThree.setKeyItems(libraryThreeKeyItems);
        Object[]libraryFourKeyItems={}; 
        this.libraryRoomFour.setKeyItems(libraryFourKeyItems);
        Object[]libraryFiveKeyItems={}; 
        this.libraryRoomFive.setKeyItems(libraryFiveKeyItems);
        Object[]librarySixKeyItems={this.historyOfTransylvania}; 
        this.libraryRoomSix.setKeyItems(librarySixKeyItems);
        Object[]librarySevenKeyItems={}; 
        this.libraryRoomSeven.setKeyItems(librarySevenKeyItems);
        Object[]libraryEightKeyItems={this.dracula}; 
        this.libraryRoomEight.setKeyItems(libraryEightKeyItems);
        Object[]libraryStairsKeyItems={}; 
        this.libraryStairs.setKeyItems(libraryStairsKeyItems);
        Object[]cellarStairsKeyItems={this.cellarStairsNote}; 
        this.cellarStairs.setKeyItems(cellarStairsKeyItems);
        Object[]cellarEmptyKeyItems={}; 
        this.cellarRoomOne.setKeyItems(cellarEmptyKeyItems);
        this.cellarRoomTwo.setKeyItems(cellarEmptyKeyItems);
        this.cellarRoomThree.setKeyItems(cellarEmptyKeyItems);
        this.cellarRoomFour.setKeyItems(cellarEmptyKeyItems);
        this.cellarRoomSeven.setKeyItems(cellarEmptyKeyItems); 
        Object[]cellarSixKeyItems={this.drainedStudentOne}; 
        this.cellarRoomSix.setKeyItems(cellarSixKeyItems);
        Object[]cellarFiveKeyItems={this.drainedStudentNine}; 
        this.cellarRoomFive.setKeyItems(cellarFiveKeyItems);
        Object[] dungeonKeyItems={this.drainedStudentTwo, this.drainedStudentThree, this.drainedStudentFour, this.drainedStudentFive, this.drainedStudentSix, this.drainedStudentEight}; 
        this.dungeon.setKeyItems(dungeonKeyItems);

       //final establishments
        this.player= new Person(this.homeRoom);   
        this.scanner = new Scanner(System.in);
    }

    public void help(){
        System.out.println("--------------------------------");
        System.out.println("-move: This command must be used with the name of an adjacent location. It moves your character to that location.");
        System.out.println("-inventory: This command displays your character's current inventory.");
        System.out.println("-look around: This command gives you a description of your character's current Location");
        System.out.println("-talk: This command must used with an NPC's name (exp. student, teacher, librarian) to speak to that NPC");
        System.out.println("-fight: This command must be used with a target NPC. If used alone you will fight the target with your fist. \n        If used with a weapon you will fight the target with your chosen weapon.");
        System.out.println("-look at: This command must be used in conjuction with an item. It gives you the description of that item."); 
        System.out.println("-grab: This command must be used in conjuction with an item. Adds the item to your players inventory.");
        System.out.println("-drop: This command must be used with an item currently in your inventory. This command will remove the item from your inventory.");
        if(this.phaseOneComplete){
            System.out.println("-search: This command allows you to search the room you are in for a specific book. To place these books on pedastals you must have all of them in your inventory and then move to LIBRARY STAIRS.");
        }
        if(this.phaseTwoComplete){
            System.out.println("-save: This command must be used with \"drained student\" + number to save the student. ");
        }
        System.out.println("If you cannot figure out the name for an NPC or an item try placing the room you are in, in front of the object (exp. home room note, home room student)");
        System.out.println("If you cannot figure out the name of a room try the type of room + \"room\" number (exp. library room one)");
        System.out.println("All numbers should be spelled out. For example, you should say \"move to hallway one\"instead of \"move to hallway 1\".");
        System.out.println("--------------------------------");
    }


    public List<String> getUserInput(Person p){
        //getting user input
        String userString= scanner.nextLine();  
        userString= userString.toLowerCase(); 
        userString= userString.trim(); 
        //lines 70-72 refrence 1
        String[] inputArray= userString.split(" "); 
        List<String> inputArrayList= Arrays.asList(inputArray); 
        return inputArrayList; 
    }

    public void runHelp(List<String> inputArrayList){
        this.help(); 
        return; 
    } 
    
    
    public Item checkGrabDropLookAtFight(List<String> inputArrayList){
        String [] itemStringList = {"golf club", "yellow sharpened pencil","pink sharpened pencil","acid","ruler","knife","scalpel","dictionary", "syringe", "home room note", "history room note", "hallway twelve note", "cellar stairs note"};
        Item [] itemList= {this.golfClub, this.yellowSharpenedPencil, this.pinkSharpenedPencil, this.acid, this.ruler, this.knife, this.scalpel, this.dictionary, this.syringe, this.homeRoomNote, this.historyRoomNote, this.hallwayTwelveNote, this.cellarStairsNote};   
        //iterating through itemStringList to check if there is an item in the command from user
        for(int i=0; i<itemStringList.length; i++){
            if (itemStringList[i].contains(" ")){ 
                //splitting multiple word item into array
                String[] multipleWordItem= itemStringList[i].split(" "); 
                String[]foundWords= new String[multipleWordItem.length]; 
                for (int wordIdx=0; wordIdx<multipleWordItem.length; wordIdx++){
                    if (inputArrayList.contains(multipleWordItem[wordIdx])){
                        foundWords[wordIdx]=multipleWordItem[wordIdx]; 
                    }
                } 
                boolean matchesAllWords=true; 
                for(int testI=0; testI<multipleWordItem.length; testI++){
                    if (foundWords[testI]!=multipleWordItem[testI]){
                        matchesAllWords=false; 
                        break;  
                    }
                }
                if(matchesAllWords){
                    //checking all parts of multiple word item are contained 
                    return itemList[i]; 
                }       
            }else{
                if(inputArrayList.contains(itemStringList[i])){
                    //if single word item is in list
                    return itemList[i]; 
                }
            }
        }
        return this.nullItem; 
    }

    public Location checkMovePhaseOne(List<String> inputArrayList){
        String [] locationStringList={"bio lab", "chem lab", "cafe", "english room", "gym", "history room", "math room", "study room", "home room", "hallway one", "hallway two", "hallway three", "hallway five", "hallway six", "hallway seven", "hallway eight", "hallway nine", "hallway ten", "hallway eleven", "hallway twelve", "library room one"}; 
        Location [] locationList= {this.bioLab, this.chemLab, this.cafe, this.englishRoom, this.gym, this.historyRoom, this.mathRoom, this.studyRoom, this.homeRoom, this.hallwayOne, this.hallwayTwo, this.hallwayThree, this.hallwayFive, this.hallwaySix, this.hallwaySeven, this.hallwayEight, this.hallwayNine, this.hallwayTen, this.hallwayEleven, this.hallwayTwelve, this.libraryRoomOne}; 
        for(int i=0; i<locationStringList.length; i++){
            if(locationStringList[i].contains(" ")){
                String[] multipleWordLocation= locationStringList[i].split(" "); 
                String[] foundWords= new String[multipleWordLocation.length]; 
                for(int wordIdx=0; wordIdx<multipleWordLocation.length; wordIdx++){
                    if(inputArrayList.contains(multipleWordLocation[wordIdx])){
                        foundWords[wordIdx]=multipleWordLocation[wordIdx]; 
                    }
                }
                boolean matchesAllWords=true; 
                for(int testI=0; testI<multipleWordLocation.length; testI++){
                    if(foundWords[testI]!=multipleWordLocation[testI]){
                        matchesAllWords=false; 
                        break; 
                    }
                }
                if(matchesAllWords){
                    return locationList[i]; 
                }
            }else{
                if(inputArrayList.contains(locationStringList[i])){
                    return locationList[i]; 
                }
            }

        }
        return this.nullLocation; 
    }

    public Location checkMovePhaseTwo(List<String> inputArrayList){
        String [] locationStringList={"library room one", "library room two", "library room three", "library room four", "library room five", "library room six", "library room seven", "library room eight", "library stairs", "cellar stairs" }; 
        Location [] locationList= {this.libraryRoomOne, this.libraryRoomTwo, this.libraryRoomThree, this.libraryRoomFour, this.libraryRoomFive, this.libraryRoomSix, this.libraryRoomSeven, this.libraryRoomEight, this.libraryStairs, this.cellarStairs}; 
        for(int i=0; i<locationStringList.length; i++){
            if(locationStringList[i].contains(" ")){
                String[] multipleWordLocation= locationStringList[i].split(" "); 
                String[] foundWords= new String[multipleWordLocation.length]; 
                for(int wordIdx=0; wordIdx<multipleWordLocation.length; wordIdx++){
                    if(inputArrayList.contains(multipleWordLocation[wordIdx])){
                        foundWords[wordIdx]=multipleWordLocation[wordIdx]; 
                    }
                }
                boolean matchesAllWords=true; 
                for(int testI=0; testI<multipleWordLocation.length; testI++){
                    if(foundWords[testI]!=multipleWordLocation[testI]){
                        matchesAllWords=false; 
                        break; 
                    }
                }
                if(matchesAllWords){
                    return locationList[i]; 
                }
            }else{
                if(inputArrayList.contains(locationStringList[i])){
                    return locationList[i]; 
                }
            }

        }
        return this.nullLocation; 
    }

    public Location checkMovePhaseThree(List<String> inputArrayList){
        String [] locationStringList={"cellar stairs", "cellar room one", "cellar room two", "cellar room three", "cellar room four", "cellar room five", "cellar room six", "cellar room seven", "dungeon"}; 
        Location [] locationList= {this.cellarStairs, this.cellarRoomOne, this.cellarRoomTwo, this.cellarRoomThree, this.cellarRoomFour, this.cellarRoomFive, this.cellarRoomSix, this.cellarRoomSeven, this.dungeon}; 
        for(int i=0; i<locationStringList.length; i++){
            if(locationStringList[i].contains(" ")){
                String[] multipleWordLocation= locationStringList[i].split(" "); 
                String[] foundWords= new String[multipleWordLocation.length]; 
                for(int wordIdx=0; wordIdx<multipleWordLocation.length; wordIdx++){
                    if(inputArrayList.contains(multipleWordLocation[wordIdx])){
                        foundWords[wordIdx]=multipleWordLocation[wordIdx]; 
                    }
                }
                boolean matchesAllWords=true; 
                for(int testI=0; testI<multipleWordLocation.length; testI++){
                    if(foundWords[testI]!=multipleWordLocation[testI]){
                        matchesAllWords=false; 
                        break; 
                    }
                }
                if(matchesAllWords){
                    return locationList[i]; 
                }
            }else{
                if(inputArrayList.contains(locationStringList[i])){
                    return locationList[i]; 
                }
            }

        }
        return this.nullLocation; 
    }

    

    

    //add NPC's after all established
    public NPC checkTalkFight(List<String> inputArrayList){
        String [] npcStringList={"home room student", "english room student", "study room student", "cafe student", "home room teacher", "librarian", "hall monitor two", "hall monitor one", "science teacher"}; 
        NPC [] npcList= {this.homeRoomStudent, this.englishRoomStudent, this.studyRoomStudent, this.cafeRoomStudent, this.homeRoomTeacher, this.librarian, this.hallMonitorTwo, this.hallMonitorOne, this.scienceTeacher}; 
        for(int i=0; i<npcStringList.length; i++){
            if(npcStringList[i].contains(" ")){
                String[] multipleWordNPC= npcStringList[i].split(" "); 
                String[] foundWords= new String[multipleWordNPC.length]; 
                for(int wordIdx=0; wordIdx<multipleWordNPC.length; wordIdx++){
                    if(inputArrayList.contains(multipleWordNPC[wordIdx])){
                        foundWords[wordIdx]=multipleWordNPC[wordIdx]; 
                    }
                }
                boolean matchesAllWords=true; 
                for(int testI=0; testI<multipleWordNPC.length; testI++){
                    if (foundWords[testI]!=multipleWordNPC[testI]){
                        matchesAllWords=false; 
                        break;  
                    }
                }
                if(matchesAllWords){
                    //checking all parts of multiple word item are contained 
                    return npcList[i]; 
                }       
            }else{
                if(inputArrayList.contains(npcStringList[i])){
                    //if single word item is in list
                    return npcList[i]; 
                }
            }
        }
        return this.nullNPC; 
    }

    public NPC checkSave(List<String> inputArrayList){
        String [] npcStringList={"drained student one", "drained student two", "drained student three", "drained student four", "drained student five", "drained student six", "drained student seven", "drained student eight", "drained student nine"}; 
        NPC [] npcList= {this.drainedStudentOne, this.drainedStudentTwo, this.drainedStudentThree, this.drainedStudentFour, this.drainedStudentFive, this.drainedStudentSix, this.drainedStudentSeven, this.drainedStudentEight, this.drainedStudentNine}; 
        for(int i=0; i<npcStringList.length; i++){
            if(npcStringList[i].contains(" ")){
                String[] multipleWordNPC= npcStringList[i].split(" "); 
                String[] foundWords= new String[multipleWordNPC.length]; 
                for(int wordIdx=0; wordIdx<multipleWordNPC.length; wordIdx++){
                    if(inputArrayList.contains(multipleWordNPC[wordIdx])){
                        foundWords[wordIdx]=multipleWordNPC[wordIdx]; 
                    }
                }
                boolean matchesAllWords=true; 
                for(int testI=0; testI<multipleWordNPC.length; testI++){
                    if (foundWords[testI]!=multipleWordNPC[testI]){
                        matchesAllWords=false; 
                        break;  
                    }
                }
                if(matchesAllWords){
                    //checking all parts of multiple word item are contained 
                    return npcList[i]; 
                }       
            }else{
                if(inputArrayList.contains(npcStringList[i])){
                    //if single word item is in list
                    return npcList[i]; 
                }
            }
        }
        return this.nullNPC; 
    }

    public void runSave(NPC npcOfInterest){
        if(npcOfInterest== this.nullNPC){
            System.out.println("You must include a drained student to save!");
            System.out.println("(Helpful hint: drained students are named \"drained student\" plus a number.");
        }else{
            try{
                player.save(npcOfInterest);  
            }catch(RuntimeException e){
                System.out.println(e.getLocalizedMessage());
            }
            
        } 
    }

    public void runTalk(NPC npcOfInterest, Person player){
        if(npcOfInterest== this.nullNPC){
            System.out.println("You must include a character to talk to!");
            System.out.println("(Helpful hint: characters are named for the room their in and what they are. Example: Home Room Student or Home Room Teacher.)");
        }else{
            player.talk(npcOfInterest); 
        }
    }


    public void runMove(Location locationOfInterest, Person player){
        if (locationOfInterest== this.nullLocation){
            System.out.println("You must include a location to move to!");
        }else{
            player.move(locationOfInterest, this.libraryStairs, this.tangled, this.historyOfTransylvania, this.dracula);
        }
    }
    
    public void runGrab(Item itemOfInterest, Person p){
        if( itemOfInterest== this.nullItem){
            System.out.println("You must include an item to grab!");
        }else{
            try{
                p.grab(itemOfInterest, this.nullLocation); 
            }catch(RuntimeException e){
                System.out.println(e.getLocalizedMessage());
            } 
        }
    } 

    public void runDrop(Item itemOfInterest, Person p){
        if( itemOfInterest==this.nullItem){
            System.out.println("You must include an item to drop");
        }else{
            try{
                p.drop(itemOfInterest); 
            }catch(RuntimeException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
    
    public void runInventory(Person player){
       this.player.checkInventory(); 

    }
    
    public void runLookAround(Person player){
        System.out.println(this.player.lookAround());
    }

    public void runLookAt(Item itemOfInterest, Person player){
        if( itemOfInterest==this.nullItem){
            System.out.println("You must include an item to look at!");
        }else{
            try{
                System.out.println(player.lookAt(itemOfInterest));
            }catch(RuntimeException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    public void runSearch(){
        try{
            this.player.search(this.tangled, this.historyOfTransylvania, this.dracula, this.nullLocation);
        }catch(RuntimeException e){
            System.out.println(e.getLocalizedMessage());
            
        }
        
    }
    
    public void runFight(NPC npcOfInterest,  Item itemOfInterest, Person player){
        if(npcOfInterest==this.nullNPC){
            System.out.println("You must include a character to fight!");
            System.out.println("(Helpful hint: characters are named for the room their in and what they are. Example: Home Room Student or Home Room Teacher.) Alternatively characters that move like hall monitors are named with numbers (Exp.Hall Monitor One).");
        }else if(itemOfInterest!=this.nullItem){
            try{
                player.fight(npcOfInterest, itemOfInterest);
            }catch( RuntimeException e ){
                System.out.println(e.getLocalizedMessage());
            }
             
        }else{
            try{
                player.fight(npcOfInterest); 
            }catch(RuntimeException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
   
    public void runUserInput(){
        List<String> inputArrayList= this.getUserInput(this.player); 
        System.out.println("");
        if(inputArrayList.contains("help")){
            this.runHelp(inputArrayList); 
            this.runUserInput(); 
        }else if(inputArrayList.contains("grab")){
            this.runGrab(this.checkGrabDropLookAtFight(inputArrayList), this.player);
        }else if(inputArrayList.contains("inventory")){
            this.runInventory(this.player); 
        }else if(inputArrayList.contains("move")){
            if(phaseOneComplete==true&& phaseTwoComplete==false){
                this.runMove(checkMovePhaseTwo(inputArrayList), this.player); 
            }else if(phaseTwoComplete){
                this.runMove(checkMovePhaseThree(inputArrayList), this.player); 
            }else{
                this.runMove(checkMovePhaseOne(inputArrayList), this.player); 
            }
        }else if(inputArrayList.contains("look")&& inputArrayList.contains("around")){
            this.runLookAround(this.player); 
        }else if(inputArrayList.contains("talk")){
            this.runTalk(this.checkTalkFight(inputArrayList), this.player); 
        }else if(inputArrayList.contains("drop")){
            this.runDrop(this.checkGrabDropLookAtFight(inputArrayList), this.player); 
        }else if(inputArrayList.contains("look")&& inputArrayList.contains("at")){
            this.runLookAt(this.checkGrabDropLookAtFight(inputArrayList), this.player); 
        }else if(inputArrayList.contains("fight")){
            this.runFight(this.checkTalkFight(inputArrayList), this.checkGrabDropLookAtFight(inputArrayList), this.player); 
        }else if(inputArrayList.contains("search")){
            if(phaseOneComplete){
                this.runSearch(); 
            }else{
                System.out.println("You cannot use the search command yet!");
            }
        }else if(inputArrayList.contains("save")){
            if(phaseTwoComplete){
                this.runSave(this.checkSave(inputArrayList)); 
            }else{
                System.out.println("You cannot use the save command yet!");
            }
        }else{
            System.out.println("That didn't really make sense. Try again. Type \"help\" for a list of commands!");
        }
    }

    public Location changeStringtoLocation(String stringLocation){
        stringLocation= stringLocation.toLowerCase(); 
        String[] fullLocationStringList= {"bio lab", "chem lab", "cafe", "english room", "gym", "history room", "math room", "study room", "home room", "hallway one", "hallway two", "hallway three", "hallway five", "hallway six", "hallway seven", "hallway eight", "hallway nine", "hallway ten", "hallway eleven", "hallway twelve", "library room one","library room two", "library room three", "library room four", "library room five", "library room six", "library room seven", "library room eight", "library stairs", "cellar stairs", "cellar room one", "cellar room two", "cellar room three", "cellar room four", "cellar room five", "cellar room six", "cellar room seven", "dungeon", "null location"};
        Location[] fullLocationList={this.bioLab, this.chemLab, this.cafe, this.englishRoom, this.gym, this.historyRoom, this.mathRoom, this.studyRoom, this.homeRoom, this.hallwayOne, this.hallwayTwo, this.hallwayThree, this.hallwayFive, this.hallwaySix, this.hallwaySeven, this.hallwayEight, this.hallwayNine, this.hallwayTen, this.hallwayEleven, this.hallwayTwelve, this.libraryRoomOne, this.libraryRoomTwo, this.libraryRoomThree, this.libraryRoomFour, this.libraryRoomFive, this.libraryRoomSix, this.libraryRoomSeven, this.libraryRoomEight, this.libraryStairs, this.cellarStairs,this.cellarRoomOne, this.cellarRoomTwo, this.cellarRoomThree, this.cellarRoomFour, this.cellarRoomFive, this.cellarRoomSix, this.cellarRoomSeven, this.dungeon, this.nullLocation};
        for (int i=0; i<fullLocationStringList.length; i++){
            if (fullLocationStringList[i].equals(stringLocation)){
                return fullLocationList[i];
            }
        }
        return this.nullLocation; 

    }

    //write check dead and respawn method

    public void runRoundOfPhaseOne(){
        if(this.player.getIsDead()==false){
            this.runUserInput();
            System.out.println("");
        }else{
            return;
        }
        if(this.hallMonitorOne.isAlive){
            this.hallMonitorOne.move(this.changeStringtoLocation(this.hallMonitorOne.nextMove()), this.player);
        }
        if(this.hallMonitorTwo.isAlive){
            this.hallMonitorTwo.move(this.changeStringtoLocation(this.hallMonitorTwo.nextMove()), this.player); 
        }

    }
    
    public void checkPhaseOneComplete(){
        if (this.player.getLocation()==this.libraryRoomOne){
            this.phaseOneComplete=true;  
        }
    }

    public void runRoundofPhaseThree(){
        System.out.println("");
        if(this.player.getIsDead()==false){
            this.runUserInput();
            System.out.println("");
        }else{
            return;
        }
        if(this.player.getIsDead()==false){
            this.runUserInput();
            System.out.println("");
        }else{
            return;
        }
        if(this.player.getIsDead()==false){
            this.runUserInput();
            System.out.println("");
        }else{
            return;
        }
        if(this.drainedStudentOne.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentOne.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentTwo.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentTwo.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentThree.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentThree.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentFour.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentFour.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentFive.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentFive.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentSix.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentSix.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentSeven.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentSeven.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentEight.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentEight.fight(this.scienceTeacher, this.player); 
        }
        if(this.drainedStudentNine.isSaved()&& this.scienceTeacher.isAlive()){
            this.drainedStudentNine.fight(this.scienceTeacher, this.player); 
        }
        if(this.scienceTeacher.isAlive()&& this.scienceTeacher.isAlive()){
            scienceTeacher.move(this.changeStringtoLocation(scienceTeacher.nextMove(this.player)), this.player);
            System.out.println(this.scienceTeacher.getLocation().getName());
        }
    }

    public void checkPhaseThreeComplete(){
        if (this.scienceTeacher.isAlive()==false){
            this.phaseThreeComplete=true;  
        }else{
            this.phaseThreeComplete=false;  
        }
    }

    

    public void runRoundOfPhaseTwo(){
        if(this.librarian.isAlive()){
            this.librarian.move(this.changeStringtoLocation(this.librarian.nextMove(this.player)), this.player);
            System.out.println(this.librarian.getLocation().getName()); 
        }
        if(this.player.getIsDead()==false){
            this.runUserInput();
            if (this.librarian.getLocation()==this.player.getLocation()) {
                this.librarian.fight(this.player);
            }
            System.out.println("");
        }else{
            return;
        }
        if(this.player.getIsDead()==false){
            if (this.librarian.getLocation()==this.player.getLocation()) {
                this.librarian.fight(this.player);
            }
            this.runUserInput();
            System.out.println("");
            if (this.librarian.getLocation()==this.player.getLocation()) {
                System.out.println("The librian disapears behind a book shelf. \n");
            }
        }else{
            return;
        }
    }

    public void checkPhaseTwoComplete(){
        if(this.player.getLocation()==this.libraryStairs){
            this.phaseTwoComplete=true; 
        }
    }



    
    public static void main(String[] args) { 
        
        //final code
        Main testingGame= new Main(); 
        System.out.println("");
        System.out.println("Welcome to our game created by Maggie McCaffrey and Kylie Cave! TW: This game contains loud sudden noises, and mild depictions of violence. You start as a student in your home room classroom! Have fun! (Type \"help\" if you can't figure out what to do!)");
        System.out.println(" ");
        System.out.println("Phase one begins... explore your school...find objects...talk to students...but be careful, your school doesn't like students lingering outside of class.(Helpful hint to leave you current classroom you will type move to HALLWAY THREE.)");
        System.out.println("");
        while(testingGame.phaseOneComplete==false){
            testingGame.runRoundOfPhaseOne(); 
            testingGame.checkPhaseOneComplete(); 
            if(testingGame.player.isDead()){
                break; 
            }
        }
        if(testingGame.player.getIsDead()){
            testingGame.scanner.close(); 
        }else{
            System.out.println("As you enter the library the door locks shut behind you. There is no going back.");
            System.out.println("");
            System.out.println("Phase One Complete. Welcome to phase two: The Library. Be careful and be quiet... the librarian moves fast and quiet and she may be lurking around every corner.");
            System.out.println("");
            while(testingGame.phaseTwoComplete==false){
                testingGame.runRoundOfPhaseTwo(); 
                testingGame.checkPhaseTwoComplete(); 
                if(testingGame.player.isDead()){
                    break; 
                }
            }if(testingGame.player.getIsDead()){
                testingGame.scanner.close();
            }else{
                System.out.println("Welcome to Phase Three... the cellar. You have no choice but to walk down the CELLAR STAIRS.");
                while(testingGame.phaseThreeComplete==false){
                    testingGame.runRoundofPhaseThree(); 
                    testingGame.checkPhaseThreeComplete(); 
                    if(testingGame.player.isDead()){
                        break; 
                    }
                }
                if(testingGame.player.getIsDead()){
                    testingGame.scanner.close();
                }else{
                    System.out.println("Congrats you have won! You got "+ testingGame.player.getPoints()+" points!");
                }
            }
        }
        
        

        //home room note not working
        //move to study room
        //english room dwki not working
        //check description in modified empty room fixed
        //teacher fight response printing before attack description
        //check syringe works
        //cafe description with dwki not working
        //librarian and science teacher have all text options not just theirs
        //librarian move like doesnt work
        //science teacher move like doesnt work





    }
}

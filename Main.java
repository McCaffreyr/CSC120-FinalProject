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
    //npcs
    Student homeRoomStudent;
    Student englishRoomStudent;
    Student studyRoomStudent;
    Student cafeRoomStudent;
    Teacher homeRoomTeacher; 
    NPC nullNPC;

    //player
    Person player;

    //scanner
    Scanner scanner; 


    Main(){ 
        this.phaseOneComplete= false; 
        this.phaseTwoComplete= false; 
        this.phaseThreeComplete= false; 
        this.map = new LocationMap();
        Object[] nullLocationKeyItems={}; 
        this.nullLocation= new Location("null Location", "n/a", "n/a", true, nullLocationKeyItems); 
        Object[] bioLabKeyItems={this.scalpel}; 
        this.bioLab = new Location("Bio Lab","The biology lab has many workstations set up for dissection. There are pins at each table and a tank of frogs in the back corner.",  "The biology lab has many workstations set up for dissection. There are pins at each table and a tank of frogs in the back corner. On the drying rack, there lies a bunch of scalpels ready for the upcoming dissection.", true, bioLabKeyItems);
        Object[]chemLabKeyItems={this.acid}; 
        this.chemLab = new Location("Chem Lab","The chem lab has shiny gray countertops. It looks like a class was just in here. The chem teacher has taught here forever, but he doesn’t look a day over 25. You’ve gotta learn his skin care routine. ", "The chem lab has shiny gray countertops. It looks like a class was just in here. The chem teacher has taught here forever, but he doesn’t look a day over 25. You’ve gotta learn his skin care routine. Small beakers sit on the drying rack next to the sink. In the corner is a beaker with a solution still inside...", true, chemLabKeyItems);
        Object[] cafeKeyItems={this.knife, this.cafeRoomStudent}; 
        this.cafe = new Location("Cafe","This is the school's cafeteria. Dozens of long tables sit in organized rows. Cooking utensils lie around: spoons, tongs, spatula...", "This is the school's cafeteria. Dozens of long tables sit in organized rows. A student lingers at the back of the cafeteria eating a sandwhich. Near the front of the room is a kitchen. Cooking utensils lie around: spoons, tongs, spatula, and a knife...", true, cafeKeyItems);
        Object[] englishRoomKeyItems={this.englishRoomStudent}; 
        this.englishRoom = new Location("English Room", "Your English teacher decorated her room based on her favorite gothic novel, Dracula. The whole room has a red and black theme and is always dimly lit.", "Your English teacher decorated her room based on her favorite gothic novel, Dracula. The whole room has a red and black theme and is always dimly lit. In the corner, you can just barely make out another student. Their phone light brightens up the underside of their face, giving them a flashlight under face campfire scary story effect.", true, englishRoomKeyItems);
        Object[]gymKeyItems={this.golfClub}; 
        this.gym = new Location("Gym", "The gym walls are covered in banners won by different students over the years. The golf team was known across the country, they had won nationals ten years in a row. However, the team this year was known to be pranksters and particularly rebellious. Come to think of it, you haven’t seen any of the team in a while… strange.", "The gym walls are covered in banners won by different students over the years. The golf team was known across the country, they had won nationals ten years in a row. However, the team this year was known to be pranksters and particularly rebellious. Come to think of it, you haven’t seen any of the team in a while… strange. However, one of their golf clubs is resting against the far gym wall.", true, gymKeyItems);
        Object[]historyRoomKeyItems={this.pinkSharpenedPencil}; 
        this.historyRoom = new Location("History Room", "The history room is pretty textbook high school classroom. On the walls, hung maps display all the different parts of the world. On the wall closest to you, there is a map of Europe with a pin marking the center of Romania.", "The history room is pretty textbook high school classroom. On the walls, hung maps display all the different parts of the world. On the wall closest to you, there is a map of Europe with a pin marking the center of Romania. In a desk in the far back corner, there is a leftover note and a sharpened pencil lying next to it.", true, historyRoomKeyItems);
        Object[]mathRoomKeyItems= {this.ruler}; 
        this.mathRoom = new Location("Math Room", "Your math teacher leaned hard into the dad puns on posters. She even has one that says, “Not all math jokes are bad, just sum”. It’s weird that she’s so lame, she seems so young… but she acts like she’s no younger than 55.", "Your math teacher leaned hard into the dad puns on posters. She even has one that says, “Not all math jokes are bad, just sum”. It’s weird that she’s so lame, she seems so young… but she acts like she’s no younger than 55. A ruler that was left out after geometry class sits on a near desk.", true, mathRoomKeyItems);
        Object[]studyRoomKeyItems={this.studyRoomStudent}; 
        this.studyRoom = new Location("Study Room","This was the study room dedicated to the seniors. The room has a few couches and some bean bags. The floor is littered with backpacks of seniors who gave up on using lockers two years ago.",  "This was the study room dedicated to the seniors. The room has a few couches and some bean bags. The floor is littered with backpacks of seniors who gave up on using lockers two years ago. One senior is chilling in the corner, reading a book.", true, studyRoomKeyItems);
        Object[] homeRoomKeyItems={this.yellowSharpenedPencil, this.homeRoomStudent, this.homeRoomStudent}; 
        this.homeRoom= new Location("Home Room","Your homeroom classroom is typically used as a physics classroom. There are posters around the room with bad physics puns, such as: I’m not lazy, I’m just overflowing with potential energy.", "Your homeroom classroom is typically used as a physics classroom. There are posters around the room with bad physics puns, such as:  I’m not lazy, I’m just overflowing with potential energy. On your desk, there is a sharpened pencil and a note left by a previous student. You are early, and only one other student is in class yet. Your teacher is sitting at their desk. They seem particularly happy today. They radiate a youthful exuberance.", true, homeRoomKeyItems); 
        Object[]hallwayOneKeyItems={};
        this.hallwayOne= new Location("Hallway One", "This hallway has a door to the study room to the left and the entrance to the gym to the right. Behind you is hallway two.", "This hallway has a door to the study room to the left and the entrance to the gym to the right. Behind you is hallway two.", false, hallwayOneKeyItems); 
        Object[]hallwayTwoKeyItems={}; 
        this.hallwayTwo= new Location("Hallway Two","There are no rooms directly connected to this hallway but up ahead of you in hallway one you can see some more rooms. Behind you in hallway three you can also see some more doors.", "There are no rooms directly connected to this hallway but up ahead of you in hallway one you can see some more rooms. Behind you in hallway three you can also see some more doors.", false, hallwayTwoKeyItems); 
        Object[]hallwayThreeKeyItems={}; 
        this.hallwayThree= new Location("Hallway Three", "In this hallway to your right there is the door to your homeroom. To your left there is the entrance to the school but it is always locked while school is in session. In front of you is hallway two and behind you is hallway five.", "In this hallway to your right there is the door to your homeroom. To your left there is the entrance to the school but it is always locked while school is in session. In front of you is hallway two and behind you is hallway five.", false,hallwayThreeKeyItems); 
        Object[]hallwayFiveKeyItems={}; 
        this.hallwayFive= new Location("Hallway Five", "There are no doors directly connected to this hallway but in ahead of you is hallway 3 where you can see some doors. Behind you is hallway six where you can make out some more doors.", "There are no doors directly connected to this hallway but in ahead of you is hallway 3 where you can see some doors. Behind you is hallway six where you can make out some more doors.", false,hallwayFiveKeyItems); 
        Object[]hallwaySixKeyItems={}; 
        this.hallwaySix= new Location("Hallway Six", "To your left is the entrance to the english room and behind you is the entrance to the history room. In front of you is hallway five and to your right is hallway seven.", "To your left is the entrance to the english room and behind you is the entrance to the history room. In front of you is hallway five and to your right is hallway seven.", false, hallwaySixKeyItems); 
        Object[]hallwaySevenKeyItems={}; 
        this.hallwaySeven= new Location("Hallway Seven","To your left is the entrance to the math room. Behind you is hallway six and in front of you is hallway eight.",  "To your left is the entrance to the math room. Behind you is hallway six and in front of you is hallway eight.", false, hallwaySevenKeyItems); 
        Object[]hallwayEightKeyItems={}; 
        this.hallwayEight= new Location("Hallway Eight","To your left is the chem lab and to your right is the bio lab. Behind you is hallway seven and in front of you is hallway nine.",  "To your left is the chem lab and to your right is the bio lab. Behind you is hallway seven and in front of you is hallway nine.", false, hallwayEightKeyItems); 
        Object[]hallwayNineKeyItems={}; 
        this.hallwayNine=  new Location("Hallway Nine", "To your left is one of the entrances to the cafe. In front of you is hallway ten and behind you is hallway eight.", "To your left is one of the entrances to the cafe. In front of you is hallway ten and behind you is hallway eight.", false, hallwayNineKeyItems); 
        Object[]hallwayTenKeyItems={}; 
        this.hallwayTen= new Location("Hallway Ten","To your left is another entrance to the cafe. Behind you is hallway nine and in front of you is hallway eleven.",  "To your left is another entrance to the cafe. Behind you is hallway nine and in front of you is hallway eleven.", false, hallwayTenKeyItems); 
        Object[]hallwayElevenKeyItems={}; 
        this.hallwayEleven= new Location("Hallway Eleven", "In front of you is hallway twelve and behind you is hallway eleven.", "In front of you is hallway twelve and behind you is hallway eleven.", false, hallwayElevenKeyItems); 
        Object[]hallwayTwelveKeyItems={}; 
        this.hallwayTwelve= new Location("Hallway Twelve", "In front of you is the entrance to the library and behind you is hallway eleven.", "In front of you is the entrance to the library and behind you is hallway eleven.", true, hallwayTwelveKeyItems); 
        this.nullItem= new Item("null", "null", this.nullLocation, false ); 
        this.golfClub= new Weapon("Golf Club", "a shiny nine iron that once belonged to the golf team.", "You swing and hit you enemy with the golf club. It makes a great loud thwack.", this.gym, false, 5 ); 
        this.gym.addItem(this.golfClub);
        this.yellowSharpenedPencil= new BreakableWeapon("Yellow Sharpened Pencil", "an insanely sharp classic #2 pencil. This thing would be a beast on a standardized test.", "You jab your opponent with the sharpened pencil. It breaks skin.", this.homeRoom, false, 2, 2); 
        this.homeRoom.addItem(this.yellowSharpenedPencil); 
        this.acid= new Acid(this.chemLab, false); 
        this.chemLab.addItem(this.acid);
        this.pinkSharpenedPencil= new BreakableWeapon("Pink Sharpened Pencil", "an insanely sharp #2 pencil, now in a new fun pink color! This thing would be a beast on a standardized test in style.", "You jab your opponent with the pink sharpened pencil. It breaks skin and looks chic while doing it.", this.historyRoom, false, 2, 2); 
        this.historyRoom.addItem(this.pinkSharpenedPencil); 
        this.ruler= new BreakableWeapon("Ruler", "a wooden ruler with both inches and cenimeters depending on which side you use. How exciting!", "You slap your opponent with a ruler. It's not very effective but it does more than your hands.", this.mathRoom, false, 2, 4); 
        this.mathRoom.addItem(this.ruler);
        this.syringe= new BreakableWeapon("Syringe", "a large syringe with a very sharp tip.", "You stab your opponent with a syringe. It's very effective, but you feel the needle bend.", this.mathRoom, false, 5, 2); 
        this.bioLab.addItem(this.syringe);
        this.scalpel= new Weapon("Scalpel", "a super sharp scalpel. Originally intended for dissections, but could be useful in some sticky situations.", "You slice your opponent with your scalpel. That one is gonna leave a nasty mark.", this.bioLab, false, 5); 
        this.bioLab.addItem(this.scalpel);
        this.knife= new Weapon("Knife", "a shiny black and silver kitchen knife.", "You stab your opponent with the knife. It makes and awful squishing noise. Gross.", this.cafe, false, 6 ); 
        this.cafe.addItem(this.knife);
        this.dictionary = new Weapon("Dictionary","you find the heaviest book in the classroom. It would definitely hurt to get hit with this thing.","You smack your opponent with the dictionary. It leaves a red mark.",this.englishRoom,false,2);
        this.englishRoom.addItem(this.dictionary);
        this.homeRoomStudent= new Student("Home Room Student","your fellow classmate who is locked in on some homework.", this.homeRoom, 100, false); 
        this.homeRoom.addNPC(this.homeRoomStudent);
        this.englishRoomStudent= new Student("English Room Student", "your classmate sits in the corner of the room. He is playing a video game on his phone.", this.englishRoom, 100, false); 
        this.englishRoom.addNPC(this.englishRoomStudent); 
        this.studyRoomStudent=new Student("Study Room Student", "a senior student is reading a book in the corner of the room. He seems quite focused but still approachable", this.studyRoom, 100, false); 
        this.studyRoom.addNPC(this.studyRoomStudent); 
        this.cafeRoomStudent= new Student("Cafe Room Student", "a freshman eating a sanwhich. You think it is peanut butter and jelly.", this.cafe, 100, false); 
        this.cafe.addNPC(this.cafeRoomStudent); 
        this.homeRoomTeacher= new Teacher("Home Room Teacher", "your home room teacher who glows with a youthful exuberance.", this.homeRoom, 10); 
        this.nullNPC= new NPC("Null NPC", "n/a", this.nullLocation, 10, true); 
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
            System.out.println("-search: This command must be used with the name of a specific bookshelf. It allows you to search that bookshelf for the missing book.");
        }
        if(this.phaseTwoComplete){
            System.out.println("-save: This command must be used with the number of the student to save. This command allows you to save the drained students.");
        }
        System.out.println("--------------------------------");
    }

    public void phaseOne(){
        System.out.println("Welcome to the game. Feel free to start uncovering the world whenever you are ready. If you are stuck, type 'help' at any point to pull up a list of possible commands. We recommend you wait to use this option unless after you give it a try.");
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
        String [] itemStringList = {"golf club", "yellow sharpened pencil","pink sharpened pencil","acid","ruler","knife","scalpel","dictionary" };
        Item [] itemList= {this.golfClub, this.yellowSharpenedPencil, this.pinkSharpenedPencil, this.acid, this.ruler, this.knife, this.scalpel, this.dictionary};   
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

    public Location checkMove(List<String> inputArrayList){
        String [] locationStringList={"bio lab", "chem lab", "cafe", "english room", "gym", "history room", "math room", "study room", "home room", "hallway one", "hallway two", "hallway three", "hallway five", "hallway six", "hallway seven", "hallway eight", "hallway nine", "hallway ten", "hallway eleven", "hallway twelve"}; 
        Location [] locationList= {this.bioLab, this.chemLab, this.cafe, this.englishRoom, this.gym, this.historyRoom, this.mathRoom, this.studyRoom, this.homeRoom, this.hallwayOne, this.hallwayTwo, this.hallwayThree, this.hallwayFive, this.hallwaySix, this.hallwaySeven, this.hallwayEight, this.hallwayNine, this.hallwayTen, this.hallwayEleven, this.hallwayTwelve}; 
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
        String [] npcStringList={"home room student", "english room student", "study room student", "cafe room student", "home room teacher" }; 
        NPC [] npcList= {this.homeRoomStudent, this.englishRoomStudent, this.studyRoomStudent, this.cafeRoomStudent, this.homeRoomTeacher}; 
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

    public void runTalk(NPC npcOfInterest, Person player){
        if(npcOfInterest== this.nullNPC){
            System.out.println("You must include a character to talk to! (Helpful hint: characters are named for the room their in and what they are. Example: Home Room Student or Home Room Teacher.)");
            System.out.println("(Helpful hint: characters are named for the room their in and what they are. Example: Home Room Student or Home Room Teacher.)");
        }else{
            player.talk(npcOfInterest); 
        }
    }


    public void runMove(Location locationOfInterest, Person player){
        if (locationOfInterest== this.nullLocation){
            System.out.println("You must include a location to move to!");
        }else{
            player.move(locationOfInterest);
        }
    }
    
    public void runGrab(Item itemOfInterest, Person p){
        if( itemOfInterest== this.nullItem){
            System.out.println("You must include an item to grab!");
        }else{
            try{
                p.grab(itemOfInterest, nullLocation); 
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
    
    public void runFight(NPC npcOfInterest,  Item itemOfInterest, Person player){
        if(npcOfInterest==this.nullNPC){
            System.out.println("You must include a character to fight!");
            System.out.println("(Helpful hint: characters are named for the room their in and what they are. Example: Home Room Student or Home Room Teacher.)");
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
        if(inputArrayList.contains("help")){
            this.runHelp(inputArrayList); 
        }else if(inputArrayList.contains("grab")){
            this.runGrab(this.checkGrabDropLookAtFight(inputArrayList), this.player);
        }else if(inputArrayList.contains("inventory")){
            this.runInventory(this.player); 
        }else if(inputArrayList.contains("move")){
            this.runMove(this.checkMove(inputArrayList), this.player); 
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
        }else{
            System.out.println("That didn't really make sense. Try again. Type \"help\" for a list of commands!");
        }
    }

    public void runRoundOfPhaseOne(){
        this.runUserInput(); 

    }


    
    public static void main(String[] args) { 
        System.out.println("Welcome to our game created by Maggie McAffrey and Kylie Cave! You start as a student in your home room classroom! Have fun! (Type \"help\" if you can't figure out what to do!)");
        Main testingGame= new Main(); 
        testingGame.runUserInput();
        testingGame.runUserInput();
        testingGame.runUserInput();
        
    }
}

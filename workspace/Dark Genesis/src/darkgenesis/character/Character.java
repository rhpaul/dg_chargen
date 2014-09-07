package darkgenesis.character;

import java.util.Random;
import java.util.Vector;

import darkgenesis.data.Background;
import darkgenesis.data.Gear;
import darkgenesis.data.HomeWorld;
import darkgenesis.data.Item;
import darkgenesis.data.Role;
import darkgenesis.data.Skill;
import darkgenesis.data.Talent;
import darkgenesis.excelio.Determinable;
import darkgenesis.io.ConsoleIn;

public class Character {
    private String name;
    private HomeWorld homeWorld;
    private Background background;
    private Role role;
    
    private Vector<Talent> bonusses;
    private Vector<Aptitude> aptitudes;
    
    private Vector<Characteristic> characteristics;
    
    private Vector<Talent> talents;
    private Vector<Skill> skills;
    private Vector<Gear> equipment;
    
    private Characteristic fate;
    private Characteristic wounds;
    
    private Characteristic insanity;
    private Characteristic corruption;
    
    public Character(){
	this.bonusses = new Vector<Talent>();
	this.aptitudes = new Vector<Aptitude>();
	this.characteristics = new Vector<Characteristic>();
	this.equipment = new Vector<Gear>();
	this.talents = new Vector<Talent>();
	this.skills = new Vector<Skill>();
	this.characteristics.add(new Characteristic("Weapon Skill", 20));
	this.characteristics.add(new Characteristic("Ballistic Skill", 20));
	this.characteristics.add(new Characteristic("Strength", 20));
	this.characteristics.add(new Characteristic("Toughness", 20));
	this.characteristics.add(new Characteristic("Agility", 20));
	this.characteristics.add(new Characteristic("Intelligence", 20));
	this.characteristics.add(new Characteristic("Perception", 20));
	this.characteristics.add(new Characteristic("Willpower", 20));
	this.characteristics.add(new Characteristic("Fellowship", 20));
	this.characteristics.add(new Characteristic("Influence", 20));
	this.fate = new Characteristic("Fate", 0);
	this.wounds = new Characteristic("Wounds", 0);
	this.insanity = new Characteristic("Insanity", 0);
	this.corruption = new Characteristic("Corruption", 0);
    }
    
    /*HOMEWORLD RELATED*/
    public void rollCharacteristics() {
	this.bonusses.add(this.homeWorld.getHomeWorldBonus());
	this.aptitudes.add(this.homeWorld.getHomeWorldAptitude());
	String str = ConsoleIn.readFromConsole("Do you wish to enter the character's values yourself?\n"
		    			+"(y)es, (n)o\n") ;
	while(!str.equals("y") && !str.equals("n")){
	    System.out.println("Sorry, your input was incorrect.");
	}
	if(str.equals("y")){
	    manualInput();
	}
	else{
	    randomInput();
	}
    }    
    
    private void randomInput() {
	Random random = new Random();
	for(int i = 0; i < this.characteristics.size(); i++){
	    System.out.println("Rolling for " +  this.characteristics.elementAt(i).getName());
	    int d1 = random.nextInt(10)+1;
	    int d2 = random.nextInt(10)+1;
	    int d3 = 0;
	    System.out.println("Roll 1:" + d1);
	    System.out.println("Roll 2:" + d2);
	    int sum = 0;
	    if((this.characteristics.elementAt(i).equals(this.homeWorld.getPosModifier1())
		    || (this.characteristics.elementAt(i).equals(this.homeWorld.getPosModifier2())))){
		d3 = random.nextInt(10)+1;  
		System.out.println("Home world positive modifier: \n Roll 3:" + d3);
		if(d1 <= d2 && d1 <= d3){
		    System.out.println("Discarding roll 1.");		    
		    d1 = 0;
		} else if (d2 <= d1 && d2 <= d3){
		    System.out.println("Discarding roll 2.");	
		    d2 = 0;
		} else{
		    System.out.println("Discarding roll 3.");	
		    d3 = 0;
		}
	    }
	    if((this.characteristics.elementAt(i).equals(this.homeWorld.getNegModifier()))){
		d3 = random.nextInt(10)+1;  
		System.out.println("Home world negative modifier: \n Roll 3:" + d3);
		if(d1 >= d2 && d1 >= d3){
		    System.out.println("Discarding roll 1.");		    
		    d1 = 0;
		} else if (d2 >= d1 && d2 >= d3){
		    System.out.println("Discarding roll 2.");	
		    d2 = 0;
		} else{
		    System.out.println("Discarding roll 3.");	
		    d3 = 0;
		}
	    }
	    sum = d1 + d2 + d3;   
	    this.characteristics.elementAt(i).setValue( 20+sum);
	    System.out.println("Value for " +  this.characteristics.elementAt(i).getName() + ":"
		    		+ this.characteristics.elementAt(i).getValue() + "\n");	    
	}
	System.out.println("Rolling for " +  this.wounds.getName() + "\n");
	int d1 = random.nextInt(5)+1;
	System.out.println("Roll :" + d1);
	this.wounds.setValue(d1 + this.homeWorld.getWounds().getValue());
	System.out.println("Rolling for " +  this.fate.getName() + "\n");
	int d2 = random.nextInt(10)+1;
	System.out.println("Roll :" + d2 + "(Blessing on "+ this.homeWorld.getFateIncrease() +")");
	int sum = 0;
	if(d2 <= this.homeWorld.getFateIncrease()){
	    System.out.println("Succes! Increasing fate.");
	    sum = this.homeWorld.getFatePoints().getValue() +1;
	}else{
	    sum = this.homeWorld.getFatePoints().getValue();
	}
	this.fate.setValue(sum);
    }
    
    private void manualInput() {
	String str;
	Vector<Characteristic> misc = new Vector<Characteristic>();
	misc.add(this.fate);
	misc.add(this.wounds);
	for(int i = 0; i < this.characteristics.size(); i++){
	    do{
        	    while(!ConsoleIn.checkInput(
        		    (str = ConsoleIn.readFromConsole(
        			    "Enter value for " +  this.characteristics.elementAt(i).getName())))){
        		System.out.println("Please make a valid input.");
        	    }
	    }while(Integer.parseInt(str)>100);
	    this.characteristics.elementAt(i).setValue(Integer.parseInt(str));
	    System.out.println("Value for " +  this.characteristics.elementAt(i).getName() + ":"
	    		+ this.characteristics.elementAt(i).getValue() + "\n");	
	}
	//FATE, WOUNDS
	for(int i = 0; i < misc.size(); i++){	    
    	    while(!ConsoleIn.checkInput(
    		    (str = ConsoleIn.readFromConsole(
    			    "Enter value for " +  misc.elementAt(i).getName())))){
    		System.out.println("Please make a valid input.");
    	    }	    
	    misc.elementAt(i).setValue(Integer.parseInt(str));
	    System.out.println("Value for " + misc.elementAt(i).getName() + ":"
	    		+ misc.elementAt(i).getValue() + "\n");	
	}
    }
    
    /*BACKGROUND&ROLE RELATED*/
    public void processBackground() {
	this.bonusses.add(this.background.getBackgroundBonus());
	System.out.println("Setting Aptitudes...");
	Vector<String> vec = new Vector<String>();
	vec.add(this.background.getAptitude());
	this.aptitudes.addAll(detectOr(vec, 3));	
	System.out.println("Setting skills...");
	this.skills.addAll(detectOr(this.background.getSkills(), 0));
	System.out.println("Setting talents...");
	this.talents.addAll(detectOr(this.background.getTalents(), 1));
	System.out.println("Setting equipment...");
	this.equipment.addAll(detectOr(this.background.getEquipment(), 2));
    }

    public void processRole() {
	this.bonusses.add(this.role.getBonus());
	System.out.println("Setting Aptitudes...");
	this.aptitudes.addAll(detectOr(this.role.getAptitudes(), 3));	
	System.out.println("Setting talents...");
	Vector<String> vec = new Vector<String>();
	vec.add(this.role.getTalents());
	this.talents.addAll(detectOr(vec, 1));
    }
    /*Auxiliary Methods*/
    private Vector detectOr(Vector<String> vector, int type) {
	//0 = skill, 1 = talent, 2 = eq, 3= aptitude
	Vector vecOut;
	if(type == 0){
	    vecOut = new Vector<Skill>();
	}else if(type == 1){
	    vecOut = new Vector<Talent>();	    
	}else if(type == 3){
	    vecOut = new Vector<Aptitude>();	    
	}else{
	    vecOut = new Vector<Gear>();	    	    
	}
	for(int i = 0; i < vector.size(); i++){
	    if(vector.elementAt(i).contains(" or ")){
		vector.setElementAt(decide(vector.elementAt(i)),i);
	    }
	    if(type == 0){
		vecOut.add(new Skill(vector.elementAt(i), "TODO"));
	    }else if(type == 1){
		vecOut.add(new Talent(vector.elementAt(i), "TODO"));    
	    }else if(type == 3){
		vecOut.add(new Aptitude(vector.elementAt(i)));    
	    }else{
		vecOut.add(new Item(vector.elementAt(i), "TODO"));    
	    }	    
	}
	return vecOut;
    }

    private String decide(String str) {
	String[] strArr = str.split(" or ");
	String str2 = "Please choose one of the following:\n";
	for(int i = 0 ; i < strArr.length; i++){
	    str2 += "" + (i+1) + " - " + strArr[i] + "\n";
	}
	str2 += "\n" + "info - further information\n";
	String input;
	do{
	    input = ConsoleIn.readFromConsole(str2);
	    if(input.equals("info")){
		/*TODO*/System.out.println("Function under development.");
	    }
	}while((!ConsoleIn.checkInput(input) 
		|| (Integer.parseInt(input)> strArr.length)));
	System.out.println("You have chosen " + strArr[Integer.parseInt(input)-1] + "\n");
	return strArr[Integer.parseInt(input)-1];
    }

    public String toString(){
	String str = "";
	str += "Name: " + this.name + "\n";
	str += "Home World: " + this.homeWorld.getName() + "\n";
	str += "Background: " + this.background.getName() + "\n";
	str += "Role: " + this.role.getName() + "\n";
	str += "\n";
	str += "Bonusses: \n";
	for(int i = 0; i < this.bonusses.size(); i++){
	    str += this.bonusses.elementAt(i).toString() + "\n";
	}
	str += "\n";
	str += "Aptitudes: \n";	
	for(int i = 0; i < this.aptitudes.size(); i+= 2){
	    str += "\t" + this.aptitudes.elementAt(i).toString();
	    if((i+1 < this.aptitudes.size()) && (this.aptitudes.elementAt(i+1) != null)){
		str += "\t" + this.aptitudes.elementAt(i+1).toString() + "\n";
	    }
	}
	str += "\n";
	str += "Characteristics: \n";
	for(int i = 0; i < this.characteristics.size(); i+= 2){
	    str += "\t" + this.characteristics.elementAt(i).toString();
	    if(this.characteristics.elementAt(i+1) != null){
		str += "\t" + this.characteristics.elementAt(i+1).toString() + "\n";
	    }
	}	
	str += "\n";
	str += this.fate.toString()+"\n";
	str += this.wounds.toString()+"\n";
	str += this.insanity.toString()+"\n";
	str += this.corruption.toString()+"\n";
	str += "\n";
	str += "Skills: \n";
	for(int i = 0; i <this.skills.size(); i++){
		str += "\t" + this.skills.elementAt(i).getName() + "\n";
	}
	str += "\n";
	str += "Talents: \n";
	for(int i = 0; i <this.talents.size(); i++){
		str += "\t" + this.talents.elementAt(i).getName() + "\n";
	}	
	str += "\n";
	str += "Equipment: \n";
	for(int i = 0; i <this.equipment.size(); i++){
		str += "\t" + this.equipment.elementAt(i).getName() + "\n";
	}	
	return str;
    }
    
    /*SETTER GETTER*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HomeWorld getHomeWorld() {
        return homeWorld;
    }
    public void setHomeWorld(HomeWorld homeworld) {
        this.homeWorld = homeworld;
    }
    public Background getBackground() {
        return background;
    }
    public void setBackground(Background background) {
        this.background = background;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Vector<Talent> getBonusses() {
        return bonusses;
    }
    public void setBonusses(Vector<Talent> bonusses) {
        this.bonusses = bonusses;
    }
    public Vector<Aptitude> getAptitudes() {
        return aptitudes;
    }
    public void setAptitudes(Vector<Aptitude> aptitudes) {
        this.aptitudes = aptitudes;
    }
    
    public Vector<Characteristic> getCharacteristics() {
        return characteristics;
    }
    public void setCharacteristics(Vector<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }
    public Characteristic getFate() {
        return fate;
    }
    public void setFate(Characteristic fate) {
        this.fate = fate;
    }
    public Characteristic getWounds() {
        return wounds;
    }
    public void setWounds(Characteristic wounds) {
        this.wounds = wounds;
    }
    public Characteristic getInsanity() {
        return insanity;
    }
    public void setInsanity(Characteristic insanity) {
        this.insanity = insanity;
    }
    public Characteristic getCorruption() {
        return corruption;
    }
    public void setCorruption(Characteristic corruption) {
        this.corruption = corruption;
    }


    

    
}

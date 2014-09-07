package darkgenesis.data;

import java.util.Vector;

import darkgenesis.character.Aptitude;

public class Background implements Presentable{
    private String name;
    private Vector<String> skills;
    private Vector<String> talents;
    private Vector<String> equipment;
    private Talent backgroundBonus;
    private String aptitude;
    
//    public Background(String name, Vector<String> skills, Vector<String> talents, Talent backgroundBonus, String aptitude){
//	this.name = name;
//	this.skills = skills;
//	this.talents = talents;
//	this.backgroundBonus = backgroundBonus;
//	this.aptitude = aptitude;
//    }

    public Background() {
	this.name = "";
	this.skills = new Vector<String>();
	this.talents = new Vector<String>();
	this.equipment = new Vector<String>();
	this.backgroundBonus = null;
	this.aptitude = null;
    }

    public String toString(){
	String str = this.name + ":\n";
	for(int i = 0; i < this.skills.size(); i++){
	    if(i == 0){
		str += "Skills:\t\t" + this.skills.elementAt(i) + "\n";
	    }
	    else{
		str += "\t\t" + this.skills.elementAt(i) + "\n";
	    }	
	}
	for(int i = 0; i < this.talents.size(); i++){
	    if(i == 0){
		str += "Talents:\t" + this.talents.elementAt(i) + "\n";
	    }
	    else{
		str += "\t\t" + this.talents.elementAt(i) + "\n";
	    }	
	}
	for(int i = 0; i < this.equipment.size(); i++){
	    if(i == 0){
		str += "Equipment:\t" + this.equipment.elementAt(i) + "\n";
	    }
	    else{
		str += "\t\t" + this.equipment.elementAt(i) + "\n";
	    }	
	}
	str += "Background Bonus: " + this.backgroundBonus.toString() + "\n";
	str += "Background Aptitude: " + this.aptitude + "\n";
	return str;
    }
    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<String> getSkills() {
        return skills;
    }

    public void setSkills(Vector<String> skills) {
	for(int i = 0; i < skills.size(); i++){
	    this.skills.add(skills.elementAt(i));
	}
    }

    public Vector<String> getTalents() {
        return talents;
    }

    public void setTalents(Vector<String> talents) {
	for(int i = 0; i < talents.size(); i++){
	    this.talents.add(talents.elementAt(i));
	}
    }

    public Talent getBackgroundBonus() {
        return backgroundBonus;
    }

    public void setBackgroundBonus(Talent backgroundBonus) {
        this.backgroundBonus = backgroundBonus;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String strlist) {
        this.aptitude = strlist;
    }

    public Vector<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(Vector<String> equipment) {
	for(int i = 0; i < equipment.size(); i++){
	    this.equipment.add(equipment.elementAt(i));
	}
    }
    
    
}

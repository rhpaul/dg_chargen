package darkgenesis.data;

import java.util.Vector;

import darkgenesis.character.Aptitude;
import darkgenesis.character.Characteristic;

public class HomeWorld implements Presentable{
    private String name;
    private Characteristic posModifier1;
    private Characteristic posModifier2;
    private Characteristic negModifier;
    private Characteristic fatePoints;
    private int fateIncrease;
    private Talent homeWorldBonus;
    private Aptitude homeWorldAptitude;
    private Characteristic wounds;
    
    //public static Vector<HomeWorld> worldList;
    
    public HomeWorld(String name, Characteristic posModifier1, Characteristic posModifier2, Characteristic negModifier,
	    Characteristic fatePoints, int fateIncrease, Talent homeWorldBonus, Aptitude homeWorldAptitude, Characteristic wounds){
	     this.name = name;
	     this.posModifier1 = posModifier1;
	     this.posModifier2 = posModifier2;
	     this.negModifier = negModifier;
	     this.fatePoints = fatePoints;
	     this.fateIncrease = fateIncrease;
	     this.homeWorldBonus = homeWorldBonus;
	     this.homeWorldAptitude = homeWorldAptitude;
	     this.wounds = wounds;
	     //worldList.add(this);
    }
    
    public String toString(){
	String str = this.name + ":\n"
		+ "Positive modificators:\t" + this.posModifier1.getName() + "\n"
		+ "\t\t\t" + this.posModifier2.getName() + "\n"
		+ "Negative modifcator:\t" + this.negModifier.getName() + "\n"
		+ fatePoints.toString() + " (blessing on " + fateIncrease + "+)" + "\n"
		+ "Homeworld Bonus: " + this.homeWorldBonus.toString() + "\n"
		+ "Homeworld Aptitude: " + this.homeWorldAptitude.toString() + "\n"
		+ this.wounds.toString() + "+d5\n";
	return str;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Characteristic getPosModifier1() {
        return posModifier1;
    }

    public void setPosModifier1(Characteristic posModifier1) {
        this.posModifier1 = posModifier1;
    }

    public Characteristic getPosModifier2() {
        return posModifier2;
    }

    public void setPosModifier2(Characteristic posModifier2) {
        this.posModifier2 = posModifier2;
    }

    public Characteristic getNegModifier() {
        return negModifier;
    }

    public void setNegModifier(Characteristic negModifier) {
        this.negModifier = negModifier;
    }

    public Characteristic getFatePoints() {
        return fatePoints;
    }

    public void setFatePoints(Characteristic fatePoints) {
        this.fatePoints = fatePoints;
    }

    public int getFateIncrease() {
        return fateIncrease;
    }

    public void setFateIncrease(int fateIncrease) {
        this.fateIncrease = fateIncrease;
    }

    public Talent getHomeWorldBonus() {
        return homeWorldBonus;
    }

    public void setHomeWorldBonus(Talent homeWorldBonus) {
        this.homeWorldBonus = homeWorldBonus;
    }

    public Aptitude getHomeWorldAptitude() {
        return homeWorldAptitude;
    }

    public void setHomeWorldAptitude(Aptitude homeWorldAptitude) {
        this.homeWorldAptitude = homeWorldAptitude;
    }

    public Characteristic getWounds() {
        return wounds;
    }

    public void setWounds(Characteristic wounds) {
        this.wounds = wounds;
    }
    
    
}

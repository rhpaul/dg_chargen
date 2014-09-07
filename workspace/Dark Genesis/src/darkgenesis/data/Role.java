package darkgenesis.data;

import java.util.Vector;

public class Role implements Presentable{
    private String name;
    private Vector<String> aptitudes;
    private String talents;
    private Talent bonus; 
    
    public Role(){
	this.name = "";
	this.aptitudes = new Vector<String>();
	this.talents = "";
	this.bonus = null;
    }

    public String toString(){
	String str = this.name + ":\n";
	for(int i = 0; i < this.aptitudes.size(); i++){
	    if(i == 0){
		str += "Role Aptitudes:\t" + this.aptitudes.elementAt(i) + "\n";
	    }
	    else{
		str += "\t\t" + this.aptitudes.elementAt(i) + "\n";
	    }	
	}
	str += "Role talent: \t" + this.talents + "\n";
	str += "Role bonus: \t" + this.bonus.toString() + "\n";
	return str;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<String> getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(Vector<String> aptitudes) {
	for(int i = 0; i < aptitudes.size(); i++){
	    this.aptitudes.add(aptitudes.elementAt(i));
	}
    }

    public String getTalents() {
        return talents;
    }

    public void setTalents(String talents) {
	this.talents = talents;
    }

    public Talent getBonus() {
        return bonus;
    }

    public void setBonus(Talent bonus) {
        this.bonus = bonus;
    }
    
    
}

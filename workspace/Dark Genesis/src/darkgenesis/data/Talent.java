package darkgenesis.data;

import darkgenesis.character.Aptitude;
import darkgenesis.excelio.Determinable;

public class Talent implements Determinable{
    private String name;
    private String descr;
    private Aptitude aptitude1;
    private Aptitude aptitude2;
    
    public Talent(String name, String descr){
	this.name = name;
	this.descr = descr;
    }
    
    public String toString(){
	String str = this.name + ":\n" + this.descr;
	return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Aptitude getAptitude1() {
        return aptitude1;
    }

    public void setAptitude1(Aptitude aptitude1) {
        this.aptitude1 = aptitude1;
    }

    public Aptitude getAptitude2() {
        return aptitude2;
    }

    public void setAptitude2(Aptitude aptitude2) {
        this.aptitude2 = aptitude2;
    }
    
    
}

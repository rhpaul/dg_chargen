package darkgenesis.data;

import darkgenesis.excelio.Determinable;

public abstract class Gear implements Determinable{
    private String name;
    private String descr;
    
    public Gear(String name, String descr){
	this.name = name;
	this.descr = descr;
    }
}

package darkgenesis.character;

import darkgenesis.excelio.Determinable;

public class Aptitude implements Determinable{
    private String name;
    
    public Aptitude(String name){
	this.name = name;
    }
    
    public boolean equals(Aptitude a){
	if(this.name.equals(a.name)){
	    return true;
	}
	return false;
    }
    
    public String toString(){
	return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

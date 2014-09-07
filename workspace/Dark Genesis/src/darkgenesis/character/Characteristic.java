package darkgenesis.character;

public class Characteristic {
    private String name;
    private int value;
    
    public Characteristic(String name, int value){
	this.name = name;
	this.value = value;
    }
    
    public boolean equals(Characteristic c){
	if(this.name.equals(c.name)){
	    return true;
	}
	return false;
    }
    
    public String toString(){
	String str = this.name + ":\t" + this.value;
	return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}

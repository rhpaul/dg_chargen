package darkgenesis.excelio;

public class DataType implements java.io.Serializable {
    public static final int HOMEWORLD   = 0;
    public static final int BACKGROUND  = 1;
    public static final int ROLE  	= 2;
    public static final int SKILLS  	= 3;
    private int value;
    
    public DataType(int value){
	this.value = value;
    }
    
    public boolean isHomeWorld() { 
        return value == HOMEWORLD;
    }
    
    public boolean isBackground() { 
        return value == BACKGROUND;
    }
    
    public boolean isRole() { 
        return value == ROLE;
    }
    
    public boolean isSkills() { 
        return value == SKILLS;
    }
}

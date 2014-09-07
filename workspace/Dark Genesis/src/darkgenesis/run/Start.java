package darkgenesis.run;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import darkgenesis.character.Generator;
import darkgenesis.excelio.InputData;
import darkgenesis.io.ConsoleIn;

public class Start {
    private InputData data;
    
    public Start()throws IOException{
	this.data = new InputData();
    }
    
    public static void main(String[] argv){
	System.out.println("Loading Data...");
	Path currentRelativePath = Paths.get("");
	String s = currentRelativePath.toAbsolutePath().toString();
	System.out.println("Current relative path is: " + s);
	Start start = null;
	try {
	    start = new Start();
	} catch (IOException e) {
	    System.out.println("An error occured while loading data...");
	    e.printStackTrace();
	}
	System.out.println("Data successfully loaded...");
	int i = menu();	    
	if(i == 1){
	    System.out.println("Loading character creation..."); 
	    Generator chargen = new Generator(start);
	    chargen.run();
	}
    }

    private static int menu() {
	String input;
	int i = 0;
	do{
        	do{
        	    input = ConsoleIn.readFromConsole("Welcome, what do you want to do? \n"
        		    				+ "1 - Create a new Character");
        	}while(!ConsoleIn.checkInput(input));
        	i = Integer.parseInt(input);
	}while(i >= 2);
	return i;
    }



    public InputData getData() {
        return data;
    }

    public void setData(InputData data) {
        this.data = data;
    }
    
    
}

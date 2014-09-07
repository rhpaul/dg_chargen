package darkgenesis.character;

import java.util.Vector;

import darkgenesis.run.Start;
import darkgenesis.data.HomeWorld;
import darkgenesis.data.Presentable;
import darkgenesis.io.ConsoleIn;

public class Generator {
    private Character character;
    private Start data;
    
    public Generator(Start data){
	this.data = data;
	this.character = new Character();
    }
    
    public void run(){
	chooseWorld();
	chooseBackground();
	chooseRole();
	do{
		chooseName();
        }while(ConsoleIn.readFromConsole("Is the name " + this.character.getName() + " okay?\n"
    		+"(y)es, (n)o\n").equals("n"));
	System.out.println(character.toString());
    }
    
    private void chooseName() {
	this.character.setName(ConsoleIn.readFromConsole("Enter the character's name"));
    }

    private void chooseRole() {
	String str = "Please choose the character's role \n";
	for(int i = 0; i < data.getData().getRoles().size(); i++){
	    str += "" + (i+1) + " - " + data.getData().getRoles().elementAt(i).getName() + "\n";
	}
	str += "\ninfo - further information";
	String input;
	do{
	    input = ConsoleIn.readFromConsole(str);
	    if(input.equals("info")){
		info(data.getData().getRoles());
	    }
	}while((!ConsoleIn.checkInput(input) 
		|| (Integer.parseInt(input)> data.getData().getRoles().size())));
	System.out.println("You have chosen " + data.getData().getRoles().elementAt((Integer.parseInt(input)-1)).getName() + "\n");
	this.character.setRole(data.getData().getRoles().elementAt(Integer.parseInt(input)-1));
	character.processRole();
    }

    private void chooseWorld(){
	String str = "Please choose the character's home world \n";
	for(int i = 0; i < data.getData().getHomeWorlds().size(); i++){
	    str += "" + (i+1) + " - " + data.getData().getHomeWorlds().elementAt(i).getName() + "\n";
	}
	str += "\ninfo - further information";
	String input;
	do{
	    input = ConsoleIn.readFromConsole(str);
	    if(input.equals("info")){
		info(data.getData().getHomeWorlds());
	    }
	}while((!ConsoleIn.checkInput(input) 
		|| (Integer.parseInt(input)> data.getData().getHomeWorlds().size())));
	System.out.println("You have chosen " + data.getData().getHomeWorlds().elementAt((Integer.parseInt(input)-1)).getName() + "\n");
	this.character.setHomeWorld(data.getData().getHomeWorlds().elementAt(Integer.parseInt(input)-1));
	
	do{
	    this.character.rollCharacteristics();
	}while(ConsoleIn.readFromConsole("Are these values okay?\n"
		+"(y)es, (n)o\n").equals("n"));
    }
    
    private void chooseBackground(){
	String str = "Please choose the character's background \n";
	for(int i = 0; i < data.getData().getBackgrounds().size(); i++){
	    str += "" + (i+1) + " - " + data.getData().getBackgrounds().elementAt(i).getName() + "\n";
	}
	str += "\ninfo - further information";
	String input;
	do{
	    input = ConsoleIn.readFromConsole(str);
	    if(input.equals("info")){
		info(data.getData().getBackgrounds());
	    }
	}while((!ConsoleIn.checkInput(input) 
		|| (Integer.parseInt(input)> data.getData().getBackgrounds().size())));
	System.out.println("You have chosen " + data.getData().getBackgrounds().elementAt((Integer.parseInt(input)-1)).getName() + "\n");
	this.character.setBackground(data.getData().getBackgrounds().elementAt(Integer.parseInt(input)-1));
	character.processBackground();
    }

    private void info(Vector content) {
	String str = "About which topic do you need more detailed information? \n";
	for(int i = 0; i < content.size(); i++){
	    str += "" + (i+1) + " - " + ((Presentable) content.elementAt(i)).getName() + "\n";
	}
	String input;
	do{
	    input = ConsoleIn.readFromConsole(str);
	}while((ConsoleIn.checkInput(input) 
		&& (Integer.parseInt(input)> content.size())));
	System.out.println(content.elementAt(Integer.parseInt(input)-1).toString());
    }
}

package darkgenesis.excelio;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import darkgenesis.character.Aptitude;
import darkgenesis.character.Characteristic;
import darkgenesis.data.Background;
import darkgenesis.data.HomeWorld;
import darkgenesis.data.Role;
import darkgenesis.data.Talent;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class InputData {
    private Vector<HomeWorld> homeWorlds;
    private Vector<Background> backgrounds;
    private Vector<Role> roles;
    private String inputFile;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  public void read(DataType datatype) throws IOException  {
    File inputWorkbook = new File(inputFile);
    Workbook w;
    try {
      w = Workbook.getWorkbook(inputWorkbook);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines

      String[] strlist = new String[sheet.getRows()]; 
      
      for (int j = 0; j < sheet.getColumns(); j++) {
        for (int i = 0; i < sheet.getRows(); i++) {
          Cell cell = sheet.getCell(j, i);
           strlist[i] = cell.getContents();
        }
        if(datatype.isHomeWorld() && (!strlist[0].equals(""))){
            buildHomeWorld(strlist);
        }
        if(datatype.isBackground() && (!strlist[0].equals(""))){
            buildBackground(strlist);
        }
        if(datatype.isRole() && (!strlist[0].equals(""))){
            buildRole(strlist);
        }
      }
    } catch (BiffException e) {
      e.printStackTrace();
    }
  }

  private void buildRole(String[] strlist) {
      Role role = new Role();
      Vector<String> collector = new Vector<String>();
      role.setName(strlist[0]);
      for(int i = 2; i < strlist.length; i++){
	  if(strlist[i].equals("#TALENT")){
	      role.setAptitudes(collector);
	      collector.clear();
	      i++;
	      role.setTalents(strlist[i]);
	  } else if(strlist[i].equals("#BONUS")){
	      role.setBonus(new Talent(strlist[i+1], strlist[i+2]));
	      break;
	  } else {
	      collector.add(strlist[i]);
	  }
      }
      roles.add(role);
      //System.out.println(role);
}

private void buildBackground(String[] strlist) {
      Background bg = new Background();
      Vector<String> collector = new Vector<String>();
      bg.setName(strlist[0]);
      for(int i = 2; i < strlist.length; i++){
	  if(strlist[i].equals("#TALENTS")){
	      bg.setSkills(collector);
	      collector.clear();
	  } else if(strlist[i].equals("#EQUIPMENT")){
	      bg.setTalents(collector);
	      collector.clear();	      
	  } else if(strlist[i].equals("#BONUS")){
	      bg.setEquipment(collector);
	      collector.clear();
	      bg.setBackgroundBonus(new Talent(strlist[i+1], strlist[i+2]));
	      bg.setAptitude(strlist[i+4]);
	      break;
	  } else {
	      collector.add(strlist[i]);
	  }
      }
      backgrounds.add(bg);
//      System.out.println(bg.toString());
    
}

private void buildHomeWorld(String[] strlist) {
     HomeWorld hw = new HomeWorld(
	      strlist[0],
	      new Characteristic(strlist[1],0),
	      new Characteristic(strlist[2],0),
	      new Characteristic(strlist[3],0),
	      new Characteristic("Fate",Integer.parseInt(strlist[4])),
	      Integer.parseInt(strlist[5]),
	      new Talent(strlist[6], strlist[7]),
	      new Aptitude(strlist[8]),
	      new Characteristic("Wounds",Integer.parseInt(strlist[9]))
	      );
     homeWorlds.add(hw);
  }

public InputData() throws IOException {
    homeWorlds = new Vector<HomeWorld>();
    backgrounds = new Vector<Background>();
    roles = new Vector<Role>();
    this.setInputFile("./data/Origin.xls");
    this.read(new DataType(0));
    this.setInputFile("./data/Background.xls");
    this.read(new DataType(1));
    this.setInputFile("./data/Roles.xls");
    this.read(new DataType(2));

  }

    public Vector<HomeWorld> getHomeWorlds() {
        return homeWorlds;
    }
    
    public void setHomeWorlds(Vector<HomeWorld> homeWorlds) {
        this.homeWorlds = homeWorlds;
    }
    
    public Vector<Background> getBackgrounds() {
        return backgrounds;
    }
    
    public void setBackgrounds(Vector<Background> backgrounds) {
        this.backgrounds = backgrounds;
    }
    
    public Vector<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(Vector<Role> roles) {
        this.roles = roles;
    }

} 

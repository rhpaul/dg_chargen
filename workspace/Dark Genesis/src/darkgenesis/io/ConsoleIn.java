package darkgenesis.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIn {
    public static String readFromConsole(String msg)
	{
		String string = null;
		while (string == null)
		{
			System.out.println(msg);
			BufferedReader console = new BufferedReader(new InputStreamReader(
					System.in));
			try
			{
				string = console.readLine().replace("\n", "").replace("\r", "");

			} catch (IOException e)
			{
				if (string == null)
				{
					System.out.println("Please enter a command.");
				}
			}
		}
		return string;
	}


    public static boolean checkInput(String input) {
    	if(input.matches("[-+]?\\d*\\.?\\d+")){
    	    if(Integer.parseInt(input) > 0){
                return true;
    	    }
    	}
    	return false;
    }
}
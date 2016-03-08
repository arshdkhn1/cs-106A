import acm.util.*;
import java.io.*;
import java.util.*;
/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	public NameSurferDataBase(String filename) {
		
		BufferedReader rd=null;
		
		try{
			rd=new BufferedReader(new FileReader(filename));
			
			String line="";
			while(true){
				
				line=rd.readLine();
				
				if(line==null){
					break;
				}
					
				
				else{
					
					StringTokenizer forName=new StringTokenizer(line);
					
					
					data.put(forName.nextToken().toUpperCase(), line);
					
				}
				
				
			}
			
			
		
		
		}//ends try
		
		catch(IOException ex){
			
			throw new ErrorException(ex);
			
			
		}//ends catch
	}
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		
		name=name.toUpperCase();
		
		String entry=data.get(name);
		
		if(entry==null)
		return new NameSurferEntry(null);
		
		else
			return new NameSurferEntry(entry);
	}

	private HashMap<String,String> data= new HashMap<String,String>();


}



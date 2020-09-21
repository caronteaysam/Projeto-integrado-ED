package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cadastro {
	
	public String name;
	public String password;
	
	public Cadastro ( String name, String password ) {
		
		this.name = name;
		this.password = password;
	}
	
	public static Cadastro fromFile ( String path ) {
		
		try {
		
			File file = new File ( path );
		
			BufferedReader br = new BufferedReader ( new FileReader ( file ));
			String name = br.readLine ( );
			String password = br.readLine ( );
			br.close ( );
			
			return new Cadastro ( name, password );
		} catch ( IOException e ) { e.printStackTrace ( ); }
		return null;
	}
	
	public void createFile ( String path ) {
		
		try {
			
			File dir = new File ( path );
			if ( !dir.exists ( )) dir.mkdirs ( );
			
			PrintWriter pw = new PrintWriter ( path + "/" + this.name + ".txt" );
			pw.println ( this.name );
			pw.println ( this.password );
			pw.flush ( );
			pw.close ( );
		} catch ( FileNotFoundException e ) { e.printStackTrace ( ); }
	}
}
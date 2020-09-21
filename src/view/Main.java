package view;

import java.io.File;

import controller.Cadastro;

public class Main {

	public static void main ( String[] args ) {
		
		String path = "database/cadastrados";
		File dir = new File ( path );
		
		if ( !dir.exists ( )) System.out.println( dir.mkdirs ( ));
		
		Cadastro c1 = new Cadastro ( "Diogo", "senha123" );
		c1.createFile ( path );
		
		Cadastro c2 = Cadastro.fromFile ( path + "/Diogo.txt" );
		System.out.println ( c2.name );
	}
}

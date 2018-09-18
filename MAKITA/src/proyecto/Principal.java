package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		  Principal p = new Principal();
          p.correr();

	}
	
	   private void correr() throws ClassNotFoundException, SQLException
       {
	
	        OperacionesSQL mSQL = new OperacionesSQL( "localhost","makita", "root","1234");
           mSQL.AbrirConexionBD();

           LeerConsola leerConsola= new LeerConsola();
           MostrarOpciones();

           int opcion = leerConsola.LeerEnteros("\tIngrese su opcion: ", 1, 13);

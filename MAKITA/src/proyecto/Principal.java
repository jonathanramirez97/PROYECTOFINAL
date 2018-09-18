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

           switch(opcion)
           {
               case 1:
                   try{
                       TipoMueble tipoMueble = new TipoMueble();
                       tipoMueble.mostrar();
                   }
                   catch(Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;
               case 2:
                    try
                   {
                       Mueble mueble= new Mueble();
                        mueble.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;
               case 3:
                     try
                   {
                       Proveedor proveedor= new Proveedor();
                         proveedor.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;

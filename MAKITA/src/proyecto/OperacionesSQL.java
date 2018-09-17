package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesSQL {
	private Connection conexion;
	  private String NombreBD;
	  private String NombreUS;
	  private String Password;
    private String host;
	  private  int PORT = 3306;
      
	public OperacionesSQL(String host, String NombreBd,String NombreUS, String Password) throws ClassNotFoundException
	{
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");  
		} 
		catch (ClassNotFoundException Exception) {
			System.out.println("Error de gestor de base datos");
			throw (Exception);
		}

		this.host = host;
		this.NombreBD = NombreBd;
		this.NombreUS=NombreUS;
		this.Password=Password;
		
	}

	public void AbrirConexionBD() throws SQLException
	{
		
		String url = "jdbc:mariadb://" +  host + ":" + PORT + "/" + NombreBD;
		System.out.println ("direccion de conexion: " + url);

		try 
		{
			conexion = DriverManager.getConnection(url, NombreUS, Password);
		}
		catch (SQLException Exception)
		{
			System.out.println("Estado: " + Exception.getSQLState());
			if (Exception.getSQLState().equals("08S01"))
				System.out.println("\nNo se puede establecer la conexion con el Servidor.");

			throw(Exception);
		}
		
	}

	public void cerrar() throws SQLException
	{
		
		conexion.close();
		
	}
      public ResultSet selectSQL(String ConsultaSQL) throws SQLException
	{
		this.AbrirConexionBD();
		
		Statement s = null;
		ResultSet rs = null;

		
		try
		{
			s = conexion.createStatement();
		} 
		catch (SQLException Exception) 
		{
			
			throw(Exception);
		}

		
		try 
		{
			System.out.println("QUERY: " + ConsultaSQL);
			rs = s.executeQuery(ConsultaSQL);
		} 
		catch (SQLException Exception) 
		{
			
			throw(Exception);
		}

		this.cerrar();
		
		return rs;
		
	}
	public void InsertarNuevo(String Consulta) throws SQLException
	{
		
		this.AbrirConexionBD();
		
		Statement s = null;

		
		try 
		{
			s = conexion.createStatement();
		} 
		catch (SQLException Exception) 
		{
			throw(Exception);
		}

		
		try 
		{				
			System.out.println ("QUERY: " + Consulta);
			s.executeUpdate(Consulta);
		}
		catch (SQLException Exception) 
		{
			throw(Exception);
		}
		this.cerrar();
	}
	public void ActualizarRegistro(String ConsultaSQL) throws SQLException
	{
		
		InsertarNuevo(ConsultaSQL);
		
	}

	public void BorrarRegistro(String ConsultaSQL) throws SQLException
	{
		
		InsertarNuevo(ConsultaSQL);
		
	}

}

package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Empleado {
	 private int IdEmpleado;
     private String Nombre;
     private String Apellido;
     private String Direccion;
     private String Celular;
     private LeerConsola leerConsola;

	public Empleado()
	{
		IdEmpleado=0;
     Nombre="";
     Apellido="";
     Direccion="";
     Celular="";
     leerConsola= new LeerConsola();
	}

	public Empleado(int IdEmpleado, String Nombre, String Apellido, String Direccion , String Celular )
 {
     this.IdEmpleado=IdEmpleado;
     this.Nombre=Nombre;
     this.Apellido=Apellido;
     this.Direccion=Direccion;
     this.Celular=Celular;
 }

	public Empleado(int codigo, OperacionesSQL operacionesSQL) throws SQLException
	{
		leerConsola = new LeerConsola();

		

		String query = "SELECT *  ";
		query +=       "FROM   Empleados ";
		query +=       "WHERE  IdEmpleado = " + codigo;

		ResultSet rs = operacionesSQL.selectSQL(query);

		if (rs.next())
		{
			this.IdEmpleado = rs.getInt(1);
			this.Nombre = rs.getString(2);
			this.Apellido = rs.getString(3);
			this.Direccion = rs.getString(4);
         this.Celular=rs.getString(5);
			
		}
		else
		{
			this.IdEmpleado = 0;
			this.Nombre="";
         this.Apellido="";
         this.Direccion="";
         this.Celular="";
		}

		operacionesSQL.cerrar();

	}

	public void mostrar()
	{
		if (this.IdEmpleado != 0)
		{
			System.out.println ("Empleados:");
			System.out.println ("\tIdEmpleado: " + this.IdEmpleado);
			System.out.println ("\tNombre: " + this.Nombre);
			System.out.println ("\tApellido: " + this.Apellido);
			System.out.println ("\tDireccion: " + this.Direccion);
         System.out.println ("\tCelular: " + this.Celular);
		}
	}

	public void leerDatos()
	{
		System.out.println ("Ingrese los datos de un Empleado:");

		
		this.Nombre =leerConsola .LeerCadena("\tNombre: ", leerConsola.NoNulo);
		this.Apellido = leerConsola .LeerCadena("\tApellido: ", leerConsola.NoNulo);
		this.Direccion = leerConsola .LeerCadena("\tDireccion: ", leerConsola.NoNulo);
     this.Celular = leerConsola .LeerCadena("\tCelular: ", leerConsola.NoNulo);
	}

	
	public void setNombre(String Nombre)
	{
		this.Nombre = Nombre;
	}
 
 public void setApellido(String Apellido)
 {
     this.Apellido=Apellido;
 }
 
 public void setDireccion(String Direccion)
 {
     this.Direccion=Direccion;
 }

 public void setCelular(String Celular)
 {
     this.Celular=Celular;
 }

	public int getIdEmpleado()
	{
		return this.IdEmpleado;
	}
	public String getNombre()
	{
	    return this.Nombre;
	}

 public String getApellido()
 {
     return this.Apellido;
 }

 public String getDireccion()
 {
     return this.Direccion;
 }

 public String getCelular()
 {
     return this.Celular;
 }

	public void insertar(OperacionesSQL miSQL) throws SQLException
	{

		

		String query = "INSERT INTO Empleados ";
		query +=       "SET    Nombre = '" + this.getNombre() + "', ";
		query +=       "       Apellido = '" + this.getApellido() + "', ";
		query +=       "       Direccion = '" + this.getDireccion() + "', ";
     query +=       "       Celular = '" + this.getCelular()+ "' ";

		miSQL.InsertarNuevo(query);

	}

}

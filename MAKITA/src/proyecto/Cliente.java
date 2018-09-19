package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
	private int IdCliente;
    private String Nombre;
    private String Apellido;
    private String Celular;
    private LeerConsola leerConsola;

public Cliente()
{
	IdCliente=0;
    Nombre="";
    Apellido="";
    Celular="";
    leerConsola= new LeerConsola();
}

public Cliente(int IdCliente, String Nombre, String Apellido, String Celular  )
{
    this.IdCliente=IdCliente;
    this.Nombre=Nombre;
    this.Apellido=Apellido;
    this.Celular=Celular;
}

public Cliente( OperacionesSQL operacionesSQL) throws SQLException
{
	leerConsola = new LeerConsola();

	

	String query = "SELECT *  ";
	query +=       "FROM   Clientes ";

	ResultSet rs = operacionesSQL.selectSQL(query);

     
	try
	{
	while (rs.next())
	{
		this.IdCliente = rs.getInt(1);
		this.Nombre = rs.getString(2);
		this.Apellido = rs.getString(3);
		this.Celular = rs.getString(4);
		mostrar();
	}
	}
	catch(Exception e)
	{
		this.IdCliente = 0;
		this.Nombre="";
        this.Apellido="";
        this.Celular="";
	}

	operacionesSQL.cerrar();

}

public void mostrar()
{
	if (this.IdCliente != 0)
	{
		System.out.println ("Cliente:");
		System.out.println ("\tIdCliente: " + this.IdCliente);
		System.out.println ("\tNombre: " + this.Nombre);
		System.out.println ("\tApellido: " + this.Apellido);
		System.out.println ("\tCelular: " + this.Celular);
	}
}

public void leerDatos()
{
	System.out.println ("Ingrese los datos de un Cliente:");

	
	this.Nombre =leerConsola .LeerCadena("\tNombre: ", leerConsola.NoNulo);
	this.Apellido = leerConsola .LeerCadena("\tApellido: ", leerConsola.NoNulo);
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

public void setCelular(String Celular)
{
    this.Celular=Celular;
}

public int getIdCliente()
{
	return this.IdCliente;
}
public String getNombre()
{
    return this.Nombre;
}
public String getApellido()
{
    return this.Apellido;
}

public String getCelular()
{
    return this.Celular;
}

public void insertar(OperacionesSQL miSQL) throws SQLException
{

	
	String query = "INSERT INTO Clientes ";
	query +=       "SET    Nombre = '" + this.getNombre() + "', ";
	query +=       "       Apellido = '" + this.getApellido() + "', ";
	query +=       "       Celular = '" + this.getCelular() + "' ";

	miSQL.InsertarNuevo(query);

	

}

}

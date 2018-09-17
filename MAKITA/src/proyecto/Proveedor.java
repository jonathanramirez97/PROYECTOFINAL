package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Proveedor {
	private int IdProveedor;
    private String Nombre;
    private String Telefono;
    private String Direccion;
    private LeerConsola leerConsola;

public Proveedor()
{
	IdProveedor=0;
    Nombre="";
    Telefono="";
    Direccion="";
    leerConsola= new LeerConsola();
}

public Proveedor(int IdProveedor, String Nombre, String Telefono, String Direccion  )
{
    this.IdProveedor=IdProveedor;
    this.Nombre=Nombre;
    this.Telefono=Telefono;
    this.Direccion=Direccion;
}

public Proveedor(int codigo, OperacionesSQL operacionesSQL) throws SQLException
{
	leerConsola = new LeerConsola();

	//miSQL.abrir();

	String query = "SELECT *  ";
	query +=       "FROM   Proveedores ";
	query +=       "WHERE  IdProveedor = " + codigo;

	ResultSet rs = operacionesSQL.selectSQL(query);

	if (rs.next())
	{
		this.IdProveedor = rs.getInt(1);
		this.Nombre = rs.getString(2);
		this.Telefono = rs.getString(3);
		this.Direccion = rs.getString(4);
		
	}
	else
	{
		this.IdProveedor = 0;
		this.Nombre="";
        this.Telefono="";
        this.Direccion="";
	}

	operacionesSQL.cerrar();

}

public void mostrar()
{
	if (this.IdProveedor != 0)
	{
		System.out.println ("Proveedores:");
		System.out.println ("\tIdProveedor: " + this.IdProveedor);
		System.out.println ("\tNombre: " + this.Nombre);
		System.out.println ("\tTelefono: " + this.Telefono);
		System.out.println ("\tDireccion: " + this.Direccion);
	}
}

public void leerDatos()
{
	System.out.println ("Ingrese los datos de un Proveedor:");

	

	this.Nombre =leerConsola .LeerCadena("\tNombre: ", leerConsola.NoNulo);
	this.Telefono = leerConsola .LeerCadena("\tTelefono: ", leerConsola.NoNulo);
	this.Direccion = leerConsola .LeerCadena("\tDireccion: ", leerConsola.NoNulo);
}


public void setNombre(String Nombre)
{
	this.Nombre = Nombre;
}

public void setTelefono(String Telefono)
{
    this.Telefono=Telefono;
}

public void setDireccion(String Direccion)
{
    this.Direccion=Direccion;
}

public int getIdProveedor()
{
	return this.IdProveedor;
}
public String getNombre()
{
    return this.Nombre;
}
public String getTelefono()
{
    return this.Telefono;
}

public String getDireccion()
{
    return this.Direccion;
}

public void insertar(OperacionesSQL miSQL) throws SQLException
{

	//miSQL.abrir();

	String query = "INSERT INTO Proveedores ";
	query +=       "SET    Nombre = '" + this.getNombre() + "', ";
	query +=       "       Telefono = '" + this.getTelefono() + "', ";
	query +=       "       Direccion = '" + this.getDireccion() + "' ";

	miSQL.InsertarNuevo(query);

	//miSQL.cerrar();

}

}

package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Compra {
	
	private int IdCompra;
    private String Fecha;
    private int MontoTotal ;
    private int IdProveedor ;
    private int IdEmpleado ;
    private LeerConsola leerConsola;

public Compra()
{
	IdCompra=0;
    Fecha="";
    MontoTotal =0;
    IdProveedor =0;
    IdEmpleado =0;
    leerConsola= new LeerConsola();
}

public Compra(int IdCompra, String Fecha, int MontoTotal , int IdProveedor  , int IdEmpleado  )
{
    this.IdCompra=IdCompra;
    this.Fecha=Fecha;
    this.MontoTotal =MontoTotal ;
    this.IdProveedor =IdProveedor ;
    this.IdEmpleado =IdEmpleado ;
}

public Compra( OperacionesSQL operacionesSQL) throws SQLException
{
	leerConsola = new LeerConsola();

	//miSQL.abrir();

	String query = "SELECT *  ";
	query +=       "FROM   Compras ";

	ResultSet rs = operacionesSQL.selectSQL(query);

	try
	{
	while (rs.next())
	{
		this.IdCompra = rs.getInt(1);
		this.Fecha = rs.getString(2);
		this.MontoTotal  = rs.getInt(3);
		this.IdProveedor  = rs.getInt(4);
        this.IdEmpleado =rs.getInt(5);
		mostrar();
	}
	}
	catch(Exception e)
	{
		this.IdCompra = 0;
		this.Fecha="";
        this.MontoTotal =0;
        this.IdProveedor =0;
        this.IdEmpleado =0;
	}

	operacionesSQL.cerrar();

}

public void mostrar()
{
	if (this.IdCompra != 0)
	{
		System.out.println ("Compras:");
		System.out.println ("\tIdCompra: " + this.IdCompra);
		System.out.println ("\tFecha: " + this.Fecha);
		System.out.println ("\tMontoTotal : " + this.MontoTotal );
		System.out.println ("\tIdProveedor : " + this.IdProveedor );
        System.out.println ("\tIdEmpleado : " + this.IdEmpleado );
	}
}

public void leerDatos()
{
	System.out.println ("Ingrese los datos de un Compra:");

	

	this.Fecha =leerConsola .LeerCadena("\tFecha: ", leerConsola.NoNulo);
	this.MontoTotal  = leerConsola.LeerEnteros("\tMontoTotal: ", 1, 100);
	this.IdProveedor  = leerConsola.LeerEnteros("\tIdProveedor: ", 1, 100);
    this.IdEmpleado  = leerConsola.LeerEnteros("\tIdEmpleado: ", 1, 100);
}


public void setFecha(String Fecha)
{
	this.Fecha = Fecha;
}

public void setMontoTotal (int MontoTotal )
{
    this.MontoTotal =MontoTotal ;
}

public void setIdProveedor (int IdProveedor )
{
    this.IdProveedor =IdProveedor ;
}

public void setIdEmpleado (int IdEmpleado )
{
    this.IdEmpleado =IdEmpleado ;
}

public int getIdCompra()
{
	return this.IdCompra;
}

public String getFecha()
{
    return this.Fecha;
}

public int getMontoTotal ()
{
    return this.MontoTotal ;
}

public int getIdProveedor ()
{
    return this.IdProveedor ;
}

public int getIdEmpleado ()
{
    return this.IdEmpleado ;
}

public void insertar(OperacionesSQL miSQL) throws SQLException
{


	String query = "INSERT INTO Compras ";
	query +=       "SET    Fecha = '" + this.getFecha() + "', ";
	query +=       "       MontoTotal  = '" + this.getMontoTotal () + "', ";
	query +=       "       IdProveedor  = '" + this.getIdProveedor () + "', ";
    query +=       "       IdEmpleado  = '" + this.getIdEmpleado ()+ "' ";

	miSQL.InsertarNuevo(query);

}

}

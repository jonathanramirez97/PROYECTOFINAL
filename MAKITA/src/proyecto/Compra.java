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

public Compra(int codigo, OperacionesSQL operacionesSQL) throws SQLException
{
	leerConsola = new LeerConsola();

	//miSQL.abrir();

	String query = "SELECT *  ";
	query +=       "FROM   Compras ";
	query +=       "WHERE  IdCompra = " + codigo;

	ResultSet rs = operacionesSQL.selectSQL(query);

	if (rs.next())
	{
		this.IdCompra = rs.getInt(1);
		this.Fecha = rs.getString(2);
		this.MontoTotal  = rs.getInt(3);
		this.IdProveedor  = rs.getInt(4);
        this.IdEmpleado =rs.getInt(5);
		
	}
	else
	{
		this.IdCompra = 0;
		this.Fecha="";
        this.MontoTotal =0;
        this.IdProveedor =0;
        this.IdEmpleado =0;
	}

	operacionesSQL.cerrar();

}

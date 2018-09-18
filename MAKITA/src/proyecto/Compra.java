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
